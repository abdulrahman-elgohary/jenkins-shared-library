def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}

    # Fetch latest changes
    git fetch origin

    # Stash any uncommitted changes before switching branches
    git stash --include-untracked

    # Switch to the correct branch
    git checkout ${envVars.branch}
    
    # Pull latest changes and rebase to avoid conflicts
    git pull --rebase origin ${envVars.branch}

    # Unstash the changes after pulling latest updates
    git stash pop || echo "No changes to unstash"

    # Stage and commit changes
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"

    # Push changes to the repository
    git push origin ${envVars.branch}
    """
}

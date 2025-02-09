def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}

    # Ensure we're on the correct branch
    git fetch origin
    git checkout ${envVars.branch}
    
    # Pull the latest changes with rebase to avoid conflicts
    git pull --rebase origin ${envVars.branch}
    
    # Apply any stashed changes if needed
    git stash pop || echo "No stash to pop"

    # Stage and commit changes
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"

    # Push changes to the repository
    git push origin ${envVars.branch}
    """
}

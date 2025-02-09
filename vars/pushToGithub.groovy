def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}

    # Fetch latest changes
    git fetch origin

    # Switch to the correct branch
    git checkout ${envVars.branch}
    
    # Pull latest changes and rebase to avoid conflicts
    git pull --rebase origin ${envVars.branch}
    
    # Stage and commit changes
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"

    # Push changes to the repository
    git push origin ${envVars.branch}
    """
}

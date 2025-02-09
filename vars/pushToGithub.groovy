def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}

    # Ensure we're on the correct branch
    git pull origin ${envVars.branch}
    
    # Stage and commit changes
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"

    # Push changes to the repository
    git push origin ${envVars.branch}
    """
}

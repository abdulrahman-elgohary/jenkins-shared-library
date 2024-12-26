def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git add .
    git commit -m "Automated commit by Jenkins" || echo "No changes to commit"
    git push origin ${envVars.branch}
    """
}

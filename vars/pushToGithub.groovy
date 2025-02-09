def call(Map envVars) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git remote set-url origin ${envVars.gitRepo}
    git checkout ${envVars.branch}
    git pull origin ${envVars.branch}
    git add .
    git commit -m "Automated commit by Jenkins [ci skip]" || echo "No changes to commit"
    git push origin ${envVars.branch}
    """
}

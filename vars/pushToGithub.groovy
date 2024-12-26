def call(Map envVars) {
    // Extract parameters from the map with defaults
    withCredentials(credentialsId: envVars.registryCredentials, branch: envVars.branch) {
    sh """
    git config user.name "${envVars.githubUsername}"
    git config user.email "${envVars.githubEmail}"
    git add .
    git commit -m "Automated commit by Jenkins"
    git push origin ${envVars.branch}
    """
    }
}

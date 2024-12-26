def call(Map envVars) {
    echo 'Pushing the new deployment file to Github...'
    withCredentials([usernamePassword(credentialsId: envVars.registryCredentials, usernameVariable: 'GITHUB_USERNAME', passwordVariable: 'GITHUB_PASSWORD')]) {
        sh """
        git config --global user.email "enVars.githubEmail"
        git config --global user.name "enVars.githubUsername"
        git switch main
        git add .
        git commit -m "Update Deployment File with new Image"
        git push origin main
        """
    }
}
    

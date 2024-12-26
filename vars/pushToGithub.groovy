def call(Map envVars) {
    echo 'Pushing the new deployment file to Github...'
    withCredentials([usernamePassword(credentialsId: envVars.registryCredentials, usernameVariable: 'GITHUB_USERNAME', passwordVariable: 'GITHUB_PASSWORD')]) {
        sh """
            git config --global user.email "${envVars.githubEmail}"
            git config --global user.name "${envVars.githubUsername}"
            
            # Update the remote URL to include credentials
            git remote set-url origin https://${GITHUB_USERNAME}:${GITHUB_PASSWORD}@github.com/${envVars.githubUsername}/${envVars.repoName}.git
            
            git switch main
            git add .
            git commit -m "Update Deployment File with new Image"
            git push origin main
        """
    }
}

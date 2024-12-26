def call(Map envVars) {
    echo 'Pushing the new deployment file to Github...'
    withCredentials([usernamePassword(credentialsId: envVars.registryCredentials, usernameVariable: 'GITHUB_USERNAME', passwordVariable: 'GITHUB_TOKEN')]) {
        sh """
            # Configure git
            git config --global user.email "${envVars.githubEmail}"
            git config --global user.name "${envVars.githubUsername}"
            
            # Stash any changes first
            git stash
            
            # Checkout main branch
            git checkout main
            
            # Pop the stashed changes
            git stash pop
            
            # Add and commit changes
            git add .
            git commit -m "Update Deployment File with new Image"
            
            # Push to main with credentials explicitly provided
            git push https://github.com/${envVars.githubUsername}/${envVars.repoName}.git main
        """
    }
}

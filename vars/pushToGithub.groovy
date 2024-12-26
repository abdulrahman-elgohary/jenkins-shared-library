def call(Map envVars) {
    echo 'Pushing the new deployment file to Github...'
        sh """
        git add .
        git commit -m "Update Deployment File with new Image"
        git push origin main
        """
}

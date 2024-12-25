def call(Map envVars) {
    echo 'Building the Image from dockerfile...'
    sh "docker build -t ${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber} ."

    echo 'Pushing Docker image to registry...'
    withCredentials([usernamePassword(credentialsId: envVars.registryCredentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
        echo "${DOCKER_PASSWORD}" | docker login -u "${DOCKER_USERNAME}" --password-stdin
        docker push ${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber}
        """
    }
}

def call(Map envVars) {
    echo 'Building the Image from dockerfile...'
    dir('FinalProjectCode') {
    sh "docker build -t ${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber} ."
    }
    echo 'Updating deployment file and Pushing Docker image to registry...'
    withCredentials([usernamePassword(credentialsId: envVars.registryCredentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
    dir('FinalProjectCode') {   
        sh """
        sed -i 's|<IMAGE_PLACEHOLDER>|${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber}|g' deployment.yml
        echo "${DOCKER_PASSWORD}" | docker login -u "${DOCKER_USERNAME}" --password-stdin
        docker push ${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber}
        docker rmi ${envVars.docker_hub_username}/${envVars.imageName}:${envVars.buildNumber}
        """
    }
    }
}

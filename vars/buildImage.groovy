def call(Map envVars) {
    echo 'Building the Image from dockerfile...'
    sh "docker build -t ${envVars.docker_hub_username}/${envVars.imageName}:${buildNumber} ."
}

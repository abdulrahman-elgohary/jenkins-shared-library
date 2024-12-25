def call(Map envVars) {
    sh "docker build -t ${envVars.docker_hub_username}/${envVars.imageName}:${buildNumber} ."
}

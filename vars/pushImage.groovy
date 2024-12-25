def call(String imageName) {
    withDockerRegistry([credentialsId: 'docker-cred-id', url: 'https://registry-url']) {
        sh "docker push ${imageName}"
    }
}

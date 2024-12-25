def call(Map envVars) {
    // SonarQube Test
    echo 'Running SonarQube analysis...'
    withSonarQubeEnv(envVars.sonarQubeServer) {
            sh '''
             chmod +x ./gradlew
            ./gradlew sonarqube
            '''
    }
}

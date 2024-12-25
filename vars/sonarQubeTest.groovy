def call(Map envVars) {
    // SonarQube Test
    echo 'Running SonarQube analysis...'
    withSonarQubeEnv(envVars.sonarQubeServer) {
            sh '''
            ./gradlew clean build
            ./gradlew sonarqube
            '''
    }
}

def call(Map envVars) {
    // SonarQube Test
    echo 'Running SonarQube analysis...'
    withSonarQubeEnv(envVars.sonarQubeServer) {
        dir('FinalProjectCode') {
            sh '''
            ./gradlew sonar
            '''
        }
    }
}

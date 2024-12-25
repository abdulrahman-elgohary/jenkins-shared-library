def call() {
    echo 'Running unit tests...'
    dir('FinalProjectCode') {
        sh 'chmod +x ./gradlew'
        sh './gradlew test'
    }
}

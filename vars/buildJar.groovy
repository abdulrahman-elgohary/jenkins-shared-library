def call() {
    echo 'Buliding the code...'
    dir('FinalProjectCode') {
    sh './gradlew build --stacktrace'
  }
}

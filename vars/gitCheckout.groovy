def call(String repoUrl, String branch) {
    echo 'Checking out repository...'
    checkout scm: [$class: 'GitSCM', branches: [[name: branch]], userRemoteConfigs: [[url: repoUrl]]]
}

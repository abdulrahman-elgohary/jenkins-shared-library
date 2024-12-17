def call(Map config) {
    pipeline {
        agent any
        
        stages {
            stage('Deploy to Namespace') {
                steps {
                    script {
                        def k8sDeployer = new org.example.K8sDeployment()
                        k8sDeployer.deploy(config.namespace, config.environment)
                    }
                }
            }
        }
    }
}

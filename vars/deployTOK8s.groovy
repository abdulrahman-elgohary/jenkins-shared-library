def call(Map config) {
    // Defines a reusable pipeline method that can be called from Jenkinsfile
    pipeline {
        agent any  // Can run on any available agent
        
        stages {
            stage('Deploy to Namespace') {
                steps {
                    script {
                        // Creates an instance of K8sDeployment class
                        def k8sDeployer = new org.example.K8sDeployment()
                        
                        // Calls deploy method with namespace and environment
                        k8sDeployer.deploy(config.namespace, config.environment)
                    }
                }
            }
        }
    }
}

package org.example  // Package declaration for organization

class K8sDeployment {
    def deploy(String namespace, String environment) {
        // Method to handle Kubernetes deployment
        sh """
            # Switch to correct Kubernetes context
            kubectl config use-context your-k8s-context
            
            # Apply deployment to specific namespace
            kubectl apply -f deployment.yaml -n ${namespace}
        """
    }
}

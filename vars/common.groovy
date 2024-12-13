
def printMessage(String message) {
         echo "Shared Library Message: ${message}"
     }

     def buildDockerImage(String imageName, String dockerfilePath = '.') {
         sh "docker build -t ${imageName} ${dockerfilePath}"
     }

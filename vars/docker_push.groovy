def call(String Project, String ImageTag, String dockerHubUser) {
    echo "Pushing ${dockerHubUser}/${Project}:${ImageTag} to DockerHub"
    
    withCredentials([usernamePassword(
        credentialsId: "dockerHubCred",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker tag ${Project}:latest ${dockerHubUser}/${Project}:${ImageTag}"
        sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
        sh "docker logout"
    }
}

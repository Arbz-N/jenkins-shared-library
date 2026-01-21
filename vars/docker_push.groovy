def call(String Project, String ImageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId: "dockerHubCred",passwordVariable: "dockerHubPass",usernameVariable: "dockerHubUser")])
  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
  sh "docker logout"
}

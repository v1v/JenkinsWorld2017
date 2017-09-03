/*
* List what Projects are Maven types
*/

jenkins.model.Jenkins.instance?.
  getAllItems(hudson.maven.MavenModuleSet.class)?.
  each {
    println "'${it.fullName}' is a Maven Project!"
  }

println '' // Avoid printing the data from the latest closure

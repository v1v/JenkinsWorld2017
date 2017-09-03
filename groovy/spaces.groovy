/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Space Best Practice
*/

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { it.name.contains(' ') }?.
  each {
    println "'${it.fullName}' contains spaces!"
  }

println '' // Avoid printing the data from the latest closure

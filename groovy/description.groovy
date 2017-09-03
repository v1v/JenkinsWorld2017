/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Description Best Practice
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractItem.html#getDescription
*/

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { !it.getDescription() }?.
  each {
    println "'${it.fullName}' doesn't explain what it does..."
  }

println '' // Avoid printing the data from the latest closure

/*
* List what Jobs don't follow the Clean Workspace Best Practice
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/Job.html#getBuildDiscarder
*/

jenkins.model.Jenkins.instance?.
  getAllItems(Job.class)?.
  each {
    found = true
    if (it.getBuildDiscarder() )
      found = it.getBuildDiscarder().getArtifactDaysToKeep() < 0 &&
              it.getBuildDiscarder().getArtifactNumToKeep() < 0 &&
              it.getBuildDiscarder().getDaysToKeep() < 0 &&
              it.getBuildDiscarder().getNumToKeep() < 0
    if (found)
      println "'${it.fullName}' doesn't have any log rotator configuration"
  }

println '' // Avoid printing the data from the latest closure

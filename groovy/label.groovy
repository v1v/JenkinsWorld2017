/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Label Best Practice
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getAssignedLabel
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getAssignedLabel
*/

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { !it.getAssignedLabel() }?.
  each {
    println "'${it.fullName}' doesn't have any assigned agent/label"
  }

println '' // Avoid printing the data from the latest closure

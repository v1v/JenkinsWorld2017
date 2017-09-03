/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Pushing Best Practice
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getTrigger-java.lang.Class-
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getTriggers--
*/

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  each {
    try {
      if (it.getTrigger(hudson.triggers.SCMTrigger.class) ) {
         println "'${it.fullName}' is polling!"
      }
    } catch (groovy.lang.MissingMethodException mme) { } // Skip items without build discarder method
  }

println '' // Avoid printing the data from the latest closure

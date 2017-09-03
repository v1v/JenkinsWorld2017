/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Pushing Best Practice and notify as a Warning Description
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getTrigger-java.lang.Class-
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getTriggers--
*/

def message = '''<div class="alert alert-warning">
                 <strong>Warning!</strong> Git+Polling is deprecated. This job will be disabled from 1st, May
                 </div>'''

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  each {
    try {
      if (it.getTrigger(hudson.triggers.SCMTrigger.class) ) {
        println "INFO '${it.fullName}' is polling!"
        if (!it.getDescription().toLowerCase().contains('git+polling')) {
          it.setDescription(it.getDescription() + message)
        }
      }
    } catch (groovy.lang.MissingMethodException mme) { } // Skip items without build discarder method
  }

println '' // Avoid printing the data from the latest closure

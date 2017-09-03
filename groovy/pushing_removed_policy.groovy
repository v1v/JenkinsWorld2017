/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Pushing Best Practice and disable those projects.
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getTrigger-java.lang.Class-
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getTriggers--
*/

def message = '''<div class="alert alert-warning">
                <strong>Important! Git+Polling is not supported</strong>. Please read this <a href=http://>page</a>
                 </div>'''

jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { !it.isDisabled() }.  // Skip disabled jobs by default
  each {
    try {
      if (it.getTrigger(hudson.triggers.SCMTrigger.class) ) {
        println "INFO '${it.fullName}' is polling!"
        it.setDescription(it.getDescription() + message)
        it.disable()
      }
    } catch (groovy.lang.MissingMethodException mme) { } // Skip items without build discarder method
  }

println '' // Avoid printing the data from the latest closure

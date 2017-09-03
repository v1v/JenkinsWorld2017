/*
* List what Pipelines are not using Groovy Sandbox
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getPublishersList--
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getDefinition--
*/

jenkins.model.Jenkins.instance?.
  getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob.class)?.
  findAll { !it.getDefinition()?.isSandbox() }?.
  each {
    println "Pipeline -> '${it.name}' doesn't use Groovy Sandbox"
  }

println '' // Avoid printing the data from the latest closure

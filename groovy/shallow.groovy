/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Shallow Best Practice
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getScm--
* - http://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html#getSCMs--
* - http://javadoc.jenkins-ci.org/git/hudson/plugins/git/extensions/impl/CloneOption.html#isShallow()
*/

import hudson.plugins.git.extensions.impl.CloneOption
jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { try { it.getScm() } catch (groovy.lang.MissingMethodException mme) {} }?.
  findAll { it.getScm() instanceof hudson.plugins.git.GitSCM }?.
  each {
    isShallow = false
    if (it.getScm().getExtensions() && it.getScm().getExtensions()?.
                                         find {
                                           it instanceof CloneOption &&
                                           it.isShallow()
                                         }
       ) {
      isShallow = true
    }
    if (!isShallow)
      println "'${it.fullName}' is not using shallow cloning"
  }

println '' // Avoid printing the data from the latest closure

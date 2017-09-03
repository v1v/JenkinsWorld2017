/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Git Reference Best Practice.
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getScm--
* - http://javadoc.jenkins-ci.org/git/hudson/plugins/git/extensions/impl/CloneOption.html#getReference()
*/

import hudson.plugins.git.extensions.impl.CloneOption
jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll { it.getScm().getType().toLowerCase().contains('git') }?.
  each { job ->
    if (job.scm.getExtensions().empty) { // When no options
      println "'${job.fullName}' is not using Git Reference Repo"
    }
    job.scm.getExtensions()?.findAll { it instanceof CloneOption }.each { p ->
      if (!p.getReference().trim()){
        println "'${job.fullName}' is not using Git Reference Repo"
      }
    }
  }

println '' // Avoid printing the data from the latest closure

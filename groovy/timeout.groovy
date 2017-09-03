/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the TimeOut Best Practice
*/

import hudson.plugins.build_timeout.BuildTimeoutWrapper
jenkins.model.Jenkins.instance?.
  getAllItems()?.
  findAll {
    try {
      !it.getBuildWrappers()?.find { k,v -> v instanceof BuildTimeoutWrapper }
    } catch (groovy.lang.MissingMethodException mee) {} // avoid items without getBuildWrappers
  }?.
  each {
    println "'${it.fullName}' doesn't use Build Timeout Plugin"
  }

println '' // Avoid printing the data from the latest closure

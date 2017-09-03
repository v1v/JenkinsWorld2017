/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Clean Workspace Best Practice
*/

import hudson.plugins.git.extensions.impl.WipeWorkspace
jenkins.model.Jenkins.instance?.
getAllItems()?.
  findAll {
    !(it.getPublishersList()?.find {it.getClass().getName().contains('WsCleanup')}) &&
    !(it.getBuildWrappers()?.find{ k,v -> k.getClass().getName().contains('PreBuildCleanup') } != null ) &&
    !(it.scm && it.scm.getClass().getName().contains('hudson.plugins.git.GitSCM') &&
         it.scm.getExtensions()?.find { it instanceof WipeWorkspace } != null )
  }?.
  each {
    println "'${it.fullName}' is not cleaning up its workspace"
  }

println '' // Avoid printing the data from the latest closure

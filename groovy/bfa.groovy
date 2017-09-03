/*
* List what Items (Folder, FreeStylejob, Pipeline, Multijob, MavenJobs... ) don't
* follow the Build Failure Analyser Best Practice
*/

import com.sonyericsson.jenkins.plugins.bfa.model.ScannerJobProperty
jenkins.model.Jenkins.instance?.
  getAllItems()?.
  each {
    def bfa = it.getAllProperties()?.find { prop -> prop instanceof ScannerJobProperty }
    if (!bfa || bfa?.isDoNotScan()) {
      println "'${it.fullName}' is not using BFA"
    }
  }

println '' // Avoid printing the data from the latest closure

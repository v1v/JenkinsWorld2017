/*
* List what AbstractProjects with Groovy PostBuild actions use system.exit
*
* Further details:
* - http://javadoc.jenkins-ci.org/hudson/model/AbstractProject.html#getPublishersList--
*/

jenkins.model.Jenkins.instance?.
  getAllItems(AbstractProject.class)?.
  findAll { it.getPublishersList() &&
            it.getPublishersList().
            findAll { it.getClass().getName().endsWith('GroovyPostbuildRecorder') &&
                      it.getScript()?.getScript()?.toLowerCase().contains('system.exit')}
  }?.each {
    println "'${it.fullName}' is using System Exit"
  }

println '' // Avoid printing the data from the latest closure

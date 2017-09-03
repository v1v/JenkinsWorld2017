# Jenkins World 2017

This talk was presented during Jenkins World 2017 in San Francisco, CA on August 29th-31st.

## Presentation

[2017_Jenkins_World_VictorMartinez.pdf](2017_Jenkins_World_VictorMartinez.pdf) contains the slides of the presentation.

*NOTE*: The presentation was recorded although the video URL hasn't been released yet.

## Best Practices

You can find some example groovy scripts to analyse what Jenkins projects don't follow those practices.

It does use the internal Jenkins API and therefore you need to be cautious to avoid doing evil things:

* http://unethicalblogger.com/2017/08/03/donut-disable-groovy-sandbox.html

Bear in mind, some of those scripts are just read only but others are also adding some details in the project description and also disabling those jobs.

This groovy implementation is just a basic/simple implementation, it might not cover all the use cases. The final solution was implemented as a Jenkins Plugin called Jenkins Lint plugin.

* [Example 1](groovy/description.groovy) - shows list of projects without any description
* [Example 2](groovy/spaces.groovy) - shows list of projects with whitespaces in their name
* [Example 3](groovy/label.groovy) - shows list of projects without any label restriction
* [Example 4](groovy/workspace.groovy) - shows list of projects without any workspace cleanup policy
* [Example 5](groovy/logrotator.groovy) - shows list of projects without any log rotator policy or empty values
* [Example 6](groovy/pushing.groovy) - shows list of projects using polling
* [Example 7](groovy/shallow.groovy) - shows list of projects which use git but no shallow cloning
* [Example 8](groovy/reference.groovy) - shows list of projects which use git but no git reference repos
* [Example 9](groovy/system_exit.groovy) - shows list of Projects which some system exit when using groovy post build actions
* [Example 10](groovy/groovy_sandbox.groovy) - shows list of pipelines without the groovy sandbox option
* [Example 11](groovy/maven.groovy) - shows list of Maven job types
* [Example 12](groovy/timeout.groovy) - shows list of projects which don't use the Build Timeout plugin
* [Example 13](groovy/bfa.groovy) - shows list of projects which don't use the Build Failure plugin

### How to run them

* Open the script console page: This feature can be accessed from the "manage Jenkins" link, typically at your http://server/jenkins/script.   [ScriptConsole Wiki](https://wiki.jenkins.io/display/JENKINS/Jenkins+Script+Console)
* Copy one of those groovy Script and paste in the script console text area.
* Run and look at the output.

## Further details
For more information on JenkinsLint, please visit [JenkinsLint](https://plugins.jenkins.io/jenkinslint).

There are even further examples of using the internal Jenkins API in the below links:
* https://github.com/jenkinsci/jenkins-scripts/tree/master/scriptler

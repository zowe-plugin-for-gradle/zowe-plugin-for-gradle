# Zowe Plugin for Gradle

The Zowe Plugin for Gradle provides a set of tasks to automate build and deployment of z/OS applications
using Gradle scripts. It relies on commands provided by the [Zowe CLI](https://github.com/zowe/zowe-cli) 
to interact with mainframe APIs, such as the *z/OSMF files* and *z/OSMF jobs* REST APIs. 

The plugin is available on Gradle's Plugin Portal. You can apply it to any of your Gradle 
projects by including the following in your *gradle.script* file:

```
    plugins {  
        id "org.zowe.gradle.plugin" version "1.0.0-SNAPSHOT"  
    }     
```

### Sample z/OS build automation tasks using Zowe Gradle Plugin
<img alt="Sample tasks" src="https://user-images.githubusercontent.com/62293079/76912189-fdb7b880-6880-11ea-96d4-2e0382cd1e0a.png">

### Most common use cases
* Deploy JARs and other artifacts to z/OS
* Upload and build native application components on z/OS
* Start and stop z/OS services

### Resources
* [Zowe Gradle Plugin (Gradle Plugin Portal)](https://plugins.gradle.org/plugin/org.zowe.gradle.plugin)
* [Example Applications of the Zowe Plugin for Gradle](https://github.com/zowe-plugin-for-gradle/zowe-plugin-for-gradle)
* [Zowe CLI Command Reference](https://docs.zowe.org/stable/web_help/index.html)

package org.zowe.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

class ZoweSubmitJob extends DefaultTask {

    @Input
    String jclDataSetName

    @Optional @Input
    Boolean waitForCompletion 

    @TaskAction
    def issueCommand() {
        JobSubmitter submitter = JobSubmitterFactory.createJobSubmitter()
        submitter.submitJob(jclDataSetName, waitForCompletion)
    }
}

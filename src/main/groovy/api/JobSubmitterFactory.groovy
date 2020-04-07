package org.zowe.gradle.plugin

class JobSubmitterFactory {

    public static JobSubmitter createJobSubmitter() {
        return new CLIJobSubmitter()
    }
}

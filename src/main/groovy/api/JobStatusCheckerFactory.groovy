package org.zowe.gradle.plugin

class JobStatusCheckerFactory {

    public static JobStatusChecker createJobStatusChecker() {
        return new CLIJobStatusChecker()
    }
}

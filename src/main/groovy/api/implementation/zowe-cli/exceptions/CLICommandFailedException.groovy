package org.zowe.gradle.plugin

import org.gradle.api.GradleException

class CLICommandFailedException extends GradleException {

    public CLICommandFailedException(String message) {
        super(message)
    }

    public CLICommandFailedException(String message, Throwable cause) {
        super(message,cause)
    }
}

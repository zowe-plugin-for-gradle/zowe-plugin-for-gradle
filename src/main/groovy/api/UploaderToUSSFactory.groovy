package org.zowe.gradle.plugin

class UploaderToUSSFactory {

    public static UploaderToUSS createUploader() {
        return new CLIUploaderToUSS()
    }
}

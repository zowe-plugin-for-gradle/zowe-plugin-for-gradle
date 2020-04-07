package org.zowe.gradle.plugin

interface UploaderToUSS {

    public void upload(File sourceFile, File targetFile, Boolean binary)
}

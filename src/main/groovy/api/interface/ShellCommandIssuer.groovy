package org.zowe.gradle.plugin

interface ShellCommandIssuer {

    public void issue(String command, String workingDir)
}

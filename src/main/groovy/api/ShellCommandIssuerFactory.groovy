package org.zowe.gradle.plugin

class ShellCommandIssuerFactory {

    public static ShellCommandIssuer createShellCommandIssuer() {
        return new CLIShellCommandIssuer()
    }
}

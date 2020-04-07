package org.zowe.gradle.plugin

class ZosCommandIssuerFactory {

    public static ZosCommandIssuer createZosCommandIssuer() {
        return new CLIZosCommandIssuer()
    }
}

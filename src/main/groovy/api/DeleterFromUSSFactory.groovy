package org.zowe.gradle.plugin

class DeleterFromUSSFactory {

    public static DeleterFromUSS createDeleter() {
        return new CLIDeleterFromUSS()
    }
}

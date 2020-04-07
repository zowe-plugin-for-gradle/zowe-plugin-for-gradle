package org.zowe.gradle.plugin

class DownloaderFromUSSFactory {

    public static DownloaderFromUSS createDownloader() {
        return new CLIDownloaderFromUSS()
    }
}

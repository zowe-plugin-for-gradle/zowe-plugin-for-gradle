package org.zowe.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.file.FileTree


class ZoweDownloadFromUSS extends DefaultTask {    

    @InputFiles
    FileTree filesToDownload
    
    @Input
    String downloadToDir

    @TaskAction
    def downloadFiles() {
        filesToDownload.each { File sourceFile ->
            File targetFile = new File(downloadToDir, sourceFile.getName())
            DownloaderFromUSS downloader = DownloaderFromUSSFactory.createDownloader()
            downloader.download(sourceFile, targetFile)
        }
    }
}

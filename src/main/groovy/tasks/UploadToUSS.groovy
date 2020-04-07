package org.zowe.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Optional
import org.gradle.api.file.FileTree
import org.gradle.api.file.FileType
import org.gradle.work.Incremental
import org.gradle.work.InputChanges

class ZoweUploadToUSS extends DefaultTask {    
    @Incremental

    @InputFiles
    FileTree filesToUpload
    
    @Input
    String uploadToDir

    @Optional
    @Input
    Boolean binary

    @TaskAction
    def uploadFiles(InputChanges inputChanges) {
        inputChanges.getFileChanges(filesToUpload).each() { change ->
            if (change.fileType == FileType.DIRECTORY) {
                return;
            }

            File sourceFile = change.getFile();
            File targetFile = new File(uploadToDir, sourceFile.getName())

            /* Upload files one by one */
            UploaderToUSS uploader = UploaderToUSSFactory.createUploader()
            uploader.upload(sourceFile, targetFile, binary)
        }
    }
}

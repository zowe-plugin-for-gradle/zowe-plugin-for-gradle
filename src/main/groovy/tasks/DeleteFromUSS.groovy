package org.zowe.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.file.FileTree

import org.gradle.api.GradleException

class ZoweDeleteFromUSS extends DefaultTask {    

    @InputFiles
    FileTree filesToDelete

    @TaskAction
    def deleteFiles() {
        filesToDelete.each { File file ->
            DeleterFromUSS deleter = DeleterFromUSSFactory.createDeleter()
            try {
                deleter.delete(file)
            } catch(Exception exception) {
                throw new GradleException('Failed to delete' + file.toString(), exception)
            }
        }
    }
}

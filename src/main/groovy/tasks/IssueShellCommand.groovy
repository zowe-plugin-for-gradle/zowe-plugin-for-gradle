package org.zowe.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.InvalidUserDataException


class ZoweIssueShellCommand extends DefaultTask {

    @Optional @Input
    String command

    @Optional @Input
    String[] commands

    @Optional @Input
    String workingDir

    @TaskAction
    def issueCommand() {
        ShellCommandIssuer issuer = ShellCommandIssuerFactory.createShellCommandIssuer()
        if (command) {
            issuer.issue(command, workingDir)
        } else if (commands) {
            commands.each { String command ->
                issuer.issue(command, workingDir)
            }
        } else {
            throw new InvalidUserDataException('You must input a command or a set of commands to issue')
        }
    }
}

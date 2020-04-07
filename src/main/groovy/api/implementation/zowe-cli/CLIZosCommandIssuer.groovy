package org.zowe.gradle.plugin

class CLIZosCommandIssuer implements ZosCommandIssuer {

    Process process

    @Override
    public void issue(String command) {
        ArrayList<String> args = new ArrayList<String>(List.of('zowe', 'console', 'issue', 'cmd', command))

        /* Start process */
        try {
            ProcessBuilder builder = new ProcessBuilder().command(args).redirectErrorStream(true)
            process = builder.start()
        } catch (IOException) {
            throw new CLICommandFailedException('Failed to start Zowe CLI')
        }

        /* Print process output */
        PrintOutput.printToStdout(process.getInputStream())

        /* Wait for process to finish and check exit value */
        process.waitFor()
        if (process.exitValue() != 0) {
            throw new CLICommandFailedException("Zowe CLI command returned with rc=" + process.exitValue())
        }
    }
}

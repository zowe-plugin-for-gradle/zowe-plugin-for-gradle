package org.zowe.gradle.plugin

class CLIJobSubmitter implements JobSubmitter {

    Process process

    @Override
    public void submitJob(String jcl, Boolean waitForCompletion) {
        ArrayList<String> args = new ArrayList<String>(List.of('zowe', 'jobs', 'submit', 'data-set', jcl))

        /* Start process */
        try{
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

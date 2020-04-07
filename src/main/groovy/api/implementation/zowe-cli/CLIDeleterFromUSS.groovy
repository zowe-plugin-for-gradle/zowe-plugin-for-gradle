package org.zowe.gradle.plugin

class CLIDeleterFromUSS implements DeleterFromUSS {

    Process process

    @Override
    public void delete(File file) {
        ArrayList<String> args = new ArrayList<String>(List.of('zowe', 'files', 'delete', 'uss-file', file.toString(), "--for-sure"))

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

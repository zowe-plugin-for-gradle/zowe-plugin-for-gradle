package org.zowe.gradle.plugin

class CLIUploaderToUSS implements UploaderToUSS {

    Process process

    @Override
    public void upload(File sourceFile, File targetFile, Boolean isBinary) {
        ArrayList<String> args = new ArrayList<String>(List.of('zowe', 'files', 'upload', 'file-to-uss'))        

        args.add(sourceFile.toString())
        args.add(targetFile.toString())

        if (isBinary) {
            args.add('--binary')
        }
   
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
            throw new CLICommandFailedException('Zowe CLI command returned with rc=' + process.exitValue())
        }
    }
}

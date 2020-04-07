package org.zowe.gradle.plugin

class PrintOutput {
    
    static void printToStdout(InputStream stream) {
        InputStreamReader streamReader = new InputStreamReader(stream)
        BufferedReader bufferedReader = new BufferedReader(streamReader)

        String line
        while (line = bufferedReader.readLine()) {
            println line
        }
    }
}

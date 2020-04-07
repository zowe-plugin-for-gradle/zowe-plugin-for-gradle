package org.zowe.gradle.plugin

interface JobSubmitter {

    public void submitJob(String jcl, Boolean waitForCompletion)
}

package org.zowe.gradle.plugin

import org.glassfish.jersey.client.JerseyClient
import org.glassfish.jersey.client.JerseyWebTarget
import org.glassfish.jersey.client.ClientResponse

class NativeHttpUploaderToUSS implements UploaderToUSS {

    public void upload(File sourceFile, File targetFile, Boolean isBinary) {
        JerseyClient client = JerseyClient.create();
        JerseyWebTarget target = client.target('');
        
    	//Builder requestBuilder = webTarget.request('application/json');
    }
}

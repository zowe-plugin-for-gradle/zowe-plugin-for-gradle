package org.zowe.gradle.plugin 

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class TestZowePluginForGradle {

    @Test
    public void testZowePluginForGradle() {
        Project project = ProjectBuilder.builder().build()

        project.pluginManager.apply('org.zowe.gradle.plugin')
    }
}

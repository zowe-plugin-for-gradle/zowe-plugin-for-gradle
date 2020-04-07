package org.zowe.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ZowePluginForGradle implements Plugin<Project> {

    protected static final String PLUGIN_NAME = ZowePluginForGradle.class.getSimpleName()
    protected static final String PLUGIN_ID = 'com.zowe.gradle.plugin'
    protected static final String DESCRIPTION = ' '

    @Override
    void apply(final Project project) {

    }
}

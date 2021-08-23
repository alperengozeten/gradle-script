package com.github.alperengozeten

import org.gradle.api.Plugin
import org.gradle.api.Project

public class GeneratePlugin implements Plugin<Project> {
    @Override
    public void apply(Project projectHere) {

        projectHere.tasks.register("generate", SwaggerCodegenTask) {
            project = projectHere
        }
    }
}

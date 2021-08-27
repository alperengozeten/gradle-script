package com.carbonhealth.foundations

import io.swagger.codegen.SwaggerCodegen
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

public class SwaggerCodegenTask extends DefaultTask {

    // Options
    private String path
    private String language
    private String outputPath
    private Boolean generateUnboundMethods

    @Input
    Project project

    // The language, "java" or "kotlin"
    @Option(option = "language", description = "The language (java or kotlin).")
    public void setLanguage(String language) {
        this.language = language;
    }

    // Path to the protos folder
    @Option(option = "protos_path", description = "The path to the protos folder (including the folder name).")
    public void setPath(String path) {
        this.path = path;
    }

    // Output path
    @Option(option = "output_path", description = "The path to the output folder.")
    public void setOutPutPath(String outputPath) {
        this.outputPath = outputPath;
    }

    // If provided, then generates the definitions for methods without HTTP annotations as well
    @Option(option = "generate_unbound_methods", description = "Whether to generate methods with no HTTP annotations or not")
    public void setGenerateUnboundMethods(Boolean generateUnboundMethods) {
        this.generateUnboundMethods = generateUnboundMethods;
    }

    @TaskAction
    public void generate() {

        // Create a new template engine
        def engine = new groovy.text.SimpleTemplateEngine()

        // Generate path to the protos folder
        def protoText = '${insertPath}'
        def protoBinding = ["insertPath":path]
        def protoTemplate = engine.createTemplate(protoText).make(protoBinding)
        def protoPath = protoTemplate.toString()

        // Path to the generated swagger file
        def jsonText = '${insertPath}/generated/apidocs.swagger.json'
        def jsonBinding = ["insertPath":path]
        def jsonTemplate = engine.createTemplate(jsonText).make(jsonBinding)
        def jsonPath = jsonTemplate.toString()

        // Path to the "generated" folder inside go/src to store .swagger file
        def generateFolderText = '${insertPath}/generated'
        def generateFolderBinding = ["insertPath":path]
        def generateFolderTemplate = engine.createTemplate(generateFolderText).make(generateFolderBinding)
        def generateFolderPath = generateFolderTemplate.toString()

        // This file is to store the swagger files
        def generateFolder = new File(generateFolderPath)

        if ( !generateFolder.exists() ) {
            generateFolder.mkdirs()
        }

        // project.exec does not recognize the outputPath which is defined outside of this method
        def outputFolderPath = outputPath

        // project.exec does not recognize the generateUnboundMethods which is defined outside of this method
        def isGenerateUnboundMethods = generateUnboundMethods

        // Generate the swagger file (OpenAPI) first
        project.exec {
            workingDir('src/main/resources')

            // We will use a list to add all the necessary arguments
            List<String> arguments = new ArrayList<>()

            // MIGHT NOT WORK FOR MAC OS BECAUSE OF "/c"
            arguments.add('cmd');
            arguments.add('/c');
            arguments.add('protoc.exe');
            arguments.add('--openapiv2_out');
            arguments.add(generateFolderPath);
            arguments.add('--openapiv2_opt');
            arguments.add('logtostderr=true');
            arguments.add('--openapiv2_opt');
            arguments.add('allow_merge=true');
            arguments.add('--openapiv2_opt');
            arguments.add('simple_operation_ids=true')
            arguments.add('--openapiv2_opt');
            arguments.add('include_package_in_tags=true')

            // If selected, generate methods without HTTP annotations
            if ( isGenerateUnboundMethods ) {
                arguments.add('--openapiv2_opt');
                arguments.add('generate_unbound_methods=true')
            }
            arguments.add('--proto_path');
            arguments.add(protoPath);

            // Pick all the .proto files under the com/carbonhealth directory
            FileTree tree = project.fileTree(protoPath).include('**/com/carbonhealth/**')

            // Add them to the arguments list
            tree.each { aFile ->

                String pathProto = protoPath;

                // Create a StringBuilder since we will make some modifications
                StringBuilder sb = new StringBuilder(aFile.path.substring(pathProto.length() + 1))

                int length = sb.length()

                // Convert the back-slashes to slashes
                for (int i = 0; i < length; i++) {
                    if (sb.charAt(i) == '\\' as char) {
                        sb.setCharAt(i, '/' as char)
                    }
                }

                arguments.add(sb.toString())
            }

            // Call the command
            commandLine(arguments)
        }
        
        // If the language is kotlin
        if ( language.toLowerCase() == "kotlin" ) {

            // Call the Swagger-Codegen
            String[] argumentsForMain = ["generate", "-i", jsonPath , "-l", "kotlin-armeria", "-o", outputFolderPath]
            SwaggerCodegen.main(argumentsForMain)
            println('\n Kotlin-Armeria server is succesfully generated!')
        }


        // If the language is java
        else if ( language.toLowerCase() == "java" ) {

            // Call the Swagger-Codegen
            String[] argumentsForMain = ["generate", "-i", jsonPath , "-l", "java-armeria", "-o", outputFolderPath]
            SwaggerCodegen.main(argumentsForMain)
            println('\n Java-Armeria server is succesfully generated!')
        }

        else {
            println('Select "java" or "kotlin" as --language')
        }
    }
}
package com.carbonhealth.foundations

import io.swagger.codegen.SwaggerCodegen

class Main {
    static void main(String[] args) {
        String[] argumentsForMain = ["generate", "-i", "C:/Users/HP/go/src/generated/apidocs.swagger.json" , "-l", "kotlin-armeria", "-o", "C:/Users/HP/IdeaProjects/gradle-script/generated/kotlin"]
        SwaggerCodegen.main(argumentsForMain)
    }
}

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/5.2.1/userguide/tutorial_java_projects.html
 */

plugins {
    id("org.springframework.boot") version "2.1.5.RELEASE"

    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building an application
    application

    checkstyle
}

apply(plugin = "io.spring.dependency-management")

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

val checkstyleConfig by configurations.creating

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    // This dependency is found on compile classpath of this component and consumers.
    implementation("com.google.guava:guava:27.0.1-jre")

    compile("org.springframework.boot:spring-boot-starter-security")
    compile("com.auth0:java-jwt:3.4.0")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")

    // https://mvnrepository.com/artifact/org.modelmapper/modelmapper
    implementation("org.modelmapper:modelmapper:2.3.4")

    compile("io.springfox:springfox-swagger2:2.9.2")
    compile("io.springfox:springfox-swagger-ui:2.9.2")

    checkstyleConfig("com.puppycrawl.tools:checkstyle:8.21") {
        isTransitive = false
    }


}

checkstyle {
    toolVersion = "8.21" // TODO: Extract version into a variable
    config = resources.text.fromArchiveEntry(checkstyleConfig, "google_checks.xml")
    maxWarnings = 0
}

application {
    // Define the main class for the application
    mainClassName = "backend.App"
}

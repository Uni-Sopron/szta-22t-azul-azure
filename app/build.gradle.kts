/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.3/userguide/building_java_projects.html
 */

 repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}


plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    pmd
    jacoco
    id("io.freefair.aggregate-javadoc") version "6.4.1"
}


dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation("org.mockito:mockito-core:3.+")
    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("azul.App")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "azul.App"
    }
}

tasks.register<JavaExec>("runWithJavaExec") {
    description = "Run the main class with JavaExecTask"
    mainClass.set("azul.App")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}



tasks.register<Copy>("collectJacoco") {
    dependsOn("jacocoTestReport")
    from(layout.buildDirectory.dir("reports/jacoco/test/html"))
    include("*")
    include("/**")
    into(layout.buildDirectory.dir("doc/jacoco"))
}
tasks.register<Copy>("collectPMD") {
    from(layout.buildDirectory.dir("reports/pmd"))
    include("*")
    include("/**")
    into(layout.buildDirectory.dir("doc/pmd"))
}
tasks.register<Copy>("collectJavadoc") {
    dependsOn("aggregateJavadoc")
    from(layout.buildDirectory.dir("docs/aggregateJavadoc"))
    include("*")
    include("/**")
    into(layout.buildDirectory.dir("doc/javadoc"))
}

tasks.build {
    finalizedBy("collectPMD")
    finalizedBy("collectJacoco")
    finalizedBy("collectJavadoc")
}


tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
    finalizedBy(tasks.aggregateJavadoc)
   
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}



jacoco {
    toolVersion = "0.8.8"
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        csv.required.set(true)
    }
}

// This will automatically run on the build action alongside with the compile and test task. Yey :)
pmd {

    isIgnoreFailures = true
    isConsoleOutput = true
    toolVersion = "6.44.0"
    ruleSets = listOf()
    ruleSetConfig = resources.text.fromFile("../ruleset.xml")
}



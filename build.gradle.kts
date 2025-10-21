plugins {
    id("java")
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // CLI
    implementation("info.picocli:picocli:4.7.6")
    // Optional; remove if it still annoys you, you don't need it to start
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")

    // JSON
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2")

    // Tests
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
}

application {
    // Update to match your package + class
    mainClass.set("app.mealplanner.cli.Main")
}

tasks.test {
    useJUnitPlatform()
}
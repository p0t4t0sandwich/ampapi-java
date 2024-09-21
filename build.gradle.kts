import xyz.wagyourtail.jvmdg.gradle.task.DowngradeJar

plugins {
    id("java")
    id("maven-publish")
    id("xyz.wagyourtail.jvmdowngrader") version("1.1.3")
}

group = "dev.neuralnexus"
version = "1.3.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.named<DowngradeJar>("downgradeJar") {
    downgradeTo = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

java {
    withSourcesJar()
    val javaVersion = JavaVersion.toVersion(21)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named("assemble") {
    dependsOn("downgradeJar")
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing {
    repositories {
        mavenLocal()
        maven("https://maven.neuralnexus.dev/releases") {
            name = "NeuralNexusReleases"
            credentials {
                username = (project.findProperty("neuralNexusUsername") ?: System.getenv("NEURALNEXUS_USERNAME")).toString()
                password = (project.findProperty("neuralNexusPassword") ?: System.getenv("NEURALNEXUS_PASSWORD")).toString()
            }
        }
        maven("https://maven.neuralnexus.dev/snapshots") {
            name = "NeuralNexusSnapshots"
            credentials {
                username = (project.findProperty("neuralNexusUsername") ?: System.getenv("NEURALNEXUS_USERNAME")).toString()
                password = (project.findProperty("neuralNexusPassword") ?: System.getenv("NEURALNEXUS_PASSWORD")).toString()
            }
        }
    }
    publications {
        register("originalJar", MavenPublication::class) {
            artifact(tasks["jar"])
        }
        register("downgradedJar", MavenPublication::class) {
            artifact(tasks["downgradeJar"])
        }
        register("sourcesJar", MavenPublication::class) {
            artifact(tasks["sourcesJar"])
        }
    }
}

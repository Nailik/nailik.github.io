rootProject.name = "Website"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
        gradlePluginPortal()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/14180086/artifacts/repository")
        }
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
        maven {
            url = uri("https://androidx.dev/snapshots/builds/14253138/artifacts/repository")
        }
    }
}

include(":composeApp")
include(":androidApp")

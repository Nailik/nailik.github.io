import com.mikepenz.aboutlibraries.plugin.DuplicateMode.MERGE
import com.mikepenz.aboutlibraries.plugin.DuplicateRule.SIMPLE
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.aboutlibraries)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    jvm("desktop")
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_22)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.androidx.navigation3.ui)
            implementation(libs.androidx.navigation3.runtime)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.material.icons.extended)
            implementation(libs.compose.runtime)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.compose.material3.adaptive.layout)
            implementation(libs.compose.material3.adaptive.navigation3)
            implementation(libs.compose.material3.adaptive.navigation.suite)
            implementation(libs.aboutlibraries.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
        }
        webMain.dependencies {
            implementation(libs.navigation3.browser)
        }
        @Suppress("unused")
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

aboutLibraries {
    library {
        duplicationMode = MERGE
        duplicationRule = SIMPLE
    }
}

compose.resources {
    packageOfResClass = "de.eller.kilian.resources"
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinJvmComposeDesktopApplication"
            packageVersion = "1.0.0"
            jvmArgs("-Dapple.awt.application.appearance=system")

            nativeDistributions {
                windows {
                    iconFile.set(project.file("src/commonMain/resources/icons/favicon.ico"))
                }
                macOS {
                    iconFile.set(project.file("src/commonMain/resources/icons/favicon.icns"))
                }
                linux {
                    iconFile.set(project.file("src/commonMain/resources/icons/favicon.png"))
                }
            }
        }
    }
}

android {
    compileSdk = 36
    namespace = "de.eller.kilian" // package name

    defaultConfig {
        applicationId = "de.eller.kilian" // mandatory for apps
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_22
        targetCompatibility = JavaVersion.VERSION_22
    }

    kotlin {
        jvmToolchain(22)
    }
}

dependencies {
    implementation(libs.compose.ui.tooling)
    implementation(compose.preview)
}

val copyWasmDist by tasks.register<Copy>("copyWasmDist") {
    dependsOn("wasmJsBrowserDistribution")

    val distDir = layout.buildDirectory.dir("dist/wasmJs/productionExecutable")
    val targetDir = layout.buildDirectory.dir("../../docs")

    doFirst {
        val target = targetDir.get().asFile
        if (target.exists()) {
            target.deleteRecursively()
        }
    }

    from(distDir)
    into(targetDir)
}

val gitCommitDocs by tasks.register<Exec>("gitAddDocs") {
    dependsOn(copyWasmDist)
    workingDir = layout.buildDirectory.dir("../../docs").get().asFile
    commandLine("git", "add", ".")
}

tasks.named("wasmJsBrowserDistribution") {
    finalizedBy(gitCommitDocs)
}
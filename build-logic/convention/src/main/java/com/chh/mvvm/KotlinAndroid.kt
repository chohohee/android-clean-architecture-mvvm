package com.chh.mvvm

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid() {
    extensions.configure<BaseExtension> {
        pluginManager.apply("org.jetbrains.kotlin.android")

        compileSdkVersion(Versions.COMPILE_SDK_VERSION)

        defaultConfig {
            minSdk = Versions.MIN_SDK_VERSION
            targetSdk = Versions.TARGET_SDK_VERSION

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        viewBinding.enable = true
        dataBinding.enable = true

        compileOptions {
            sourceCompatibility = Versions.JAVA_VERSION
            targetCompatibility = Versions.JAVA_VERSION
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }

    configureKotlin()
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(Versions.JVM_TARGET)

            val warningsAsErrors: String? by project
            allWarningsAsErrors.set(warningsAsErrors.toBoolean())
            freeCompilerArgs.set(
                freeCompilerArgs.get() + listOf(
                    "-opt-in=androidx.paging.ExperimentalPagingApi",
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                )
            )
        }
    }
}
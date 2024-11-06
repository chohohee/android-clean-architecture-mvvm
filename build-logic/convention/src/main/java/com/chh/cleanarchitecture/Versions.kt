package com.chh.cleanarchitecture

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object Versions {
    const val COMPILE_SDK_VERSION = 35
    const val MIN_SDK_VERSION = 24
    const val TARGET_SDK_VERSION = 34
    val JAVA_VERSION = JavaVersion.VERSION_17
    val JVM_TARGET = JvmTarget.JVM_17
}

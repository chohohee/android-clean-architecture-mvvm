plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "chh.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "chh.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "chh.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("hiltAndroid") {
            id = "chh.hilt.android"
            implementationClass = "HiltAndroidConventionPlugin"
        }
        register("hiltKotlin") {
            id = "chh.hilt.kotlin"
            implementationClass = "HiltKotlinConventionPlugin"
        }
    }
}

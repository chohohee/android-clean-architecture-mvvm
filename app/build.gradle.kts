plugins {
    id("chh.android.application")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.mvvm"

    defaultConfig {
        applicationId = "com.chh.mvvm"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.presentation)
    implementation(projects.domain)
    implementation(projects.data)
    implementation(projects.remote)
    implementation(projects.local)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
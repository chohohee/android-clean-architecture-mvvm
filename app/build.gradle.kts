plugins {
    id("chh.android.application")
}

android {
    namespace = "com.chh.cleanarchitecture"

    defaultConfig {
        applicationId = "com.chh.cleanarchitecture"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.presentation)
    implementation(projects.domain)
    implementation(projects.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
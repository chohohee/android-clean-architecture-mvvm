plugins {
    id("chh.kotlin.library")
    id("chh.hilt.kotlin")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.data)

    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
}
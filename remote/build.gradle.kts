plugins {
    id("chh.kotlin.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.data)

    implementation(libs.retrofit.kotlin.serialization)
}
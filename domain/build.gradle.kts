plugins {
    id("chh.kotlin.library")
}

dependencies {
    implementation(libs.inject)
    // alternatively - without Android dependencies for tests
    implementation(libs.androidx.paging.common)
}
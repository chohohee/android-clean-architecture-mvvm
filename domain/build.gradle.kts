plugins {
    id("chh.kotlin.library")
}

dependencies {
    implementation(libs.inject)
    implementation(libs.coroutines.core)
    // alternatively - without Android dependencies for tests
    implementation(libs.androidx.paging.common)
}
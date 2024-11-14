plugins {
    id("chh.kotlin.library")
}

dependencies {
    implementation(libs.inject)
    // without Android dependencies
    implementation(libs.androidx.paging.common)
}
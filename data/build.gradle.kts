plugins {
    id("chh.kotlin.library")
    id("chh.hilt.kotlin")
}

dependencies {
    implementation(projects.domain)
    // without Android dependencies
    implementation(libs.androidx.paging.common)
}
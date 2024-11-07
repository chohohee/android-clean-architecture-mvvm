plugins {
    id("chh.kotlin.library")
    id("chh.hilt.kotlin")
}

dependencies {
    implementation(projects.domain)

    // alternatively - without Android dependencies for tests
    implementation(libs.androidx.paging.common)
}
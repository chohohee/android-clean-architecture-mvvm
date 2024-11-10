plugins {
    id("chh.android.library")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.cleanarchitecture.local"
}

dependencies {
    implementation(projects.data)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.moshi)
}
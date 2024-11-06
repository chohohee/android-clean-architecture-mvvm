plugins {
    id("chh.android.library")
}

android {
    namespace = "com.chh.cleanarchitecture.local"
}

dependencies {
    implementation(projects.data)
}
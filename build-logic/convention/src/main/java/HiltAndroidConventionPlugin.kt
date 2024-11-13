import com.chh.mvvm.implementation
import com.chh.mvvm.ksp
import com.chh.mvvm.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class HiltAndroidConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libs.findLibrary("hilt.android"))
                ksp(libs.findLibrary("hilt.android.compiler"))
            }
        }
    }
}

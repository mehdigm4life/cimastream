plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.lint)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    android {
        // Must be unique
        namespace = "com.mehdigm.cimastream4.shared"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        androidResources {
            enable = true
        }
    }

    jvm()

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    sourceSets {
        all {
            languageSettings {
                optIn("com.mehdigm.cimastream4.InternalAPI")
                optIn("com.mehdigm.cimastream4.Prerelease")
            }
        }

        commonMain.dependencies {
            implementation(libs.bundles.compose)
            implementation(libs.kotlinx.collections.immutable)
            implementation(project(":library"))
        }

        androidMain.dependencies {
            implementation(libs.activity.compose)
            implementation(libs.preference.ktx)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.ui.tooling)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.mehdigm.cimastream4.generated.resources"
    generateResClass = auto
}
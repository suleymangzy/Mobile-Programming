// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    repositories {
        google()
    }
    dependencies{
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.3")
    }
}


plugins {
    alias(libs.plugins.android.application) apply false
}
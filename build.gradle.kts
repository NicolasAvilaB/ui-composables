// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    apply( from = "dependencies.gradle.kts")
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
    }
}

plugins {

    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("maven-publish")
}
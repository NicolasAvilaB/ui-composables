plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.items.ui.composes"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //dependencies
    implementation(rootProject.extra["activityCompose"] as Any)
    implementation(rootProject.extra["appCompat"] as Any)
    implementation(platform(rootProject.extra["composeBom"] as Any))
    implementation(rootProject.extra["coilCompose"] as Any)
    implementation(rootProject.extra["composeMaterial3"] as Any)
    implementation(rootProject.extra["composeUiGraphics"] as Any)
    implementation(rootProject.extra["composeUi"] as Any)
    implementation(rootProject.extra["coreKtx"] as Any)
    implementation(rootProject.extra["material"] as Any)
    implementation(rootProject.extra["textGoogleFonts"] as Any)
    implementation(rootProject.extra["toolingPreview"] as Any)

    //test
    testImplementation(rootProject.extra["junit"] as Any)
    testImplementation(rootProject.extra["kotlinTest"] as Any)
    testImplementation(rootProject.extra["mockk"] as Any)
    androidTestImplementation(rootProject.extra["testJunit"] as Any)
    androidTestImplementation(rootProject.extra["testEspressoCore"] as Any)
    androidTestImplementation(rootProject.extra["uiTestJunit"] as Any)

}
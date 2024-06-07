plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.items.ui.composables"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.items.ui.composables"
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":composes"))

    //dependencies
    implementation(rootProject.extra["activityCompose"] as Any)
    implementation(rootProject.extra["appCompat"] as Any)
    implementation(rootProject.extra["coilCompose"] as Any)
    implementation(platform(rootProject.extra["composeBom"] as Any))
    implementation(rootProject.extra["composeMaterial3"] as Any)
    implementation(rootProject.extra["composeUiGraphics"] as Any)
    implementation(rootProject.extra["composeUi"] as Any)
    implementation(rootProject.extra["coreKtx"] as Any)
    implementation(rootProject.extra["fragmentKtx"] as Any)
    implementation(rootProject.extra["kotlinCoroutines"] as Any)
    implementation(rootProject.extra["lifecycleRuntimeKtx"] as Any)
    implementation(rootProject.extra["material"] as Any)
    implementation(rootProject.extra["navigationAnimation"] as Any)
    implementation(rootProject.extra["navigationCompose"] as Any)
    implementation(rootProject.extra["retrofitConverterGson"] as Any)
    implementation(rootProject.extra["retrofit"] as Any)
    implementation(rootProject.extra["textGoogleFonts"] as Any)
    implementation(rootProject.extra["toolingPreview"] as Any)
    implementation(rootProject.extra["androidCamera2"] as Any)
    implementation(rootProject.extra["cameraLifecycle"] as Any)
    implementation(rootProject.extra["cameraView"] as Any)
    implementation(rootProject.extra["accompanistPermissions"] as Any)
    implementation(rootProject.extra["mlkitTextRecognition"] as Any)
    implementation(rootProject.extra["mlkitTextCommon"] as Any)
    implementation(rootProject.extra["mlkitBarcodeScanning"] as Any)

    //test
    testImplementation(rootProject.extra["junit"] as Any)
    testImplementation(rootProject.extra["kotlinTest"] as Any)
    testImplementation(rootProject.extra["mockk"] as Any)
    androidTestImplementation(rootProject.extra["testJunit"] as Any)
    androidTestImplementation(rootProject.extra["testEspressoCore"] as Any)
    androidTestImplementation(platform(rootProject.extra["composeBom"] as Any))
    androidTestImplementation(rootProject.extra["uiTestJunit"] as Any)

    //debug
    debugImplementation(rootProject.extra["uiTooling"] as Any)
    debugImplementation(rootProject.extra["uiTest"] as Any)
}
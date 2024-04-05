extra.apply {
    set("minSdkVersion", 29)
    set("targetSdkVersion", 33)

    //versionsDependencies
    set("versionCoreKtx", "1.9.0")
    set("versionActCompose", "1.8.2")
    set("versionLifecycleRunKtx", "2.7.0")

    //dependencies
    set("activityCompose","androidx.activity:activity-compose:${extra["versionActCompose"]}")
    set("appCompat","androidx.appcompat:appcompat:1.6.1")
    set("coilCompose","io.coil-kt:coil-compose:2.1.0")
    set("composeBom","androidx.compose:compose-bom:2023.03.00")
    set("composeMaterial3","androidx.compose.material3:material3:1.2.1")
    set("composeUi","androidx.compose.ui:ui")
    set("composeUiGraphics","androidx.compose.ui:ui-graphics")
    set("coreKtx","androidx.core:core-ktx:${extra["versionCoreKtx"]}")
    set("fragmentKtx","androidx.fragment:fragment-ktx:1.6.2")
    set("kotlinTest","org.jetbrains.kotlin:kotlin-test")
    set("kotlinCoroutines","org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    set("lifecycleRuntimeKtx","androidx.lifecycle:lifecycle-runtime-ktx:${extra["versionLifecycleRunKtx"]}")
    set("material","com.google.android.material:material:1.11.0")
    set("navigationAnimation","com.google.accompanist:accompanist-navigation-animation:0.29.0-alpha")
    set("navigationCompose","androidx.navigation:navigation-compose:2.5.3")
    set("mockk","io.mockk:mockk:1.12.0")
    set("retrofit","com.squareup.retrofit2:retrofit:2.9.0")
    set("retrofitConverterGson","com.squareup.retrofit2:converter-gson:2.9.0")
    set("textGoogleFonts","androidx.compose.ui:ui-text-google-fonts:1.6.1")
    set("toolingPreview","androidx.compose.ui:ui-tooling-preview")

    //testDependencies
    set("junit","junit:junit:4.13.2")
    set("testJunit","androidx.test.ext:junit:1.1.5")
    set("testEspressoCore","androidx.test.espresso:espresso-core:3.5.1")
    set("uiTestJunit","androidx.compose.ui:ui-test-junit4")

    //debugDependencies
    set("uiTooling","androidx.compose.ui:ui-tooling")
    set("uiTest","androidx.compose.ui:ui-test-manifest")
}
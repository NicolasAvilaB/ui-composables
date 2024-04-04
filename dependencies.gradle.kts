extra.apply{
    set("minSdkVersion", 29)
    set("compileSdk", 34)
    set("targetSdkVersion", 33)

    //versionsDependencies
    set("versionCoreKtx", "1.9.0")
    set("versionActCompose", "1.8.2")
    set("versionLifecycleRunKtx", "2.7.0")

    //Dependencies
    set("activityCompose","androidx.activity:activity-compose:${extra["versionActCompose"]}")
    set("coreKtx","androidx.core:core-ktx:${extra["versionCoreKtx"]}")
    set("composeBom","androidx.compose:compose-bom:2023.03.00")
    set("composeUi","androidx.compose.ui:ui")
    set("composeUiGraphics","androidx.compose.ui:ui-graphics")
    set("composeMaterial3","androidx.compose.material3:material3")
    set("toolingPreview","androidx.compose.ui:ui-tooling-preview")
    set("lifecycleRuntimeKtx","androidx.lifecycle:lifecycle-runtime-ktx:${extra["versionLifecycleRunKtx"]}")
}
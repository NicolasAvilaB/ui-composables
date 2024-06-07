## Android Ui Composables
Ui-Composable es una librería que Android Jetpack Compose, provee components creados para uso universal.

[Material Design 3] methodology components.

<br/>

## Instalación
En la raíz de tu carpeta ```build.gradle``` en este archivo, agregue el repo de maven + su url.

## Install
In the  root folder ```build.gradle``` file, add the maven repo with the url.
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Agregue la dependencia específica en el modulo del build gradle.

Then you can add the dependency library specifying the version in the app module ```build.gradle``` file.
```
implementation "com.item.ui-compose:1.0.0"
```

<br/>


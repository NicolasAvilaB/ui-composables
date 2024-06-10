## Android Ui Composables
Ui-Composable es una librería que Android Jetpack Compose, provee components creados para uso universal.

### [Material Design 3] methodology components.

<br/>

## Instalación
En la raíz de tu carpeta ```build.gradle``` o en ```settings.gradle``` en este archivo, agregue el repo de maven + su url y credenciales globales.
```
allprojects {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")
            credentials {
                username = "NicolasAvilaB"
                password = "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" //pass global de solo lectura
            }
        }
    }
}
```
## Install
In the  root folder ```build.gradle``` or ```settings.gradle``` file, add the maven repo with the url.

Kotlin KTS
url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")

Grovvy
url = "https://maven.pkg.github.com/NicolasAvilaB/ui-composables"

```
allprojects {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")
            credentials {
                username = "NicolasAvilaB"
                password = "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" //pass global de solo lectura
            }
        }
    }
}
```
Agregue la dependencia específica en el modulo del build gradle.

Then you can add the dependency library specifying the version in the app module ```build.gradle``` file.
```
For Groovy KTS
- implementation 'com.android.ui.NicolasAvilaB:composes:1.0.0'

For Kotlin KTS
- implementation("com.android.ui.NicolasAvilaB:composes:1.0.0")

```

<br/>


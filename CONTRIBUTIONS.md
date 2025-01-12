# Spanish

## ¿Como puedo contribuir a la librería?
Para contribuir con nuevos components, debes de clonar el GIT del proyecto, luego crear una rama feature/nombre_rama
y finalmente subir un PR con el nuevo cambio añadido en el Changelog y en el Readme (cambiar la versión de publicación).
Lo mergeas a Master y listo

Para hacer pública la version de nuestra librería, necesitas hacer lo siguiente:

- Primero dirigite al link del Drive descrito en el README para sacar el Token.
- Luego vas a Build.Gradle a nivel de Libreria (:composes) y pegas el **username** y **password**
- Finalmente ejecutas desde la terminal, los siguientes comandos en Orden:
  - ./gradlew assembleRelease
  - ./gradlew publish

## Plantilla de PR
Porfavor en lo posible, usa esta plantilla para el PR.

```
## Descripción:
    Descripción corta

## GIFs o Screenshots (si es necesario):

```

# English

## How can I contribute to the library?
To contribute new components, you must clone the project's GIT, then create a branch feature/branch_name
and finally upload a PR with the new change added in the Changelog and in the Readme (change the release version).
Merge it to Master and that's it

To make the version of our library public, you need to do the following:

- First go to the Drive link described in the README to get the Token.
- Then go to Build.Gradle at the Library level (:composes) and paste the **username** and **password**
- Finally, run the following commands from the terminal in order:
  - ./gradlew assembleRelease
  - ./gradlew publish

## PR Template
Please use this template for the PR if possible.

```
## Description:
    Short Description.

## GIFs or Screenshots (if needed):

```
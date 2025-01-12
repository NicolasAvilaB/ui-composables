# Changelog

### Spanish

Todos los cambios y releases en el proyecto, serán escritos detalladamente en este archivo.
El formato en la cuál se basará, es en la página (https://keepachangelog.com/en/1.1.0/)
Usar unreleased para no especificar de momento la version.

### English

All changes and releases in the project will be written in detail in this file.
The format on which it will be based, is on the page (https://keepachangelog.com/en/1.1.0/).
Use Unreleased for not describe version.

# [1.1.0](https://maven.pkg.github.com/NicolasAvilaB/com.android.ui.NicolasAvilaB:composes:1.1.0) (2025-01-11)

## Added Components
- Button:
  - ComposesBackNavigationButton
  - ComposesCheckeableSlotButton

- DropDownList:
  - ComposesDropDownMenu
  - ComposesFilterDropDownMenu

- Templates Screen:
  - ComposesErrorTemplate
  - ComposesLoginTemplate
  - ComposesSuccessTemplate
  
- Inputs:
  - ComposesEmailInput
  - ComposesNumericInput
  - ComposesNumericPasswordInput
  - ComposesOutlinedTextInput
  - ComposesPasswordInput

- Modal: 
  - ComposesModalOnePrimaryButton
  - ComposesModalOneSecondaryButton
  - ComposesModalSearchListButton
  - ComposesModalTwoHorizontalButton
  - ComposesModalTwoVerticalButton

- MenuItem:
  - ComposesDescriptionItem

## Changed
- ComposesSelectItem to ComposesDescriptionItem and ComposesMenuItem

## Fixed
- Fix ScanQr to recomposition on composes

# [1.0.1](https://maven.pkg.github.com/NicolasAvilaB/com.android.ui.NicolasAvilaB:composes:1.0.1) (2024-06-11)

## Fixed
- fix ComposesScanQR, now allow sincleScan boolean

# [1.0.0](https://maven.pkg.github.com/NicolasAvilaB/com.android.ui.NicolasAvilaB:composes:1.0.0) (2024-06-10)

## Added Components
- ComposesButtonArrowBack
- ComposesNavigationButton
- ComposesPrimaryButton
- ComposesSecondaryButton
- ComposesHorizontalDivider
- ComposesDrawContainer
- ComposesErrorTemplate
- ComposesCentralLoading
- ComposesScanQr
- ComposesSelectItem
- function "soundChecked" and "soundErrorChecked"
- ComposesSwitch
- ComposesText14
- ComposesText16
- ComposesText18
- ComposesText20
- ComposesCenterAppBar
- ComposesTopAppBar
- function "isLight" declared in Theme for check DarkMode or LightMode

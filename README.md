# AlbumSeeker

This is a simple Android app that calls the iTunes Public API to create a list of albums for a specified artist.

## Features

- Search field to type in the name of a Band / Singer / Artist
- Generate a list of all the albums for that artist
- Display the Album Artwork, Album Name, and Release Date
- Each row is clickable, displaying a small dialog with additional information
    - Primary Genre Name
    - Collection Price
    - Currency
    - Copyright
- Dialog with an "OK" button that dismisses the dialog

## Technology Stack

- Android Architecture ViewModel and Clean Architecture
- Written in Kotlin
- Uses Kotlin Flows
- On the UI side, Jetpack Compose
- Unit tests
- Uses Ktor and Dagger Hilt

## Prerequisites
- Install [Android Studio](https://developer.android.com/studio)
- Install the [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- Install the [Android SDK](https://developer.android.com/studio/releases/sdk-tools)
- Install [Gradle](https://gradle.org/install/)

## Technical Requirements
- [Kotlin 1.8.0](https://kotlinlang.org/docs/reference/whatsnew18.html) or higher
- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html) or higher
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- Run with Android 7.0 or Higher

## Steps
1. Clone or download the iTunes Albums App repository from the source code repository.
2. Open Android Studio and select "Open an existing Android Studio project."
3. Navigate to the folder where the repository was cloned or downloaded, select the root folder of the project, and click "OK."
4. Wait for Android Studio to build the project and download any necessary dependencies.
5. Connect an Android emulator or physical device to your development machine.
6. In Android Studio, click on the "Run" button or use the keyboard shortcut Shift + F10 to run the app.
7. Select the emulator or device you want to run the app on and click "OK."
8. The app should now launch on the selected emulator or device.

## Building an APK
1. Open the project in Android Studio.
2. Click on the "Build" menu and select "Build Bundle(s) / APK(s)".
3. In the "Build" window, select "Build APK".
4. The APK file will be generated and saved in the "app/build/outputs/apk" directory of the project.

Note: Make sure to sign the APK before distributing it to end-users.


## Contributing

Contributions are always welcome. If you want to contribute, please fork the repository and make your changes. Then create a pull request to this repository.

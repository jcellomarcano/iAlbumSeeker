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

## How to use

1. Clone the repository to your local machine

git clone https://github.com/jesusmarcano/AlbumSeeker.git


2. Open the project in Android Studio

3. Build and run the app on an emulator or physical device

## Contributing

Contributions are always welcome. If you want to contribute, please fork the repository and make your changes. Then create a pull request to this repository.

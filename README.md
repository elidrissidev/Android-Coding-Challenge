[![Build Status](https://travis-ci.org/MohamedElidrissi/Android-Coding-Challenge.svg?branch=master)](https://travis-ci.org/MohamedElidrissi/Android-Coding-Challenge)

# Android Coding Challenge

This is my take on this [coding challenge](https://github.com/hiddenfounders/mobile-coding-challenge).
Click [here](https://github.com/MohamedElidrissi/Android-Coding-Challenge/releases) to download a preview APK.

<img alt="Screenshot" height="600" src="https://raw.githubusercontent.com/MohamedElidrissi/Android-Coding-Challenge/master/screenshot.png">

## Run

To run this project you will need Android Studio 3.3.2 or higher

## Architecture

This project uses a clean architecture approach, and is composed of 3 modules, each module:

- _presentation_: This module contains the UI(Activities, fragments, ViewModels...) and dependency injection stuff. This module depends on `:data` and `:domain`.
- _data_: This module contains the repository implementation, models, data source, mappers, API service... This module depends on `:domain`.
- _domain_: All the code in this module is as generic as it could be, it contains interface and leaves the implementation to the upper layer(data). This module does not depend on any module, is pure kotlin and does not contain any framework related classes.

## Technologies/Libraries:

- AppCompat: everyone needs this!
- ConstraintLayout: for responsive layouts.
- Dagger2: for dependency injection.
- Navigation: for in-app navigation
- Paging: pagination made easy.
- Lifecycle: for observing data.
- Retrofit: for API calls.
- RxJava2: for observable streams.
- Gson: for JSON serialization.
- Glide: for loading images.
- Timber: for logging
- LeakCanary: for leaks detection
- Mockito and JUnit: for unit testing.

## Testing:

This project contains unit tests for `:data` and `:domain` modules.

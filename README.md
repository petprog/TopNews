# Top News
Modular Android architecture which showcase Kotlin, MVVM, Navigation, Hilt, Coroutines, Jetpack Compose, Retrofit and Kotlin Gradle DSL.

## Screenshots

<p style="background-color:rgb(169,169,169);">
<img src="art/dark_one.jpg" alt="Login and Register" width = "400" >
<img src="art/light_one.jpg" alt="Login and Register" width = "400" >
<img src="art/browser_tab.jpg" alt="Login and Register" width = "400" >

## Features
* Modular Android App Architecture.
* MVVM Architecture + Repository design Pattern.
* Jetpack Libraries and Architecture Components.
* Kotlin Gradle DSL.


## Modules

Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality. In this case apart from dividing by functionality/responsibility, existing the following dependence between them. The project is divided into 4 Modules :

#### App module

The `:app` module is an [com.android.library](https://developer.android.com/studio/build/android-library), which is needed to create the app bundle and some features

#### Core module

The `:core` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) for serving network requests. Providing the data source for the many features that require it.

#### Common module

The `:common` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) only contains code and resources which are shared between feature modules. Reusing this way resources, layouts, views, and components in the different features modules, without the need to duplicate code.

### Project configuration

Add parameters in the locale.properties file as shown in the example below.

```properties
api_key="Your API Key"
```

You can get an Api Key from [NEWS API ORG](https://newsapi.org/)

1. use `apiKey = 2d021085c2e64c23927ff485d9f4299b`
2. Paste copied key into `local.properties` with parameter (`api_key`)


## Tech Stack & Libraries

* [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
* [Android Jetpack](https://developer.android.com/jetpack)
    * [Compose](https://developer.android.com/jetpack/compose) Android’s modern toolkit for building native UI.
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) UI related data holder, lifecycle aware.
    * [Room](https://developer.android.com/topic/libraries/architecture/room) construct database.
    * [Navigation](https://developer.android.com/guide/navigation/) Android Jetpack's Navigation component helps you implement effective navigation.
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
    * [App Startup]() Provides a straightforward, performant way to initialize components at application startup.
* [Timber](https://github.com/JakeWharton/timber) A logger.
* [Accompanist](https://github.com/google/accompanist) - A collection of extension libraries for Jetpack Compose.
* [Landscapist](https://github.com/skydoves/landscapist) Jetpack Compose image loading library that fetches and displays network images with Glide, Coil, and Fresco.
* [Sandwich](https://github.com/skydoves/sandwich) construct lightweight http API response and handling error responses.
* [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) Executing code asynchronously.
* [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) is a state-holder observable flow that emits the current and new state updates to its collectors.
* [Retrofit](https://square.github.io/retrofit/) is a Type-safe HTTP client for Android, Java and Kotlin by Square.
* [Moshi](https://github.com/square/moshi) is a modern JSON library for Android and Java. It makes it easy to parse JSON format data.
* [OkHttp interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) Logs HTTP requests and responses.
* [Mockito](https://github.com/mockito/mockito) which is the most popular Mocking framework for unit tests written in Java as well as Kotlin.

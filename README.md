# XM Survey App
An app following MVVM and UDF patterns. Uses Kotlin Coroutines, Jetpack Compose, Hilt and Retrofit.

# Project structure
There are 3 layers: data, domain and presentation. Data layer is responsible for networking and mapping DTO objects. Domain layer includes interfaces for the repositories, models and business logic. Presentation contains UI code and VIewModel, which also contains business logic.

# Testing
There is one UI test for navigation and couple unit tests for ViewModel. Well, yes, it should be a lot more...

<p align="left">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/bobbyirawan09"><img alt="Profile" src="https://badgen.net/badge/icon/bobbyirawan09?icon=github&label"/></a> 
</p>

Project to replicate Stockbit app, although its a mini size of that app. Some cool tech stack I'm using in this project is Scarlet, Modularization, Navigation Component, etc. Not to forget, I also adding Unit Test for each layer.

## Tech Stack

### Architecture

Modularization, based on Clean Architecture divided into three main modules
- [x] Data (Mostly for calling API)
- [x] Domain (More like mediator between Data and Presentation)
- [x] Presentation (UI and business logic)

Inspired by [Android Clean Architecture](https://github.com/happysingh23828/Android-Clean-Architecture) project by [Happy Singh](https://github.com/happysingh23828). Awesome modularization project.

### Libraries

#### Core & Jetpack

- [x] [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [x] [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [x] [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines)
- [x] [Retrofit](https://square.github.io/retrofit/): Networking
- [x] [View Binding](https://developer.android.com/topic/libraries/view-binding)
- [x] [Koin](https://start.insert-koin.io/#/quickstart/kotlin): Dependency Injection / Service Locator]
- [x] [Jetpack Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
- [x] [Scarlet](https://github.com/Tinder/Scarlet): WebSocket client

#### Development, Debug & Test

- [x] [MockK](https://mockk.io/)


## API

I'm using CryptoCompare API to get the data both API and WebSocket. Click link below
- [x] [REST API](https://min-api.cryptocompare.com/documentation)
- [x] [WebSocket](https://min-api.cryptocompare.com/documentation/websockets)

## Modules

### App

Main purpose is to `startKoin` because app module implementing other three modules, so its the best place to `startKoi`n that covered the whole app

### BuildSrc

BuildSrc is the module to maintain the dependencies of third party library for app to use. It contains list of dependencies and version of that dependencies.

### Data

Handle communications to remote data. In this app case is to call API both for REST and WebSocket

### Domain

Contain use case and became the mediator to transfer data from Data layer to Presentation layer

### Presentation

This layer responsiblity is to handle UI and business logic. I put the MVVM design pattern implementation here. The module only know about Domain module.

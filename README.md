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

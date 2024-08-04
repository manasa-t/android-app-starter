# App starter for Android to get started with development of any app from scratch

 This project aims to be the starter kit for developers to start their project work immediately
 without spending time on initial setup like adding library dependencies, base framework
 of dependency injection, modular clean architecture, generic base classes etc. 

# Architecture
The code follows Clean Architecture with MVVM and following has been added

1. Multi module clean architecture -> domain, data and core modules with DI configured
2. Networking base classes -> abstracted api response processing, generic result classes and use cases
3. ViewModel base class ->  coroutine setup with injected dispatcher to support testing
4. Sample unit tests -> RemoteDataSource, LocalDataSource, Repository, UseCase, ViewModel, Activity ( for validating states )

# Library dependencies
Compose
Dagger Hilt
Retrofit
Glide
Room
Timber logger
Firebase analytics
Chucker


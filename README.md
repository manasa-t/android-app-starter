# This file explains the code base of this project 

# This project aims to be the starter kit for developers to start their project work immediately
# without spending time on initial setup like adding library dependencies, base framework
# of dependency injection, modular clean architecture, generic base classes etc

# Following dependencies have been added
Compose
Dagger Hilt
Retrofit
Glide
Room
Timber logger
Firebase -> Performance monitoring, analytics
Chucker


# Features

1. Multi module clean architecture -> domain, data and core modules with DI configured
2. Networking base classes -> abstracted api response processing, generic result classes and use cases
3. ViewModel base class ->  coroutine setup with injected dispatcher to support testing
4. Sample unit tests -> RemoteDataSource, LocalDataSource, Repository, UseCase, ViewModel, Activity ( for validating states )




# Clean Architecture MVVM

Clean Architecture MVVM Pattern in Android with Use Cases

### Preview
| EN                           | KO                           | JA                           |
|------------------------------|------------------------------|------------------------------|
| ![Alt Text](/preview/en.gif) | ![Alt Text](/preview/ko.gif) | ![Alt Text](/preview/ja.gif) |

[![PokemonCard](https://img.shields.io/badge/Download-Google_Play-0F9D58)](https://play.google.com/store/apps/details?id=com.chh.mvvm)


### Features
- List of all Pokemon
- View Pokemon card details
- Localization of name attribute
- Offline First

### Architecture 
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- MVVM (Model-View-ViewModel)
- Repository Pattern
- Multi-Module:
```
root
--- presentation
--- domain
--- data
--- local
--- remote
```

### Libraries 
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for aynsc
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) for rest api
- [Serialization](https://kotlinlang.org/docs/serialization.html) for parse response
- [JetPack](https://developer.android.com/jetpack)
  - data binding, lifecycle, navigation, paging, room, view model, palette
- [Glide](https://github.com/bumptech/glide) for image loading
- [Lottie](https://airbnb.io/lottie/) for image animation

### API
The API used in this project is [PokéAPI](https://pokeapi.co/) and the base url is as follows:
```
https://pokeapi.co/api/v2
```

#### Endoint Used
| Method | Endpoint                          | Usage                              |
| ------ | --------------------------------- | ---------------------------------- |
|GET     | `/pokemon?offset={0}&limit={100}` | Get All Pokemon Information Paging |
|GET     | `/pokemon-species/{bulbasaur}`    | Get localized Pokemon names        | 
|GET     | `/pokemon/{bulbasaur}`            | Get Pokemon attribute information  | 
|GET     | `/type/{1}`                       | Get localized Pokemon attributes   | 

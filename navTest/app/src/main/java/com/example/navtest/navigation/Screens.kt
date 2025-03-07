package com.example.navtest.navigation

sealed class Screens(val route: String) {
    object ScreenLoginRoute : Screens(route = "login")
    object ScreenRegisterRoute : Screens(route = "register")
    object ScreenForgetPassRoute : Screens(route = "forget")
    object ScreenHomeRoute : Screens(route = "home")
    object ScreenARoute : Screens(route = "screenA")
    object ScreenBRoute : Screens(route = "screenB")
    object ScreenDetailsRoute : Screens(route = "detail?name={name}&age={age}") {
        const val rout = "detail"
        fun withArgs(name: String?, age: Int?) = "$rout?name=$name&$age"
    }
    object AuthRoute : Screens(route = "auth")
    object AppRoute : Screens(route = "app")
}
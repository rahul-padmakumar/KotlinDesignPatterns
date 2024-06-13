package com.example.kotlindesignpatterns.behavioural

sealed class AuthorizationState

data object UnAuthorized : AuthorizationState()

class AuthorizedState(val username: String): AuthorizationState()

class AuthorizationPresenter{

    private var state: AuthorizationState = UnAuthorized

    val isLoggedIn: Boolean
        get() = when(state){
            is AuthorizedState -> true
            else -> false
        }

    val username: String
        get() = when(state){
            is AuthorizedState -> (state as? AuthorizedState)?.username ?: "Unknown"
            else -> "Unknown"
        }

    fun login(username: String){
        state = AuthorizedState(username)
    }
    fun logout(){
        state = UnAuthorized
    }
}

fun main(){
    val presenter = AuthorizationPresenter()
    presenter.login("Test User")
    println(presenter.isLoggedIn)
    println(presenter.username)
    presenter.logout()
    println(presenter.isLoggedIn)
    println(presenter.username)
}


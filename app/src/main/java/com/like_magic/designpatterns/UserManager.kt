package com.like_magic.designpatterns


data class User(val id: Int, val name: String, val age: Int)

interface UserManager {

    fun getUser(id: Int): User

}

class ApiManager : UserManager {

    override fun getUser(id: Int): User {
        val user = User(id, "Micky", 22)
        CacheManager().listOfUsers.add(user)
        return user
    }

}

class CacheManager : UserManager {

    val listOfUsers = mutableListOf(
        User(0, "John", 30),
        User(1, "Nick", 25),
        User(2, "Sam", 31),
        User(3, "Tina", 24),
        User(4, "Max", 35),
    )

    override fun getUser(id: Int): User {
        return listOfUsers.find {
            it.id == id
        } ?: ApiManager().getUser(id)
    }

}
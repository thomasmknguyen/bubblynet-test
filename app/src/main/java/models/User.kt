package models

import java.io.Serializable

data class User(
    val profileImage: Int,
    val username: String,
    val email: String
) : Serializable
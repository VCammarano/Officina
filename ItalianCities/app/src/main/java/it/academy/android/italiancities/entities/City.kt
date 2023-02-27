package it.academy.android.italiancities.entities

data class City(
    val id: Long,
    val name: String,
    val code: String,
    val province: Province
)

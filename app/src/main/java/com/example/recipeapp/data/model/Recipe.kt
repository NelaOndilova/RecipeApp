package com.example.recipeapp.data.model

data class Recipe(
    val name: String,
    val image: Int,
    val category: String,
    val ingredients: String,
    val instructions: String,
    var isFavorite: Boolean = false
)
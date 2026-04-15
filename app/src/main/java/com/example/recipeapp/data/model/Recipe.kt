package com.example.recipeapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val image: Int,
    val category: String,
    val ingredients: String,
    val instructions: String,
    var isFavorite: Boolean = false
)
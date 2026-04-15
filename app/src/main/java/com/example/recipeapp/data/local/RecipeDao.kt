package com.example.recipeapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recipeapp.data.model.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipes(): List<Recipe>
    @Query("SELECT * FROM recipes WHERE isFavorite = 1")
    suspend fun getFavoriteRecipes(): List<Recipe>
    @Insert
    suspend fun insertRecipe(recipe: Recipe)
    @Update
    suspend fun updateRecipe(recipe: Recipe)
}
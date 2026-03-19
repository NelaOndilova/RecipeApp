package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.recipeapp.data.repository.RecipeRepository

@Composable
fun RecipeScreen(navController: NavController, recipeName: String) {

    val recipe = RecipeRepository.recipes.find { it.name == recipeName }

    if (recipe == null) {
        Text("Recipe not found")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = recipe.image),
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = recipe.name,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Category: ${recipe.category}")

        Spacer(modifier = Modifier.height(12.dp))

        Text("Ingredients:")
        Text(recipe.ingredients)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Instructions:")
        Text(recipe.instructions)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                recipe.isFavorite = true
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add to favorites")
        }

    }
}
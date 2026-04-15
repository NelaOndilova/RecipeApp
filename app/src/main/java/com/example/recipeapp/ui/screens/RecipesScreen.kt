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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.data.model.Recipe
import kotlinx.coroutines.launch

@Composable
fun RecipeScreen(recipeName: String, recipeRepository: RecipeRepository) {

    var recipe by remember { mutableStateOf<Recipe?>(null) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) { recipe = recipeRepository.getAllRecipes().find {it.name == recipeName} }

    if (recipe == null) {
        Text("Recipe not found")
        return
    }

    val currentRecipe = recipe!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = currentRecipe.image),
            contentDescription = currentRecipe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(20.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = currentRecipe.name,
            fontSize = 22.sp,
            color = Color(0xFF8F757D)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Category:",
            color = Color(0xFF8F757D)
        )
        Text(
            text = currentRecipe.category,
            color = Color(0xFF8F757D)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "Ingredients:",
            color = Color(0xFF8F757D)
        )

        Text(
            currentRecipe.ingredients,
            color = Color(0xFF8F757D)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "Instructions:",
            color = Color(0xFF8F757D)
        )

        Text(
            currentRecipe.instructions,
            color = Color(0xFF8F757D)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                scope.launch {
                val updateRecipe = currentRecipe.copy(isFavorite = true)
                    recipeRepository.updateRecipe(updateRecipe)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFB4C2)
            )
        ) {
            Text(
                text = "Add to favorites",
                fontSize = 16.sp,
                color = Color(0xFFF08495)
            )
        }

    }
}
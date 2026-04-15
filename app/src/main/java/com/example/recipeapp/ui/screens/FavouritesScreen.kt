package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.ui.components.RecipeCard
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import com.example.recipeapp.data.model.Recipe

@Composable
fun FavoritesScreen(navController: NavController, recipeRepository: RecipeRepository) {

    var searchText by remember { mutableStateOf("") }
    var favoriteRecipes by remember { mutableStateOf<List<Recipe>>(emptyList())}

    LaunchedEffect(Unit){ favoriteRecipes = recipeRepository.getFavoriteRecipes()}

    val filteredRecipes = favoriteRecipes.filter {
        it.name.contains(searchText, ignoreCase = true)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "FAVORITES",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFCAD4),
                unfocusedContainerColor = Color(0xFFFFCAD4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFFFFCAD4),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(12.dp)
        ) {

            if (filteredRecipes.isEmpty()) {
                Text(
                    text = "No favorite recipes yet",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color(0xFFF08495)
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(filteredRecipes) { recipe ->
                        RecipeCard(recipe, navController)
                    }
                }
            }
        }
    }
}

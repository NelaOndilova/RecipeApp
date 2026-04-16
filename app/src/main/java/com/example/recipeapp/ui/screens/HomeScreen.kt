package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.horizontalScroll
import com.example.recipeapp.ui.components.RecipeCard
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.data.model.Recipe

@Composable
fun HomeScreen(navController: NavController, recipeRepository: RecipeRepository) {

    var searchText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var recipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }

    LaunchedEffect(true){ recipes = recipeRepository.getAllRecipes()}

    val favoriteRecipes = recipes.filter { it.isFavorite }
    val filteredRecipes = recipes.filter {
        (selectedCategory == "All" || it.category == selectedCategory) &&
                it.name.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "HOME",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            shape = RoundedCornerShape(35.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFCAD4),
                unfocusedContainerColor = Color(0xFFFFCAD4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFCAD4),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
        ) {

            Column {

                Text(
                    text = "Favorite recipes →",
                    fontSize = 18.sp,
                    color = Color(0xFFF08495),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate("favorites")
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    favoriteRecipes.forEach { recipe ->
                        RecipeCard(recipe, navController)
                    }

                }

            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Categories",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF08495)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {

            CategoryItem("All", selectedCategory) {
                selectedCategory = "All"
            }

            Spacer(modifier = Modifier.width(8.dp))

            CategoryItem("Breakfast", selectedCategory) {
                selectedCategory = "Breakfast"
            }

            Spacer(modifier = Modifier.width(8.dp))

            CategoryItem("Lunch", selectedCategory) {
                selectedCategory = "Lunch"
            }

            Spacer(modifier = Modifier.width(8.dp))

            CategoryItem("Dinner", selectedCategory) {
                selectedCategory = "Dinner"
            }

            Spacer(modifier = Modifier.width(8.dp))

            CategoryItem("Dessert", selectedCategory) {
                selectedCategory = "Dessert"
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            filteredRecipes.forEach { recipe ->
                RecipeCard(recipe, navController)

            }

        }
    }
}

@Composable
fun CategoryItem(name: String, selectedCategory: String, onClick: () -> Unit) {

    val isSelected = name == selectedCategory

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (isSelected) Color(0xFFF08495) else Color(0xFFFFCAD4)
            )
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {

        Text(
            text = name,
            fontSize = 12.sp,
            color = if (isSelected) Color.White else Color(0xFFF08495),
            fontWeight = FontWeight.Bold
        )

    }

}
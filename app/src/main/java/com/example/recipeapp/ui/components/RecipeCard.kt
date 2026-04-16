package com.example.recipeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recipeapp.data.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .clickable {
                navController.navigate("recipe/${recipe.name}")
            }
    ) {
        Box {
            Image(
            painter = painterResource(id = recipe.image),
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
        )
            FavoriteButton(
                isFavorite = recipe.isFavorite,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = recipe.name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF08495)
        )
    }
}


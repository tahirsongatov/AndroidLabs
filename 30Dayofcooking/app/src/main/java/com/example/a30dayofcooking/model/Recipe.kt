package com.example.a30dayofcooking.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30dayofcooking.R

data class Recipe(
    @StringRes val recipeName: Int,
    @StringRes val recipe: Int,
    @DrawableRes val recipeImg: Int,
)
object RecipesRepository {
    val recipes = listOf(
        Recipe(
            recipeName = R.string.recipe_name1,
            recipe = R.string.recipe1,
            recipeImg = R.drawable.recipe1
        ),
    )
}
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
        Recipe(
            recipeName = R.string.recipe_name2,
            recipe = R.string.recipe2,
            recipeImg = R.drawable.recipe2
        ),
        Recipe(
            recipeName = R.string.recipe_name3,
            recipe = R.string.recipe3,
            recipeImg = R.drawable.recipe3
        ),
        Recipe(
            recipeName = R.string.recipe_name4,
            recipe = R.string.recipe4,
            recipeImg = R.drawable.recipe4
        ),
    )
}
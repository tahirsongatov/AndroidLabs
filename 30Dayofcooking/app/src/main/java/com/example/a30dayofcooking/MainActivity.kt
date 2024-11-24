package com.example.a30dayofcooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30dayofcooking.model.Recipe
import com.example.a30dayofcooking.model.RecipesRepository
import com.example.a30dayofcooking.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                RecipeList(modifier = Modifier.padding(all = 16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    })
}

@Composable
fun RecipeCard(recipe: Recipe,day: Int, modifier: Modifier = Modifier) {
    var isShown by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue = if (isShown) MaterialTheme.colorScheme.background
        else MaterialTheme.colorScheme.primary,
    )
    val color2 by animateColorAsState(
        targetValue = if (isShown) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.background,
    )
    Card (
        modifier = modifier.background(color = color, shape = MaterialTheme.shapes.medium),
        colors = CardColors(color,color2,color,color)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .animateContentSize(
                    spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Day $day: ${stringResource(recipe.recipeName)}")
                Spacer(modifier = Modifier)
                IconButton(
                    onClick = { isShown = !isShown },
                    modifier = Modifier,
                ) {
                    Icon(
                        imageVector = if (isShown) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
            if (isShown){
                Spacer(modifier = Modifier.height(18.dp))
                Image(
                    painter = painterResource(id = recipe.recipeImg),
                    contentDescription = stringResource(id = recipe.recipeName),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = stringResource(id = recipe.recipe))
            }
        }
    }
}

@Composable
fun RecipeList(modifier: Modifier = Modifier){
    val recipes = RecipesRepository.recipes
    Scaffold (
        topBar = {
            SuperheroTopAppBar()
        }
    ){ it ->
        LazyColumn (
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier,
        ){
            items(recipes) { recipe ->
                RecipeCard(recipe = recipe, day = recipes.indexOf(recipe)+1)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePreview() {
    AppTheme {
        Surface {
            RecipeList(modifier = Modifier.padding(all = 16.dp))
        }
    }
}
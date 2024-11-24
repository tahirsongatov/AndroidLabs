package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {

            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card (modifier = modifier.clip(MaterialTheme.shapes.medium)){
        Row (
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
        ){
            Column {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = hero.imageRes), 
                contentDescription = stringResource(id = hero.descriptionRes),
                modifier = Modifier.clip(MaterialTheme.shapes.small)
                    .size(72.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    SuperheroesTheme {
        HeroItem(hero = Hero(nameRes = R.string.hero1, imageRes = R.drawable.android_superhero1, descriptionRes = R.string.description1))
    }
}
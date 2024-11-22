package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TopicsApp()
                }
            }
        }
    }
}

@Composable
fun TopicGridItem(topic: Topic, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
    ){
        Row(
            modifier = Modifier
        ) {
            Box {
                Image(
                    painter = painterResource(id = topic.imgRes),
                    contentDescription = stringResource(id = topic.stringRes),
                    modifier = Modifier
                        .size(68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                )
            }
            Column (
                modifier = Modifier.padding(top = 8.dp,start = 16.dp,end = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.stringRes),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 14.sp,
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "hard icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${topic.hard}",style =MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
fun TopicsGrid(topics: List<Topic>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(topics) { topic ->
            TopicGridItem(topic = topic,Modifier.fillMaxSize())
        }
    }
}

@Composable
fun TopicsApp(){
    TopicsGrid(topics = DataSource().topics)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopicsApp()
}
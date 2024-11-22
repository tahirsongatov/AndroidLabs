package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .wrapContentWidth()
        ) {
            Image(
                painter = painterResource(id = topic.imgRes),
                contentDescription = stringResource(id = topic.stringRes),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column (
                modifier = Modifier.padding(top = 16.dp,start = 16.dp,end = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.stringRes),
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 20.sp,
                )
                Row {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "hard icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${topic.hard}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopicGridItem(topic = Topic(stringRes = R.string.film,55,R.drawable.film))
}
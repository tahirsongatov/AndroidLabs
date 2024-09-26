package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                ComposeArticle(
                    title = stringResource(R.string.JC_tutorial),
                    abstract = stringResource(R.string.JC_abstract),
                    article = stringResource(R.string.JC_article)
                )
            }
        }
    }
}

@Composable
fun ComposeArticle(title: String, abstract: String, article: String, modifier: Modifier = Modifier) {
    val bgImg = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = bgImg,
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = abstract,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = article,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticle(
            title = stringResource(R.string.JC_tutorial),
            abstract = stringResource(R.string.JC_abstract),
            article = stringResource(R.string.JC_article)
        )
    }
}
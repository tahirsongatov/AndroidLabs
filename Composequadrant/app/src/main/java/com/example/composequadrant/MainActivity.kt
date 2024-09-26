package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                ComposableQuadrant()
            }
        }
    }
}

@Composable
fun ComposableQuadrant(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxSize()){
        Row (modifier = Modifier.weight(1f)){
            ComposableCard(
                title = stringResource(R.string.cp_text),
                descr = stringResource(R.string.cp_text_descr),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableCard(
                title = stringResource(R.string.cp_image),
                descr = stringResource(R.string.cp_image_descr),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row (modifier = Modifier.weight(1f)) {
            ComposableCard(
                title = stringResource(R.string.cp_row),
                descr = stringResource(R.string.cp_row_descr),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableCard(
                title = stringResource(R.string.cp_column),
                descr = stringResource(R.string.cp_column_descr),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableCard(title: String, descr: String,color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = descr,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposableQuadrant()
    }
}
package com.example.squeezealemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.squeezealemon.ui.theme.SqueezeALemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SqueezeLemonApp(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                color = Color.Yellow,
            )
        }
    }
}

@Composable
fun SqueezeLemonApp(modifier: Modifier = Modifier,color: Color = Color.Yellow,) {
    var state by remember {
        mutableIntStateOf(0)
    }
    var rand by remember {
        mutableIntStateOf((2..6).random())
    }
    var i by remember {
        mutableIntStateOf(1)
    }
    val img: Int = when (state) {
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val descr: Int = when (state) {
        1 -> R.string.lemon_descr
        2 -> R.string.glass_of_lemonade_descr
        3 -> R.string.empty_glass_descr
        else -> R.string.lemon_tree_descr
    }
    val prompt: Int = when (state) {
        1 -> R.string.squeeze
        2 -> R.string.drink
        3 -> R.string.empty_glass
        else -> R.string.lemon_tree
    }
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .background(color = color)
                .fillMaxSize()
                .weight(0.2f)
                .wrapContentSize(Alignment.BottomCenter)
        ) {
            Text(
                text = "Lemonade",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(18.dp))
        }
        Column (
            modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = stringResource(id = descr),
                modifier = Modifier.clickable {
                    when (state) {
                        0 -> {
                            state = 1
                        }
                        1 -> {
                            if (i != rand) {
                                i++
                                return@clickable
                            }
                            i = 1
                            rand = (2..6).random()
                            state = 2
                        }
                        2 -> {
                            state = 3
                        }
                        3 -> {
                            state = 0
                        }
                    }
                }
            )
            Text(text = stringResource(id = prompt))
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun SqueezeLemonPreview() {
    SqueezeLemonApp(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        color = Color.Yellow,
    )
}
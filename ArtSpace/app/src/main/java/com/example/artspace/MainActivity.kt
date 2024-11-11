package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceTheme {
                    ArtSpaceLayout(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

class ArtWork(
    val Title:String,
    val Artist:String,
    val Year: Int,
    @DrawableRes val Image: Int,
    val ImgDescr: Int = R.string.cat_img_descr,
)
var ArtsArr = arrayOf(
    ArtWork(
        Title = "Simon",
        Artist =  "Tagir",
        Year = 2024,
        Image = R.drawable.cat1,
    ),
    ArtWork(
        Title = "Lofy cat",
        Artist =  "Tagir",
        Year = 2023,
        Image = R.drawable.cat2,
    ),
    ArtWork(
        Title = "Krowdy",
        Artist =  "Tagir",
        Year = 2023,
        Image = R.drawable.cat3,
    ),
    ArtWork(
        Title = "Mila and Jany",
        Artist =  "Dima",
        Year = 2024,
        Image = R.drawable.cat4,
    ),
    ArtWork(
        Title = "Laska",
        Artist =  "Dima",
        Year = 2024,
        Image = R.drawable.cat5,
    ),
    ArtWork(
        Title = "Rocky",
        Artist =  "Kostya",
        Year = 2022,
        Image = R.drawable.cat6,
    ),
    ArtWork(
        Title = "Nuts",
        Artist =  "Kostya",
        Year = 2023,
        Image = R.drawable.cat7,
    ),
    ArtWork(
        Title = "Vally",
        Artist =  "Kostya",
        Year = 2024,
        Image = R.drawable.cat8,
    ),
)
@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var id by remember {
        mutableIntStateOf(0)
    }
    val isMinMax = when (id){
        0 -> -1
        ArtsArr.size-1 -> 1
        else -> 0
    }
    val img = painterResource(id = R.drawable.back2)
    Surface(modifier = modifier) {
        Image(
            painter = img,
            contentScale = ContentScale.FillHeight,
            alpha = 0.4F,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
        Column(
            modifier = modifier
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "${id + 1} / ${ArtsArr.size} arts",
                fontSize = 18.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 50.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            ArtInfo(
                art = ArtsArr[id],
                isMinMax = isMinMax,
                prevOnChanged = {
                    id--
                },
                nextOnChanged = {
                    id++
                }
            )
        }
    }
}
 @Composable
fun ArtInfo(
     art: ArtWork,
     modifier: Modifier = Modifier,
     isMinMax: Int = 0,
     prevOnChanged: ()-> Unit,
     nextOnChanged: ()->Unit
 ){
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(art.Image),
            contentDescription = stringResource(art.ImgDescr),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = art.Title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = "artist: ${art.Artist} (${art.Year})",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.height(30.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.SpaceAround
        ){
            if (isMinMax != -1) {
                Button(
                    onClick = prevOnChanged
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 18.sp
                    )
                }
            }
            if (isMinMax != 1) {
                Button(onClick = nextOnChanged) {
                    Text(
                        text = "Next",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }
}
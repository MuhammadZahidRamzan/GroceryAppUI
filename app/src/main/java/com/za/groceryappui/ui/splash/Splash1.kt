package com.za.groceryappui.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.za.groceryappui.R
import com.za.groceryappui.Screen
import com.za.groceryappui.ui.theme.poppinsSemiBold
import com.za.groceryappui.ui.theme.Detail
import com.za.groceryappui.ui.theme.Purple40

@Composable
fun Splash1(navController: NavController){
    Splash1Box(modifier = Modifier.fillMaxSize(),
        onItemClick = {navController.navigate(Screen.Splash2Screen.route)})

}
@Composable
fun Splash1Box(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.splash1back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 47.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Welcome to",
                fontFamily = poppinsSemiBold,
                fontSize = 24.sp)
            Image(painter = painterResource(id = R.drawable.bigcart11),
                contentDescription = null,
                Modifier.size(width = 150.dp, height = 50.dp))
            Text(text = "Lorem ipsum dolor sit amet, consetetur \n" +
                    "sadipscing elitr, sed diam nonumy",
                modifier = Modifier.padding(start = 47.dp, end = 47.dp, top = 8.dp),
                color = Detail,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
                )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp),
            contentAlignment = Alignment.BottomCenter,
            ){
            Column {
                DotsRow(greenDotNumber = 0)
                Spacer(modifier = Modifier.size(32.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .size(height = 60.dp, width = 380.dp)
                    .padding(bottom = 16.dp).background(Purple40).
                    clickable {
                              onItemClick()
                    },
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Get started",
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

    }

}
@Composable
fun DotsRow(greenDotNumber:Int){
    LazyRow(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        items(4){
            if (it == greenDotNumber){
                Image(painter = painterResource(id = R.drawable.bullet1),
                    contentDescription = null,
                    Modifier.padding(end = 3.dp).size(8.dp))
            }else{
                Image(painter = painterResource(id = R.drawable.bullet3),
                    contentDescription = null,
                    Modifier.padding(end = 3.dp).size(8.dp))
            }

        }


    }
}
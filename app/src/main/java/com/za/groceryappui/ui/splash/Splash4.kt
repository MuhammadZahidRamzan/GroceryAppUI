package com.za.groceryappui.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.za.groceryappui.R
import com.za.groceryappui.ui.theme.poppinsSemiBold
import com.za.groceryappui.ui.theme.Detail
import com.za.groceryappui.ui.theme.Purple40

@Composable
fun Splash4(){
    Splash4Box(modifier = Modifier.fillMaxSize())

}
@Composable
fun Splash4Box(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.splash4),
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
            Text(text = "Get Discounts \n" +
                    "On All Products",
                fontFamily = poppinsSemiBold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center)
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
                DotsRow(greenDotNumber = 3)
                Spacer(modifier = Modifier.size(32.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .size(height = 60.dp, width = 380.dp)
                    .padding(bottom = 16.dp).background(Purple40),
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
@file:OptIn(ExperimentalMaterial3Api::class)

package com.za.groceryappui.ui.mainScreen

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.za.groceryappui.R
import com.za.groceryappui.ui.theme.TextFieldBack
import com.za.groceryappui.ui.theme.poppinsSemiBold

@Composable
fun MainScreen() {
    Column(Modifier.fillMaxSize()) {
        TextFieldTop(modifier = Modifier.fillMaxWidth())
        DiscountPic()
        CategoryFruit(imageVector = painterResource(id = R.drawable.group1),
            category = "Vegitables",
            backColor = Color.Green)

    }

}

@Composable
fun TextFieldTop(modifier: Modifier = Modifier) {
    var textFieldText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier
            .padding(top = 12.dp)
            .padding(horizontal = 12.dp)
            .background(TextFieldBack),
        value = textFieldText,
        onValueChange = { textFieldText = it },
        placeholder = {
            Text(text = "Search Key words")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
        },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        )
    )

}

@Composable
fun DiscountPic(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(283.dp)
            .padding(horizontal = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.discount_pic),
            contentDescription = null,
            Modifier.size(380.dp, 283.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 55.dp, bottom = 80.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "20% off on your\n" +
                        "first purchase",
                fontFamily = poppinsSemiBold,
                color = Color.Black
            )

        }

    }
}

@Composable
fun CategoryFruit(
    modifier: Modifier = Modifier,
    imageVector: Painter,
    backColor: Color,
    category: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Category",
                fontFamily = poppinsSemiBold,
                color = Color.Black,
                fontSize = 12.sp
            )
            Image(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ItemCategory(backColor = backColor, imageVector = , category = category)

    }

}

@Composable
fun ItemCategory(backColor: Color,
                 imageVector: Drawable,
                 category: String) {
    var back:Color = Color.Black
    calcDominantColor(imageVector){
        back = it
    }
    Column {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(back),
            contentAlignment = Alignment.Center,

            ) {
            Image(
                painter = rememberDrawablePainter(drawable = imageVector),
                contentDescription = null,
                modifier = Modifier
                    .width(23.dp)
                    .height(25.dp)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = category)
    }
}
fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
    val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

    Palette.from(bmp).generate { palette ->
        palette?.dominantSwatch?.rgb?.let { colorValue ->
            onFinish(Color(colorValue))
        }
    }
}
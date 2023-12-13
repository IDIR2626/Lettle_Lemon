package com.example.lettlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Preview(showBackground = true)
@Composable
//todolater : pass to the DishDetailsScreen a Dish Objectt
fun DishDetails(navController: NavHostController?, name: String, description: String, image: Int) {
    var orderCounter by rememberSaveable {
        mutableIntStateOf(0)
    }
    DishDetailsScreen(name, description, image,orderCounter, {++orderCounter}, {--orderCounter})
}

@Composable
fun DishDetailsScreen(name: String, description: String, image: Int ,orderCounter:Int, onIncrement: () -> Unit, onDecrement : () -> Unit){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "Greek Salad",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.padding(12.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(
                text = name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0C0C0B),
                letterSpacing = TextUnit(value = 2f, TextUnitType.Sp)
            )

            Text(
                text = description,
                color = Color(0xFF3D3D30)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { if (orderCounter > 0) onDecrement() else Toast.makeText(
                    context, "you haven't make any order!", Toast.LENGTH_LONG).show()}) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription ="Remove",
                        tint = Color.Black

                    )

                }

                Text(
                    text = "$orderCounter",
                    fontSize = 42.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = {onIncrement()},
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription ="add",
                        tint = Color.Black
                    )
                }

            }

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14))
            ) {

                Text(
                    text = stringResource(id = R.string.add),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF495E57),
                    fontSize = 18.sp

                )

            }
        }
    }
}
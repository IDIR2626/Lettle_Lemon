package com.example.lettlelemon

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class OrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen(context = LocalContext.current)

        }
    }
}

@Composable
private fun AppScreen (context : Context){
    var orderCounter by rememberSaveable {
        mutableIntStateOf(0)
    }
    ItemOrder(context = context, orderCounter, {++orderCounter}, {--orderCounter})
}

@Composable
private fun ItemOrder(context : Context, orderCounter:Int, onIncrement: () -> Unit, onDecrement : () -> Unit ){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFF495E57))
                    .padding(8.dp)
            ) {


                Text(
                    color = Color(0xFFF4CE14),
                    text = stringResource(id = R.string.greek_salad),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
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
                            tint = Color.White

                        )

                    }


                    Text(
                        text = "$orderCounter",
                        fontSize = 42.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = {onIncrement()},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription ="add",
                            tint = Color.White
                        )
                    }

                }

                Button(
                    onClick = { /*TODO*/ },
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
}

@Preview
@Composable
fun  AppScreenPreview(){
    AppScreen(LocalContext.current)
}
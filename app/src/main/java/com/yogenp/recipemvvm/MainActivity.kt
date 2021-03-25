package com.yogenp.recipemvvm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ItemDetails()
        }

    }

    @Composable
    fun ItemDetails() {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = Color(0xFFF2F2F2))
        ) {
            Image(
                painter = painterResource(id = R.drawable.happy_meal_small),
                contentDescription = "Happy Happy",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .padding(15.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Happy Meal",
                        style = typography.h5,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "$5.99",
                        style = typography.body1,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = "800 Calories",
                    style = typography.body1
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally
                )) {
                    Text(text = "ORDER NOW")
                }
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        ItemDetails()
    }

}
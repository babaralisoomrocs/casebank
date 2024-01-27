package com.example.casebank.casebankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casebank.R
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(navController: NavController) {

    var scope= rememberCoroutineScope()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.HalfWhite))
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.man), contentDescription = null,
                modifier = Modifier.size(280.dp)
            )
        }
        Row {
            Text(
                text = "Welcome to",
                fontSize = 32.sp,
                color = colorResource(id = R.color.Dark),
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Text(
                text = "Case Bank",
                fontSize = 64.sp,
                color = colorResource(id = R.color.LightPurple),
                fontWeight = FontWeight.Bold

            )
        }
        Row {
            Text(
                text = "Where you can get easily\nknowledge about Case’s",
                fontSize = 18.sp,
                color = colorResource(id = R.color.Dark),
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .width(300.dp)
                .height(70.dp)
                .background(colorResource(id = R.color.LightPurple), RoundedCornerShape(15.dp))
                .clickable {
                    scope.launch {
                        navController.navigate("signin")

                    }
                }
                .padding(0.dp)

            ,
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Get Started",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController= rememberNavController())
}
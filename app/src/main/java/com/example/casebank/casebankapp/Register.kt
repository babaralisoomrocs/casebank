package com.example.casebank.casebankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.casebank.R
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun Register(navController: NavController) {

    var scope = rememberCoroutineScope()
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.HalfWhite))
    ) {
        Box {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .background(
                        colorResource(id = R.color.LightDark).copy(alpha = 0.2f),
                        RoundedCornerShape(bottomEnd = 60f, bottomStart = 60f)
                    ),

                )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(187.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(bottomEnd = 60f, bottomStart = 60f)
                    ),
                contentAlignment = Alignment.CenterStart

            ) {
                Text(
                    text = "Lets get you registered!",
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.Dark),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 160.dp)
                        .width(340.dp)
                        .height(50.dp)
                        .background(Color.White, RoundedCornerShape(50))
                        .border(
                            1.dp, color = colorResource(id = R.color.LightDark).copy(alpha = 0.1f),
                            RoundedCornerShape(50)
                        )
                )
                {
                    Row(
                        //horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .height(50.dp)
                                .width(160.dp)
                                .background(
                                    Color.White,
                                    RoundedCornerShape(50)
                                )
                                .clickable {
                                    navController.navigate("signin")
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Login",
                                color = colorResource(id = R.color.Dark),
                                fontSize = 20.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .height(50.dp)
                                .width(180.dp)
                                .background(
                                    colorResource(id = R.color.LightPurple),
                                    RoundedCornerShape(50)
                                )
                                .clickable {

                                },
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Register",
                                fontSize = 20.sp,
                                color = Color.White

                            )
                        }

                    }

                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            TextField(
                value = name,
                onValueChange = {name=it},
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Full name")
                },
                label = {
                    Text(text = "Full name")
                },
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    focusedLabelColor = colorResource(id = R.color.LightPurple),
                    cursorColor = colorResource(id = R.color.Dark),
                    focusedTextColor = colorResource(id = R.color.Dark)
                ),
                modifier = Modifier.width(350.dp)
            )
            TextField(
                value = email,
                onValueChange = {email=it},
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Email")
                },
                label = {
                    Text(text = "Email")
                },
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    focusedLabelColor = colorResource(id = R.color.LightPurple),
                    cursorColor = colorResource(id = R.color.Dark),
                    focusedTextColor = colorResource(id = R.color.Dark)
                ),
                modifier = Modifier.width(350.dp)
            )

            TextField(
                value = password,
                onValueChange = {password=it},
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Password")
                },
                label = {
                    Text(text = "Password")
                },
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    focusedLabelColor = colorResource(id = R.color.LightPurple),
                    cursorColor = colorResource(id = R.color.Dark),
                    focusedTextColor = colorResource(id = R.color.Dark)
                ),
                modifier = Modifier.width(350.dp)
            )
Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(350.dp)
                    .height(50.dp)
                    .background(colorResource(id = R.color.LightPurple), RoundedCornerShape(15.dp))
                    .clickable { }
                    .padding(0.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Row {
                    Text(
                        text = "Already have an account? ",
                        color = colorResource(id = R.color.Dark)
                    )
                    ClickableText(
                        AnnotatedString("Login Now"),
                        onClick = {
                            scope.launch {
                                navController.navigate("signin")

                            }
                        },
                        style = TextStyle(color = colorResource(id = R.color.Red))
                    )
                }
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun RegisterPreview() {
    Register(navController= rememberNavController())
}
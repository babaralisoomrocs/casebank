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
fun SignIn(navController: NavController) {



    var scope = rememberCoroutineScope()

    var checkboxState by remember {
        mutableStateOf(false)
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
                    text = "Lets get you signed in!",
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
                                .width(180.dp)
                                .background(
                                    colorResource(id = R.color.LightPurple),
                                    RoundedCornerShape(50)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                        Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .height(50.dp)
                                    .width(160.dp)
                                    .background(
                                        Color.Transparent,
                                        RoundedCornerShape(50)
                                    )
                                    .clickable {
                                        scope.launch {

                                                navController.navigate("register")

                                        }
                                    },
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Register",
                                fontSize = 20.sp,
                                color = colorResource(id = R.color.Dark)
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
                value = email,
                onValueChange = {email=it},
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Enter your email")
                },
                label = {
                    Text(text = "Enter your email")
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
                    Text(text = "Enter your password")
                },
                label = {
                    Text(text = "Enter your password")
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(30.dp)
            ) {
                Checkbox(
                    checked = checkboxState,
                    onCheckedChange = { checkboxState=it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = colorResource(id = R.color.LightPurple),
                        checkmarkColor = Color.White
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Remember me",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.Dark)
                    )
                    Text(
                        text = "Forgot Password? ",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.Red)
                    )
                }

            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(300.dp)
                    .height(50.dp)
                    .background(colorResource(id = R.color.LightPurple), RoundedCornerShape(15.dp))
                    .clickable {
                        scope.launch {
                            navController.navigate("home")
                        }
                    }
                    .padding(0.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Login",
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
                        text = "New member? ",
                        color = colorResource(id = R.color.Dark)
                    )
                    ClickableText(
                        AnnotatedString("Register Now"),
                        onClick = {
                            scope.launch {
                                navController.navigate("register")

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
fun SignInPreview() {
    SignIn(navController = rememberNavController())
}
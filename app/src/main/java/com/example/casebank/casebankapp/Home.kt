@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.casebank.casebankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.navArgument
import com.example.casebank.R
import com.example.casebank.R.color
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun Home(navController: NavController) {


    var search by remember { mutableStateOf("") }

    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    var sheetState = rememberModalBottomSheetState()

    var horizontalscrollState = rememberScrollState()

    var verticalscrollState = rememberScrollState()


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(

        drawerContent = {
            Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp)
            ) {
                Row {
                    ModalDrawerSheet(
                        drawerContainerColor = Color.White
                    ) {
                      Row (
                          horizontalArrangement = Arrangement.SpaceBetween,
                          verticalAlignment = Alignment.CenterVertically,
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(12.dp)){
                          Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                              tint = colorResource(id = R.color.Dark),
                          modifier = Modifier.clickable {
                              scope.launch{
                                  navController.navigate("signin")

                              }
                          }
                          )
                          ClickableText(text = AnnotatedString("Logout"), onClick = {
                              scope.launch{
                                  navController.navigate("signin")

                              }
                          },
                              style = TextStyle(
                                  color = colorResource(id = R.color.Dark)
                              )
                          )
                      }

                    }
                }
            }
        }, drawerState = drawerState
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = color.HalfWhite))
        ) {
            Box {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .background(
                            colorResource(id = color.LightDark).copy(alpha = 0.2f),
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
                        )
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.menu),
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable {
                                        scope.launch {
                                            if (drawerState.isClosed) {
                                                drawerState.open()
                                            } else {
                                                drawerState.close()
                                            }
                                        }
                                    }
                                    .padding(start = 16.dp, top = 16.dp),
                                tint = colorResource(id = color.Dark)
                            )
                            Text(
                                text = "Case Bank",
                                fontSize = 35.sp,
                                color = colorResource(id = color.LightPurple),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 60.dp, top = 12.dp)
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        colorResource(id = color.LightDark).copy(alpha = .3f),
                                        RoundedCornerShape(100)
                                    ),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Icon(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = null,
                                    tint = colorResource(id = color.LightDark)
                                )
                            }
                            Text(
                                text = "Good morning,User",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = color.Dark)
                                )
                            )
                        }
                    }

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
                                1.dp,
                                color = colorResource(id = color.LightDark).copy(alpha = 0.2f),
                                RoundedCornerShape(50)
                            )
                            .clickable {
                                scope.launch {
                                    isSheetOpen = true
                                }
                            },
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "Search",
                                fontSize = 20.sp,
                                color = colorResource(id = color.LightDark)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                tint = colorResource(id = color.LightDark)
                            )
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Weekly Jedgements",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = color.Dark)
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    tint = colorResource(id = color.Dark)
                )
            }

            Row(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .horizontalScroll(horizontalscrollState)
            ) {
                WeeklyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Commision ",
                    judge = "justice Raza Shah"
                )
                WeeklyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission ",
                    judge = "justice Raza Shah"
                )
                WeeklyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Commision ",
                    judge = "justice Raza Shah"
                )
                WeeklyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Commision ",
                    judge = "justice Raza Shah"
                )


            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Monthly Jedgements",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = color.Dark)
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    tint = colorResource(id = color.Dark),
                    modifier = Modifier.size(24.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .verticalScroll(verticalscrollState)
            ) {
                MonthlyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission",
                    judge = "Justice Jeved Ali",
                    color = Color.White
                )
                MonthlyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission",
                    judge = "Justice Jeved Ali",
                    color = Color.White
                )
                MonthlyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission",
                    judge = "Justice Jeved Ali",
                    color = Color.White
                )
                MonthlyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission",
                    judge = "Justice Jeved Ali",
                    color = Color.White
                )
                MonthlyJudgements(
                    navController = rememberNavController(),
                    title = "Election",
                    description = "Election Comission",
                    judge = "Justice Jeved Ali",
                    color = Color.White
                )
            }
        }

        if (isSheetOpen) {
            ModalBottomSheet(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.75f),
                sheetState = sheetState,
                onDismissRequest = {
                    isSheetOpen = false
                },
                containerColor = Color.White
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier

                            .fillMaxWidth()

                    ) {
                        TextField(
                            modifier = Modifier
                                .width(350.dp),
                            value = search,
                            onValueChange = { search = it },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .size(20.dp)
                                )
                            },
                            shape = RoundedCornerShape(50),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = color.HalfWhite),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = colorResource(id = color.Dark),
                                focusedTextColor = colorResource(id = color.Dark)
                            )
                        )

                    }
                    var bottomSheetScroll = rememberScrollState()
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.verticalScroll(bottomSheetScroll)
                    ) {
                        MonthlyJudgements(
                            navController = rememberNavController(),
                            title = "Election",
                            description = "Election Comission",
                            judge = "justice Jeved Ali",
                            color = colorResource(id = color.Orange)
                        )
                        MonthlyJudgements(
                            navController = rememberNavController(),
                            title = "Election",
                            description = "Election Comission",
                            judge = "justice Jeved Ali",
                            color = colorResource(id = color.LightGreen)
                        )
                        MonthlyJudgements(
                            navController = rememberNavController(),
                            title = "Election",
                            description = "Election Comission",
                            judge = "justice Jeved Ali",
                            color = colorResource(id = color.SkyBlue)
                        )
                        MonthlyJudgements(
                            navController = rememberNavController(),
                            title = "Election",
                            description = "Election Comission",
                            judge = "justice Jeved Ali",
                            color = colorResource(id = color.LightGreen)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun WeeklyJudgements(
    navController: NavController,
    title: String,
    description: String,
    judge: String,
) {
    Box(
        modifier = Modifier
            .height(130.dp)
            .width(150.dp)
            .padding(horizontal = 5.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20))


    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier
                .padding(12.dp)
        ) {

            Column {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = color.Dark)
                    )
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 11.sp,
                        color = colorResource(id = color.Dark)
                    )
                )
                Text(
                    text = judge,
                    style = TextStyle(
                        fontSize = 11.sp,
                        color = colorResource(id = color.Dark)
                    )
                )
            }

            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(50.dp)
                    .background(
                        colorResource(id = color.LightPurple),
                        RoundedCornerShape(50)
                    ),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "Open",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

    }

}

@Composable
fun MonthlyJudgements(
    navController: NavController,
    title: String,
    description: String,
    judge: String,
    color: Color,
) {
var scope= rememberCoroutineScope()
    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .background(color = color, shape = RoundedCornerShape(20))

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier
                .padding(12.dp)
        ) {

            Column {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = if (color == Color.White)
                            colorResource(id = R.color.Dark)
                        else Color.White
                    )
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = if (color == Color.White) colorResource(id = R.color.Dark) else Color.White
                    )
                )
                Text(
                    text = judge,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = if (color == Color.White) colorResource(id = R.color.Dark) else Color.White
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp)
                            .background(
                                colorResource(id = R.color.LightPurple),
                                RoundedCornerShape(50)
                            )
                            .clickable {
                                scope.launch {
                                    navController.navigate("pdf")
                                }
                            },
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            text = "Open",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    Home(navController = rememberNavController())
}
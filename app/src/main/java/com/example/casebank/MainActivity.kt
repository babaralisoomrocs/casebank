package com.example.casebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.casebank.casebankapp.Home
import com.example.casebank.casebankapp.PdfViewer
import com.example.casebank.casebankapp.Register
import com.example.casebank.casebankapp.SignIn
import com.example.casebank.casebankapp.SplashScreen
import com.example.casebank.ui.theme.CaseBankTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaseBankTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AppNavHost(navController = rememberNavController())

                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun AppNavHost(navController: NavController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("signin") {
            SignIn(navController)
        }
        composable("register") {
            Register(navController)
        }
        composable("home") {
            Home(navController)
        }
        composable("pdf") {
            PdfViewer()
        }
    }
}


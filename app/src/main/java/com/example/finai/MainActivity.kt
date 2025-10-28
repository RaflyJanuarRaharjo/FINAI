package com.example.finai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finai.auth.OpeningScreen
import com.example.finai.auth.landing.LandingPage
import com.example.finai.ui.auth.signin.SignInScreen
import com.example.finai.ui.auth.signup.SignUpScreen
import com.example.finai.ui.theme.FINAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FINAITheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Routes.OPENING,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(Routes.OPENING) {
                        OpeningScreen(navController = navController)
                    }

                    composable(Routes.LANDING) {
                        LandingPage(navController = navController)
                    }

                    composable(Routes.SIGN_IN) {
                        SignInScreen(navController = navController)
                    }

                    composable(Routes.SIGN_UP) {
                        SignUpScreen(navController = navController)
                    }
                }
            }
        }
    }
}
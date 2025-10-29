package com.example.finai.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finai.R
import com.example.finai.Routes
import kotlinx.coroutines.delay

@Composable
fun OpeningScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        delay(2500L)

        navController.navigate(Routes.LANDING) {
            popUpTo(Routes.OPENING) { inclusive = true }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff294386))
    ) {
        Image(
            painter = painterResource(id = R.drawable.finaii),
            contentDescription = "FinAi Logo",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .requiredWidth(width = 283.dp)
                .requiredHeight(height = 67.dp)
        )
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun OpeningScreenPreview() {
    OpeningScreen(navController = rememberNavController(), Modifier)
}
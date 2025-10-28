package com.example.finai.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finai.R
@Composable
fun AndroidCompact4(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color(0xff294386))
    ) {
        Image(
            painter = painterResource(id = R.drawable.finaii),
            contentDescription = "Screenshot_2025-07-16_155441-removebg-preview 2",
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = (-0.5).dp,
                    y = 412.dp)
                .requiredWidth(width = 283.dp)
                .requiredHeight(height = 67.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact4Preview() {
    AndroidCompact4(Modifier)
}
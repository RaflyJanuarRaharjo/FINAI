package com.example.finai.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.shadow
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.finai.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.layout.ContentScale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidCompact2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
    ) {

        Image(
            // Ganti 'background_wave' dengan nama file Anda di drawable
            painter = painterResource(id = R.drawable.cover),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(), // Membuat gambar memenuhi seluruh Box
            // Ini akan memotong gambar agar pas tanpa merusak rasio (tidak penyok)
            contentScale = ContentScale.Crop
        )
        // white rounded panel
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp, y = 193.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 724.dp)
                .clip(shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                .background(color = Color.White)
        )

        // Title "Get Started"
        Text(
            text = "Get Started",
            color = Color(0xff3250a1),
            textAlign = TextAlign.Center,
            lineHeight = 0.69.em,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(x = 0.dp, y = (-188.5).dp)
                .requiredWidth(width = 194.dp)
                .requiredHeight(height = 50.dp)
        )

        // Form container
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.5.dp, y = 341.dp)
                .requiredWidth(width = 373.dp)
                .requiredHeight(height = 248.dp)
        ) {
            // Name field
            SimpleTextField(text = "Name")

            // Email field
            SimpleTextField(text = "Email")

            // Password field
            PasswordField()

            // Terms / checkbox row
            TermsRow()
        }

        // Tombol Sign Up
        Button(
            onClick = { /* TODO: Tambahkan aksi sign up di sini */ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff3759b3) // Background biru
            ),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 623.dp)
                .requiredWidth(width = 373.dp)
                .requiredHeight(height = 47.dp)
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        // Social sign up row images + label
        Row(
            horizontalArrangement = Arrangement.spacedBy(13.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.dp, y = 721.dp)
        ) {
            // left image (vector206)
            Image(
                painter = painterResource(id = R.drawable.vec206),
                contentDescription = "Vector 206",
                modifier = Modifier
                    .requiredWidth(width = 114.dp)
                    .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
            )

            Text(
                text = "Sign Up With",
                color = Color.Black.copy(alpha = 0.5f),
                lineHeight = 0.8.em,
                style = TextStyle(fontSize = 15.sp)
            )

            // right image (vector207)
            Image(
                painter = painterResource(id = R.drawable.vec207),
                contentDescription = "Vector 207",
                modifier = Modifier
                    .requiredWidth(width = 114.dp)
                    .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
            )
        }

        // Social icons (Facebook, Google, Twitter)
        Row(
            horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(x = (-0.5).dp, y = 340.dp)
        ) {
            SocialButtonFacebook()
            SocialButtonGoogle()
            SocialButtonTwitter()
        }

        // "Already have an account? Sign In" — single row
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.5.dp, y = 865.dp)
        ) {
            Text(
                text = "Already have an account ?",
                color = Color.Black.copy(alpha = 0.5f),
                lineHeight = 1.em,
                style = TextStyle(fontSize = 12.sp)
            )
            Text(
                text = "Sign In",
                color = Color(0xff3759b3),
                lineHeight = 1.em,
                style = TextStyle(fontSize = 12.sp)
            )
        }
    }
}

@Composable
fun SimpleTextField(text: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 47.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                border = BorderStroke(2.dp, Color.Black.copy(alpha = 0.49f)),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = Color.Black.copy(alpha = 0.5f),
            textAlign = TextAlign.Start,
            lineHeight = 1.47.em,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
        )
    }
}


@Composable
fun PasswordField(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 47.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                border = BorderStroke(2.dp, Color.Black.copy(alpha = 0.49f)),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Password",
            color = Color.Black.copy(alpha = 0.5f),
            lineHeight = 1.47.em,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
        )
        Image(
            painter = painterResource(id = R.drawable.iconeye),
            contentDescription = "iconoir:eye",
            modifier = Modifier.requiredSize(size = 24.dp)
        )
    }
}

@Composable
fun TermsRow(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.checkblank),
            contentDescription = "mdi:checkbox-blank-outline",
            tint = Color(0xff192851),
            modifier = Modifier.requiredSize(size = 20.dp)
        )
        Text(
            // --- PERUBAHAN DI SINI ---
            // Hapus lineHeight = 1.sp agar teks membungkus secara normal
            // lineHeight = 1.sp,
            // --- AKHIR PERUBAHAN ---
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append("Dengan Bergabung ke FinAi, saya setuju dengan ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff1877f2),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Syarat & Ketentuan")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append(" serta ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff1877f2),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Kebijakan Privasi")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append(" yang ada.")
                }
            },
            modifier = Modifier.requiredWidth(width = 323.dp)
        )
    }
}

@Composable
fun SocialButtonFacebook(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.facebook),
        contentDescription = "logos:facebook",
        modifier = Modifier.requiredSize(size = 75.dp) // <- 2. Ukuran LOGO 45.dp
    )

}

@Composable
fun SocialButtonGoogle(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.google),
        contentDescription = "devicon:google",
        modifier = Modifier.requiredSize(size = 75.dp) // <- 2. Ukuran LOGO 45.dp
    )

}

@Composable
fun SocialButtonTwitter(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.twitter),
        contentDescription = "prime:twitter",
        modifier = Modifier.requiredSize(size = 75.dp) // <- 2. Ukuran LOGO 45.dp
    )

}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact2Preview() {
    AndroidCompact2()
}
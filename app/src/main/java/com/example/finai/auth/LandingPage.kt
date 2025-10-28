package com.example.finai.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

@Composable
fun AndroidCompact5(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color(0xff294386))
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 917.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vec203),
                contentDescription = "Vector 203",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = (-26).dp)
                    .requiredWidth(width = 520.dp)
                    .requiredHeight(height = 999.dp))
            Image(
                painter = painterResource(id = R.drawable.vec201),
                contentDescription = "Vector 201",
                modifier = Modifier
                    .requiredWidth(width = 332.dp)
                    .requiredHeight(height = 917.dp))
            Image(
                painter = painterResource(id = R.drawable.vec204),
                contentDescription = "Vector 204",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 171.dp,
                        y = 0.dp)
                    .requiredWidth(width = 241.dp)
                    .requiredHeight(height = 314.dp))
            Image(
                painter = painterResource(id = R.drawable.vec205),
                contentDescription = "Vector 205",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 226.dp,
                        y = 36.dp)
                    .requiredWidth(width = 191.dp)
                    .requiredHeight(height = 184.dp))
            Image(
                painter = painterResource(id = R.drawable.ling107), // Ganti 'your_image_name' dengan nama resource gambar Anda
                contentDescription = "Deskripsi gambar Anda", // Berikan deskripsi yang sesuai untuk aksesibilitas
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 206.dp,
                        y = 114.dp)
                    .requiredWidth(width = 106.dp)
                    .requiredHeight(height = 107.dp)
                    .clip(shape = CircleShape) // Pertahankan ini jika Anda ingin gambar tetap berbentuk lingkaran
            )
            Image(
                painter = painterResource(id = R.drawable.vec202),
                contentDescription = "Vector 202",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 256.dp)
                    .requiredWidth(width = 412.dp)
                    .requiredHeight(height = 661.dp))

            // --- ✅ SATU-SATUNYA COLUMN TEKS "WELCOME BACK" ---
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(x = 0.5.dp,
                        y = (-20.5).dp)
                    .requiredWidth(width = 397.dp)
                    .requiredHeight(height = 120.dp)
                    .padding(all = 10.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    modifier = Modifier
                        .requiredWidth(width = 253.dp)
                ) {
                    Text(
                        text = "Welcome Back !",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 0.69.em,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier
                            .fillMaxWidth())
                    Text(
                        text = "Manage your money smartly with your personal AI assistant.",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.47.em,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .fillMaxWidth())
                }
            }
            // --- 🛑 AKHIR DARI COLUMN TEKS ---

            Image(
                painter = painterResource(id = R.drawable.ling105), // Ganti 'some_image' dengan nama resource gambar Anda
                contentDescription = "Deskripsi gambar Anda", // Berikan deskripsi yang sesuai
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 53.dp,
                        y = 482.dp)
                    .requiredSize(size = 83.dp)
                    .clip(shape = CircleShape) // Jika gambar Anda juga ingin berbentuk lingkaran
            )
            Image(
                painter = painterResource(id = R.drawable.ling104), // Ganti 'your_image_name' dengan nama resource gambar Anda
                contentDescription = "Deskripsi gambar Anda", // Berikan deskripsi yang sesuai untuk aksesibilitas
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 70.dp,
                        y = 589.dp)
                    .requiredWidth(width = 203.dp)
                    .requiredHeight(height = 208.dp)
                    // Anda bisa memilih untuk mempertahankan shadow jika diinginkan, atau menghapusnya jika gambar sudah memiliki efek visual yang diinginkan
            )

            SignInButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .offset(x = 0.dp,
                        y = (-1).dp))

            SignUpButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .offset(x = 0.dp,
                        y = (-1).dp))
        }

        // --- ❌ COLUMN TEKS YANG DUPLIKAT SUDAH DIHAPUS DARI SINI ---

    }
}

@Composable
fun SignInButton(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 65.5.dp,
                vertical = 40.dp)
    ) {
        Text(
            text = "Sign In",
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 1.1.em,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .requiredWidth(width = 82.dp))
    }
}

@Composable
fun SignUpButton(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            // .background(color = Color(0xff21356b)) // <-- HAPUS BARIS INI
            .padding(horizontal = 61.5.dp,
                vertical = 40.dp)
    ) {
        Text(
            text = "Sign Up",
            color = Color.White, // <-- HATI-HATI DENGAN INI
            textAlign = TextAlign.Center,
            lineHeight = 1.1.em,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .requiredWidth(width = 75.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact5Preview() {
    AndroidCompact5(Modifier)
}
package com.example.finai.forum // Pastikan package Anda sesuai

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R // Pastikan R di-import dengan benar

@Composable
fun AndroidCompact32(modifier: Modifier = Modifier) {
    // State untuk menyimpan input dari pengguna
    var inputText by remember { mutableStateOf("") }
    val headerBlue = Color(0xff3759b3)
    val backgroundGray = Color(0xfff6f6f6)
    val textGray = Color(0xff484c52)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundGray) // Latar belakang utama
    ) {
        // 1. Top App Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(152.dp) // Menyamai offset original (152.dp)
                .background(color = headerBlue)
                .padding(top = 60.dp), // Perkiraan padding untuk menengahkan konten
            contentAlignment = Alignment.Center
        ) {
            // Tombol Kembali
            IconButton(
                onClick = { /* TODO: Handle back navigation */ },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = "Back",
                    modifier = Modifier
                        .requiredSize(size = 31.dp)
                        .rotate(degrees = 360f) // Sesuai kode terakhir Anda
                )
            }
            // Judul
            Text(
                text = "Forum",
                color = Color.White,
                lineHeight = 0.67.em,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // 2. Area Konten (Input Post)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Foto Profil
                Image(
                    painter = painterResource(id = R.drawable.ftprof),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape) // Bentuk lingkaran untuk foto profil
                        .shadow(elevation = 4.dp, shape = CircleShape)
                )

                // Kolom untuk Input dan Tombol
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.Start // Tombol "Post" akan rata kiri
                ) {
                    // Info Pengguna
                    Text(
                        text = "AlbertJay | Mahasiswa Akhir & Freelancer",
                        color = Color.Black,
                        lineHeight = 1.25.em,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp) // Menyamai padding asli
                    )

                    // Input Field (Sudah berfungsi)
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it }, // Ini yang membuatnya bisa diisi
                        placeholder = {
                            Text(
                                text = "Input Text",
                                color = textGray
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = textGray,
                            unfocusedBorderColor = textGray,
                            // PERUBAHAN DI SINI
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )

                    // Tombol Post
                    Button(
                        onClick = { /* TODO: Handle post action */ },
                        shape = RoundedCornerShape(14.dp), // Sesuai perubahan Anda
                        colors = ButtonDefaults.buttonColors(
                            containerColor = headerBlue // Menggunakan warna biru header
                        ),
                        contentPadding = PaddingValues(horizontal = 30.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "Post",
                            color = Color.White,
                            lineHeight = 1.5.em,
                            style = TextStyle(fontSize = 14.sp) // Sesuai perubahan Anda
                        )
                    }
                }
            }
        }

        // TODO: Tambahkan LazyColumn untuk daftar postingan forum di sini
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact32Preview() {
    // Membungkus dengan Tema akan memberikan style default Material
    MaterialTheme {
        AndroidCompact32(Modifier)
    }
}
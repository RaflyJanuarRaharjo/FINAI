package com.example.finai.forum // Pastikan package Anda sesuai

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AndroidCompact34(modifier: Modifier = Modifier) {
    val headerBlue = Color(0xff3759b3)
    val backgroundGray = Color(0xfff6f6f6)
    val textGray = Color(0xff484c52)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundGray) // Latar belakang abu-abu
    ) {
        // 1. Top App Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(152.dp) // Ketinggian sama dengan offset asli
                .background(color = headerBlue)
                .padding(top = 60.dp), // Padding untuk menengahkan
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
                        .rotate(degrees = 360f) // Rotasi 90 derajat (panah ke kiri)
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

        // 2. Area Konten Postingan (Sesuai Gambar)
        Row(
            // Padding horizontal 24.dp dan vertikal 26.dp (178 - 152)
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 26.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Foto Profil
            Image(
                painter = painterResource(id = R.drawable.ftprof),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .shadow(elevation = 4.dp, shape = CircleShape)
            )

            // Kolom untuk Info, Konten, dan Tombol
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Info Pengguna
                Text(
                    text = "AlbertJay | Mahasiswa Akhir & Freelancer",
                    color = Color.Black,
                    lineHeight = 1.25.em,
                    style = TextStyle(fontSize = 12.sp)
                )

                // Kotak Konten Postingan
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(
                            border = BorderStroke(1.dp, textGray),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(all = 20.dp)
                ) {
                    Text(
                        text = "Aku mulai investasi dari penghasilan freelance, bukan gaji tetap. Jadi bukan soal besar kecilnya, tapi soal kebiasaan.\nTipsku:\n✅ Mulai dari nominal kecil (Rp100.000/bulan)\n✅ Ikut komunitas seperti FinAI ini, biar makin semangat! 🔥",
                        color = Color.Black,
                        lineHeight = 1.5.em,
                        style = TextStyle(fontSize = 10.sp),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Tombol Post
                Button(
                    onClick = { /* TODO: Handle post action */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = headerBlue // Memperbaiki error AppColors
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "Post",
                        color = Color.White,
                        lineHeight = 1.5.em,
                        style = TextStyle(fontSize = 10.sp)
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 412, heightDp = 917, showBackground = true)
@Composable
private fun AndroidCompact34Preview() {
    MaterialTheme {
        AndroidCompact34(Modifier)
    }
}
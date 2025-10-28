package com.example.finai.profile // Pastikan package Anda sesuai

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // Import semua komponen layout
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button // Import Button
import androidx.compose.material3.ButtonDefaults // Import ButtonDefaults
import androidx.compose.material3.IconButton // Import IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField // Import OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults // Import OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // Import getValue
import androidx.compose.runtime.mutableStateOf // Import mutableStateOf
import androidx.compose.runtime.remember // Import remember
import androidx.compose.runtime.setValue // Import setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale // Import ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

// Mendefinisikan warna untuk menggantikan AppColors
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color.Black.copy(alpha = 0.5f)
private val BorderGray = Color(0xff1e1e1e)

@Composable
fun AndroidCompact48(modifier: Modifier = Modifier) {

    // State untuk menyimpan teks pencarian
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // --- MODIFIED SECTION START ---
        // 1. Top App Bar (Custom) - Diubah sesuai gaya AndroidCompact46
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(152.dp) // Ketinggian sama dengan offset
                .background(NormalBlue)
            // Hapus contentAlignment dan padding Box
        ) {
            // Tombol Kembali
            IconButton(
                onClick = { /* TODO: Handle back navigation */ },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 30.dp, top = 61.dp) // Padding dari 46
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(31.dp)
                        .rotate(degrees = 360f) // Diubah ke 90f (panah kembali)
                )
            }
            // Judul
            Text(
                text = "Set Location",
                color = Color.White,
                lineHeight = 0.67.em,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .padding(top = 70.dp) // Padding dari 46
            )
        }
        // --- MODIFIED SECTION END ---


        // 2. Konten (Peta dan Bottom Sheet)
        Box(
            modifier = Modifier
                .fillMaxSize() // Mengisi sisa ruang
        ) {
            // Peta sebagai latar belakang
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = "Map Background",
                contentScale = ContentScale.Crop, // Memastikan peta mengisi Box
                modifier = Modifier.fillMaxSize()
            )

            // Bottom Sheet (mengambang di atas peta)
            Column(
                verticalArrangement = Arrangement.spacedBy(21.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Menempel di bawah
                    .padding(horizontal = 26.dp, vertical = 30.dp) // Padding dari tepi
                    .fillMaxWidth() // Mengisi lebar
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color.White)
                    .border(
                        border = BorderStroke(1.dp, NormalBlue), // Memperbaiki AppColors
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(all = 20.dp)
            ) {
                // Search Bar Fungsional (BISA DI-INPUT)
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it }, // Ini yang membuatnya fungsional
                    placeholder = {
                        Text(
                            text = "Cari atau pilih di Peta",
                            color = TextGray,
                            style = TextStyle(fontSize = 12.sp)
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(28.dp) // <-- UKURAN IKON PENCARIAN DIPERBESAR DI SINI
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = BorderGray,
                        focusedBorderColor = NormalBlue,
                        // PERUBAHAN DI SINI
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    singleLine = true
                )

                // Tombol Fungsional
                Button(
                    onClick = { /* TODO: Handle save location */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NormalBlue // Memperbaiki AppColors
                    ),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ) {
                    Text(
                        text = "SAVE LOCATION",
                        color = Color.White,
                        lineHeight = 1.42.em,
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact48Preview() {
    AndroidCompact48(Modifier)
}
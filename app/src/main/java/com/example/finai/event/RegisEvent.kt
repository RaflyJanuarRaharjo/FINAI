package com.example.finai.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn // <-- Import ditambahkan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import com.example.finai.R
// --- IMPORT BARU DITAMBAHKAN ---
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
// --- AKHIR IMPORT BARU ---

@Composable
fun AndroidCompact28(modifier: Modifier = Modifier) {

    // --- TAMBAHKAN STATE UNTUK INPUT ---
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize() // Gunakan fillMaxSize
            .background(color = Color(0xff3759b3))
    ) {
        Text(
            text = "Nearby event",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .padding(top = 70.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "Back Arrow", // Deskripsi lebih baik
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 26.dp, top = 71.dp)
                .requiredSize(size = 31.dp)
                .rotate(degrees = 360f) // <-- Perbaikan rotasi
        )

        // --- Box Kontainer Putih ---
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter) // Align ke bawah Box utama
                .padding(top = 152.dp) // Jarak dari atas
                .fillMaxWidth()        // Isi lebar
                .fillMaxHeight()       // Isi sisa tinggi layar
                .background(
                    color = Color(0xfff6f6f6),
                )
        ) {

            // --- LazyColumn ---
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.nearbyevent),
                        contentDescription = "Event Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(height = 155.dp)
                    )
                }
                item {
                    Column(modifier = Modifier.padding(horizontal = 20.dp)){
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {
                            Text(
                                text = "Talk Show Investasi Saham : \nUpdate terbaru saham 2025",
                                color = Color.Black,
                                lineHeight = 1.25.em,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(color = Color(0xffE1E6F4))
                                    .padding(horizontal = 12.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = "Invest",
                                    color = Color(0xff192851),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp))
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(color = Color(0xffc7e7c1))
                                    .padding(horizontal = 12.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = "Beginner",
                                    color = Color(0xff254a24),
                                    lineHeight = 1.33.em,
                                    style = TextStyle(
                                        fontSize = 12.sp))
                            }
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .background(color = Color(0xffededed).copy(alpha = 0.59f))
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color(0xFF6200EE))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_calendar),
                                contentDescription = "Date & Time Icon",
                                colorFilter = ColorFilter.tint(Color.White),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Date & Time",
                                color = Color.Black.copy(alpha = 0.7f),
                                lineHeight = 1.14.em,
                                style = TextStyle(fontSize = 14.sp)
                            )
                            Text(
                                text = "Saturday, 18 July 2025",
                                color = Color.Black,
                                lineHeight = 1.1.em,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "09:00 - 12:00 WIB",
                                color = Color.Black.copy(alpha = 0.7f),
                                lineHeight = 1.14.em,
                                style = TextStyle(fontSize = 14.sp)
                            )
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .background(color = Color(0xffededed).copy(alpha = 0.59f))
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color(0xffeb383b))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_location),
                                contentDescription = "Location Icon",
                                colorFilter = ColorFilter.tint(Color.White),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Location",
                                color = Color.Black.copy(alpha = 0.7f),
                                lineHeight = 1.14.em,
                                style = TextStyle(fontSize = 14.sp)
                            )
                            Text(
                                text = "Samantha Krida UB",
                                color = Color.Black,
                                lineHeight = 1.1.em,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "Jl. MT. Haryono, Ketawanggede",
                                color = Color.Black.copy(alpha = 0.7f),
                                lineHeight = 1.14.em,
                                style = TextStyle(fontSize = 14.sp)
                            )
                        }
                    }
                }
                // --- Input Fields Section ---
                item {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(
                            text = "Full Name",
                            color = Color.Black,
                            lineHeight = 1.47.em,
                            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.fillMaxWidth()
                        )
                        // --- PERUBAHAN DI SINI ---
                        NameInputField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(
                            text = "Email Address",
                            color = Color.Black,
                            lineHeight = 1.47.em,
                            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.fillMaxWidth()
                        )
                        // --- PERUBAHAN DI SINI ---
                        EmailInputField(
                            value = email,
                            onValueChange = { email = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                // --- Register Button ---
                item {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xff3759b3))
                            .padding(vertical = 14.dp)
                    ) {
                        Text(
                            text = "Regist Now",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.47.em,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold)
                        )
                    }
                }
            } // Akhir LazyColumn
        } // Akhir Box putih
    } // Akhir Box utama
}


// --- FUNGSI INI DIUBAH TOTAL ---
@Composable
fun NameInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = {
            Text(
                "Input Name",
                color = Color.Black.copy(alpha = 0.5f),
                style = TextStyle(fontWeight = FontWeight.Normal)
            )
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black.copy(alpha = 0.3f),
            focusedBorderColor = Color(0xff3759b3), // Warna biru saat di-klik
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}


// --- FUNGSI INI DIUBAH TOTAL ---
@Composable
fun EmailInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = {
            Text(
                "Input Email",
                color = Color.Black.copy(alpha = 0.5f),
                style = TextStyle(fontWeight = FontWeight.Normal)
            )
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), // Keyboard email
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black.copy(alpha = 0.3f),
            focusedBorderColor = Color(0xff3759b3), // Warna biru saat di-klik
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact28Preview() {
    // Tambahkan background putih di preview agar lebih jelas
    Box(modifier = Modifier.background(Color.White)){
        AndroidCompact28(Modifier)
    }
}
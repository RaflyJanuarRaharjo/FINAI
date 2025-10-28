package com.example.finai.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Import all layout components
import androidx.compose.foundation.rememberScrollState // Import untuk scrolling
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll // Import untuk scrolling
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

// Mendefinisikan warna untuk menggantikan AppColors yang error
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val DarkBlue = Color(0xff192851) // Warna untuk border foto profil
private val FieldGray = Color(0xffe4e4e4) // Warna field dari kode Anda
private val TextGray = Color.Black.copy(alpha = 0.5f)

@Composable
fun AndroidCompact44(modifier: Modifier = Modifier) {

    // --- State Hoisting: Menyimpan nilai dari setiap field ---
    var name by remember { mutableStateOf("Albert Jayendra") }
    var institution by remember { mutableStateOf("Computer Science UB") }
    var email by remember { mutableStateOf("albertjay@gmail.com") }
    var password by remember { mutableStateOf("*********") }
    var phoneNumber by remember { mutableStateOf("+6281931634187") }

    // --- MODIFIED: Box utama diganti Column agar bisa scroll semua ---
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightGray) // Latar belakang utama adalah abu-abu
            .verticalScroll(rememberScrollState()) // <-- SEMUA BISA DI-SCROLL
    ) {

        // 1. Top App Bar (Custom)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(152.dp) // Ketinggian sama dengan offset
                .background(NormalBlue)
                .padding(top = 60.dp), // Padding untuk status bar
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
                        .size(31.dp)
                        .rotate(degrees = 360f) // 90 derajat = panah ke kiri
                )
            }
            // Judul
            Text(
                text = "Edit Profile",
                color = Color.White,
                lineHeight = 0.67.em,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // 2. Konten (Sekarang bagian dari scroll)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                // --- MODIFIED: Hapus .weight(1f) dan .verticalScroll()
                .padding(horizontal = 30.dp, vertical = 32.dp), // Padding untuk konten
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp) // Jarak antara foto dan field
        ) {

            // --- Bagian Foto Profil ---
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp) // Ukuran konsisten
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotoprofile),
                    contentDescription = "User Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .shadow(elevation = 4.dp, shape = CircleShape)
                        .clip(shape = CircleShape)
                        .border(
                            border = BorderStroke(5.dp, DarkBlue), // Menggunakan DarkBlue
                            shape = CircleShape
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "Edit Profile Picture",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(37.dp)
                )
            }

            // --- Bagian Field Input ---
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp) // Jarak antar field
            ) {
                EditProfileField(
                    label = "Name",
                    value = name,
                    onValueChange = { name = it }
                )
                EditProfileField(
                    label = "Institution",
                    value = institution,
                    onValueChange = { institution = it }
                )
                EditProfileField(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it }
                )
                PasswordField(
                    value = password,
                    onValueChange = { password = it }
                )
                EditProfileField(
                    label = "Phone number",
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it }
                )
            }
        } // Akhir dari Column konten

        // 3. Tombol "Save Changes" (Sekarang bagian dari scroll)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                // --- MODIFIED: Hapus .align(Alignment.BottomCenter) ---
                .padding(bottom = 28.dp, start = 40.dp, end = 40.dp) // Padding dari bawah
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = NormalBlue)
                .clickable { /* TODO: Handle Save Action */ }
                .padding(vertical = 15.dp) // Padding di dalam tombol
        ) {
            Text(
                text = "Save Changes",
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 1.1.em,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    } // Akhir dari Column utama (yang bisa di-scroll)
}

// --- Composable Kustom untuk Input Field ---
@Composable
fun EditProfileField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(11.dp) // Jarak label dan field
    ) {
        Text( // Label
            text = label,
            color = Color.Black,
            lineHeight = 1.em,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 10.dp) // Padding label
        )
        // Field Input
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            ),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = FieldGray,
                unfocusedContainerColor = FieldGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = TextGray,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true
        )
    }
}

// --- Composable Kustom untuk Password Field ---
@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(11.dp) // Jarak label dan field
    ) {
        Text( // Label
            text = "Password",
            color = Color.Black,
            lineHeight = 1.em,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 10.dp) // Padding label
        )
        // Field Input
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = FieldGray,
                unfocusedContainerColor = FieldGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = TextGray,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            ),
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                // TODO: Ganti R.drawable.close_eye dengan ikon "mata terbuka"
                val imageRes = if (isPasswordVisible)
                    R.drawable.close_eye // Ganti dengan ikon mata terbuka
                else
                    R.drawable.close_eye

                val description = if (isPasswordVisible) "Hide password" else "Show password"

                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(id = imageRes),
                        contentDescription = description,
                        modifier = Modifier.size(20.dp),
                        tint = TextGray
                    )
                }
            }
        )
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact44Preview() {
    AndroidCompact44(Modifier)
}
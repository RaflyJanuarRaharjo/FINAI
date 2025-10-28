package com.example.finai.profile // Assuming package from context

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // Added clickable
import androidx.compose.foundation.layout.* // Import all layout components
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults // Not used
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

// Define standard colors (adjust if needed)
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)


@Composable
fun AndroidCompact50(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            // Semi-transparent background for pop-up effect
            .background(color = Color.Black.copy(alpha = 0.52f))
            .padding(horizontal = 40.dp), // Padding around the pop-up
        contentAlignment = Alignment.Center // Center the pop-up Column
    ) {
        // --- Main Pop-up Content Column ---
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp), // Space between sections
            modifier = Modifier
                // .align(alignment = Alignment.Center) // Handled by parent Box
                // .offset(x = 0.5.dp, y = (-48).dp) // Use alignment/padding instead
                .fillMaxWidth() // Allow pop-up to take width within parent padding
                // .requiredWidth(width = 323.dp) // Removed fixed width
                .shadow(elevation = 8.dp, // Apply shadow first
                    shape = RoundedCornerShape(20.dp))
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color.White)
                // Border might be redundant with shadow, uncomment if needed
                // .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.1f)),
                //    shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 20.dp, vertical = 30.dp) // Inner padding
        ) {
            // --- Image ---
            Image(
                painter = painterResource(id = R.drawable.pop_loc),
                contentDescription = "Location Saved Illustration",
                contentScale = ContentScale.FillWidth, // <-- Ubah ini
                modifier = Modifier
                    .fillMaxWidth(0.8f) // <-- Biarkan 80% lebar pop-up
                    .heightIn(min = 164.dp, max = 250.dp) // <-- Atur rentang tinggi, misal 250.dp
                    .padding(bottom = 10.dp)
            )

            // --- Text Section ---
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp), // Space between title and description
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text( // Title Text
                    text = "Yeay! Lokasimu sudah tersimpan.",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    //lineHeight = 2.19.em, // Let Compose manage line height
                    style = TextStyle(
                        fontSize = 18.sp, // Slightly larger title
                        fontWeight = FontWeight.Bold
                    )
                )
                Text( // Description Text
                    text = "Data lokasi berhasil ditambahkan ke akunmu.",
                    color = Color.Black.copy(alpha = 0.8f), // Slightly lighter
                    textAlign = TextAlign.Center,
                    // lineHeight = 2.5.em,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal // Normal weight usually better for body text
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp) // Padding if text is long
                )
            }

            // --- Back Button ---
            Row( // Using Row to mimic Button appearance
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp) // Add space above button
                    // .requiredHeight(height = 35.dp) // Let content + padding define height
                    .clip(shape = RoundedCornerShape(10.dp)) // Use consistent corner radius
                    .background(color = NormalBlue) // Use defined color
                    .clickable { /* TODO: Add Back Action */ }
                    .padding(horizontal = 40.dp, vertical = 8.dp) // Adjust padding
            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    //lineHeight = 2.19.em,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        } // End Main Column
    } // End Root Box
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact50Preview() {
    AndroidCompact50(Modifier)
}
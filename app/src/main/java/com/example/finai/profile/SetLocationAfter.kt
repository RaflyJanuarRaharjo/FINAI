package com.example.finai.profile // Assuming package based on context

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // Added clickable
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow // Keep shadow if needed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale // Added ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight // Keep if needed for style
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
fun AndroidCompact49(modifier: Modifier = Modifier) { // Renamed function
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue) // Use defined color
    ) {
        // --- Header Text ---
        Text(
            text = "Set Location",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .padding(top = 79.dp) // Use padding
        )
        // --- Back Arrow ---
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 26.dp, top = 71.dp) // Use padding
                .size(size = 31.dp) // Use size
                .rotate(degrees = 360f) // <-- FIX: Rotate left
                .clickable { /* TODO: Handle back navigation */ }
        )
        // --- Map Image (Takes up background space) ---
        Image(
            painter = painterResource(id = R.drawable.map), // Ensure this exists
            contentDescription = "Map Background",
            contentScale = ContentScale.Crop, // Crop to fill the bounds
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align map to bottom first
                .fillMaxWidth()
                .fillMaxHeight() // Fill available space
                .padding(top = 152.dp) // Start below blue header
        )

        // --- Location Pin Overlay (Placeholder Positioning) ---
        // This Box is positioned roughly center screen over the map.
        // In a real app, its position would depend on map logic.
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center) // Center the Row horizontally
                .padding(bottom = 100.dp) // Adjust vertical position relative to center
                // .offset(x = 137.dp, y = 390.dp) // Removed hardcoded offset
                // .requiredWidth(width = 182.dp) // Let Row wrap content
                // .requiredHeight(height = 24.dp)
                .background(Color.White.copy(alpha=0.7f), RoundedCornerShape(12.dp)) // Semi-transparent bg
                .padding(horizontal = 8.dp, vertical = 4.dp) // Padding inside the row
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location), // Ensure this exists
                contentDescription = "Current Location Pin",
                modifier = Modifier.size(18.dp) // Smaller icon
            )
            Spacer(Modifier.width(4.dp)) // Space between icon and text
            Text(
                text = "Jalan Kertosentono No. 25a",
                color = Color.Black.copy(alpha = 0.8f),
                //lineHeight = 1.em,
                style = TextStyle(fontSize = 12.sp),
                // Removed align and offset as Row handles alignment
            )
        }


        // --- Bottom White Panel ---
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp), // Adjusted spacing
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter) // Align panel to bottom
                .fillMaxWidth() // Take full width
                .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) // Round top corners before background
                .background(color = Color.White)
                .padding(horizontal = 20.dp, vertical = 25.dp) // Padding inside the panel
        ) {
            LocationDisplayBar( // Use renamed composable
                modifier = Modifier.fillMaxWidth(),
                locationText = "Jalan Kertosentono No. 25a" // Pass the text
            )

            // --- Save Location Button ---
            Row(
                horizontalArrangement = Arrangement.Center, // Center text
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth() // Fill width within padding
                    .padding(horizontal = 30.dp) // Reduce button horizontal padding a bit
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = NormalBlue) // Use defined color
                    .clickable { /* TODO: Handle save action */ }
                    .padding(vertical = 12.dp) // Adjust button padding
            ) {
                Text(
                    text = "SAVE LOCATION",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp, // Slightly larger font
                        fontWeight = FontWeight.Bold // Make it bold
                    ),
                )
            }
        }
    } // End Root Box
}

// --- Renamed Search/Display Bar Composable ---
@Composable
fun LocationDisplayBar(modifier: Modifier = Modifier, locationText: String = "Cari atau pilih di Peta") {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Adjust spacing
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier // Use passed modifier (e.g., fillMaxWidth)
            .height(48.dp) // Consistent height
            .clip(shape = RoundedCornerShape(10.dp)) // Clip before border/background
            .background(Color.White) // Ensure background if parent isn't white
            .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.3f)), // Lighter border
                shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp) // Adjusted padding
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_search), // Ensure this exists
            contentDescription = "Search Icon",
            modifier = Modifier.size(20.dp) // Adjusted size
        )
        Text( // Removed inner Row
            text = locationText, // Use parameter
            color = Color.Black.copy(alpha = 0.5f),
            maxLines = 1, // Prevent wrapping
            style = TextStyle(fontSize = 14.sp), // Slightly larger font
            modifier = Modifier.weight(1f) // Take remaining space
        )
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact48Preview() { // Renamed Preview function
    AndroidCompact49(Modifier) // Call the correct composable
}
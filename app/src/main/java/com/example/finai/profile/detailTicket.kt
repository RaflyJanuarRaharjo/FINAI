package com.example.finai.profile // Assuming package based on previous context

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // Import clickable
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.lazy.LazyColumn // Import LazyColumn
import androidx.compose.foundation.shape.CircleShape // Import CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider // Import Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.* // Import runtime
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush // Import Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.geometry.Offset // Import Offset
import androidx.compose.ui.layout.ContentScale // Import ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R // Assuming R is in base package

// Define standard colors
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)

@Composable
fun AndroidCompact52(modifier: Modifier = Modifier) {

    // Removed tab state as tabs are not used in this version

    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue)
    ) {
        Text(
            text = "Detail",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .padding(top = 70.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 26.dp, top = 71.dp)
                .size(size = 31.dp)
                .rotate(degrees = 360f) // Rotated left
                .clickable { /* TODO: Handle back navigation */ }
        )

        // --- Background Box for Content ---
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 152.dp) // Start below blue header area
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp) // Rounded top corners
                )
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp) // Padding at the very bottom
            ) {

                // --- Ticket Header ---
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp) // Padding for the header
                        .clip(shape = RoundedCornerShape(15.dp)) // Rounded corners for the header
                        .background(brush = Brush.linearGradient(
                            0f to Color(0xff131f3f),
                            1f to Color(0xff3251a5),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        ))
                        .padding(horizontal = 20.dp, // Inner padding
                            vertical = 20.dp)
                ) {
                    Column( // Column for Title and Subtitle
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Talk Show Investasi Saham :",
                            color = Color.White,
                            maxLines = 2, // Allow wrapping
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold) // Bold title
                        )
                        Text(
                            text = "GENERAL ADMISSION",
                            color = Color.White.copy(alpha=0.8f), // Lighter subtitle
                            style = TextStyle(fontSize = 14.sp)
                        )
                    }
                    Image( // Ticket Icon
                        painter = painterResource(id = R.drawable.ticketdetail), // Ensure this exists
                        contentDescription = "Ticket Icon",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(32.dp) // Consistent size
                    )
                } // End Ticket Header Row

                // --- Scrollable Details Section ---
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Space between items
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(horizontal = 20.dp), // Padding for list content
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Takes remaining space in the outer Column
                ) {
                    item { // Date & Time Card
                        DetailCard(
                            iconRes = R.drawable.ic_calendar, // Use correct resource name
                            iconBgColor = Color(0xFF6200EE), // Example Purple
                            label = "Date & Time",
                            line1 = "Saturday, 18 July 2025",
                            line2 = "09:00 - 12:00 WIB"
                        )
                    }
                    item { // Location Card
                        DetailCard(
                            iconRes = R.drawable.ic_location, // Use correct resource name
                            iconBgColor = Color(0xffeb383b), // Red
                            label = "Location",
                            line1 = "Samantha Krida UB",
                            line2 = "Jl. MT. Haryono, Ketawanggede"
                        )
                    }
                    item { // Divider
                        Divider(
                            color = TextGray.copy(alpha = 0.3f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        )
                    }
                    item { // Attendee Info Title
                        Text(
                            text = "Attendee Information",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .fillMaxWidth() // Align text left
                                .padding(bottom = 5.dp) // Space below title
                        )
                    }
                    item { // Attendee Details
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fotoprofile), // Ensure exists
                                contentDescription = "Attendee Profile Picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp) // Slightly smaller picture
                                    .clip(shape = CircleShape)
                                    .border(border = BorderStroke(1.dp, Color.Gray), shape = CircleShape)
                            )
                            Spacer(Modifier.width(15.dp)) // Space between image and text
                            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                Text(
                                    text = "Albert Jayendra",
                                    color = Color.Black,
                                    style = TextStyle(
                                        fontSize = 18.sp, // Slightly smaller name
                                        fontWeight = FontWeight.Bold)
                                )
                                Text(
                                    text = "Computer Science",
                                    color = TextGray,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal) // Normal weight
                                )
                            }
                        }
                    }
                    item { // Email Row
                        DetailRow(iconRes = R.drawable.ic_email, text = "albertjay@gmail.com")
                    }
                    item { // Ticket ID Row
                        DetailRow(iconRes = R.drawable.ic_hastag, text = "TSIS25 - 182025")
                    }
                    item { // Divider before QR
                        Divider(
                            color = TextGray.copy(alpha = 0.3f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        )
                    }
                    item { // QR Code Section
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .border(
                                    border = BorderStroke(2.dp, Color.LightGray), // Border around QR area
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(20.dp), // Padding inside QR area
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.qrcode), // Ganti dengan ID resource QR code Anda
                                contentDescription = "QR Code for Event",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(160.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )

                            Spacer(Modifier.height(10.dp))

                            Text(
                                text = "Show this QR code at the entrance",
                                color = TextGray,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium)
                            )
                        }
                    }
                } // End LazyColumn Items
            } // End Content Column (inside white box)
        } // End White Background Box
    } // End Root Box
}

// --- Reusable Composable for Detail Cards (Date/Location) ---
@Composable
fun DetailCard(
    @DrawableRes iconRes: Int,
    iconBgColor: Color,
    label: String,
    line1: String,
    line2: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18.dp))
            .background(color = Color.White) // White background for cards
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Box( // Icon container
            modifier = Modifier
                .size(56.dp) // Consistent icon container size
                .clip(shape = RoundedCornerShape(10.dp))
                .background(iconBgColor)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "$label Icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(24.dp)
            )
        }
        Column( // Text content
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = label,
                color = Color.Black.copy(alpha = 0.7f),
                style = TextStyle(fontSize = 14.sp)
            )
            Text(
                text = line1,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp, // Slightly smaller main text
                    fontWeight = FontWeight.Bold)
            )
            Text(
                text = line2,
                color = Color.Black.copy(alpha = 0.7f),
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

// --- Reusable Composable for Detail Rows (Email/Ticket ID) ---
@Composable
fun DetailRow(
    @DrawableRes iconRes: Int,
    text: String
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp), // Keeps space between icon and text
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth() // <-- PERBAIKAN DI SINI
            .padding(vertical = 4.dp) // Keep vertical padding
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "$text icon",
            colorFilter = ColorFilter.tint(TextGray), // Consistent tint
            modifier = Modifier.size(20.dp) // Consistent icon size
        )
        Text(
            text = text,
            color = Color.Black,
            // lineHeight = 1.33.em,
            style = TextStyle(fontSize = 14.sp) // Consistent text size
        )
    }
}


// --- TabItem Composable (Removed as tabs are not used) ---
/*
@Composable
fun RowScope.TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) { ... }
*/


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact52Preview() {
    AndroidCompact52(Modifier)
}
package com.example.finai.profile // Changed package to profile based on previous context

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // <-- Import added
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.lazy.LazyColumn // <-- Import added
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface // Keep if needed for EventItem
import androidx.compose.material3.Text
import androidx.compose.runtime.* // <-- Import added (remember, mutableStateOf, ...)
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R // Assuming R is in the base package

// Define standard colors
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)
private val UpcomingYellow = Color(0xffe19b2a)
private val UpcomingYellowBg = Color(0xffffc973).copy(alpha = 0.5f)
private val CompletedGreen = Color(0xff319f43)
private val CompletedGreenBg = Color(0xffa5ffb3).copy(alpha = 0.5f)

@Composable
fun AndroidCompact47(modifier: Modifier = Modifier) { // Renamed function for clarity

    var selectedTab by remember { mutableStateOf("Completed") } // Default to Completed based on AlertDialog

    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue)
    ) {
        Text(
            text = "My Events",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .padding(top = 79.dp) // Use padding
        )
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 26.dp, top = 71.dp) // Use padding
                .size(size = 31.dp)
                .rotate(degrees = 360f) // <-- FIX: Rotate left
                .clickable { /* TODO: Handle back navigation */ }
        )

        // --- Background Box for Content ---
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 152.dp)
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                // --- Tab Row ---
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 20.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(NormalBlue.copy(alpha = 0.1f))
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TabItem(
                        text = "Upcoming",
                        isSelected = selectedTab == "Upcoming",
                        onClick = { selectedTab = "Upcoming" },
                        modifier = Modifier.weight(1f)
                    )
                    TabItem(
                        text = "Completed",
                        isSelected = selectedTab == "Completed",
                        onClick = { selectedTab = "Completed" },
                        modifier = Modifier.weight(1f)
                    )
                }

                // --- Event List ---
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Takes remaining space below tabs
                ) {
                    if (selectedTab == "Upcoming") {
                        item { Text("No upcoming events yet.", color=TextGray, modifier = Modifier.padding(16.dp)) }
                        // Add upcoming event items here if needed
                    } else { // Completed Events
                        item { EventListItem(isUpcoming = false, distance = "0.5 km", title = "Smart Money Management", location = "Samantha Krida UB", date = "Sat 18, 2025 • 09:00 AM") }
                        item { EventListItem(isUpcoming = false, distance = "0.5 km", title = "Budgeting for Survival", location = "Samantha Krida UB", date = "Sat 18, 2025 • 09:00 AM") }
                        item { EventListItem(isUpcoming = false, distance = "0.5 km", title = "Make Your Money Work", location = "Samantha Krida UB", date = "Sat 18, 2025 • 09:00 AM") }
                        // Add more completed events...
                    }
                } // End LazyColumn
            } // End Column holding Tabs and List
        } // End Background Box
    } // End Root Box
}

// --- Composable for Tab Items (Same as before) ---
@Composable
fun TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) NormalBlue else Color.Transparent
    val textColor = if (isSelected) Color.White else TextGray

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(30.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            maxLines = 1,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


// --- Composable for Event List Items (Slightly modified for Completed state) ---
@Composable
fun EventListItem(
    isUpcoming: Boolean,
    distance: String,
    title: String,
    location: String,
    date: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp), // Space between content and button
        verticalAlignment = Alignment.CenterVertically, // Align items vertically center
        modifier = Modifier
            .fillMaxWidth()
            .shadow( // Apply shadow first
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        // Column for Event Details
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp), // Space within details
            modifier = Modifier
                .weight(1f) // Take available space
        ) {
            // Row for Tags (Upcoming/Completed + Distance)
            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Upcoming/Completed Tag
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        // --- FIX: Conditional Background ---
                        .background(color = if (isUpcoming) UpcomingYellowBg else CompletedGreenBg)
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = if (isUpcoming) "Upcoming" else "Completed",
                        // --- FIX: Conditional Text Color ---
                        color = if (isUpcoming) UpcomingYellow else CompletedGreen,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                // Distance Text
                Text(
                    text = distance,
                    color = Color.Black.copy(alpha = 0.7f),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            // Event Title
            Text(
                text = title,
                color = Color.Black,
                maxLines = 2, // Allow wrapping
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold // Make title bold
                ),
                modifier = Modifier.padding(top = 4.dp) // Add space above title
            )
            // Location Text
            Text(
                text = location,
                color = Color.Black.copy(alpha = 0.7f),
                maxLines = 1,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
            // Date and Time Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp), // Space icon and text
                modifier = Modifier.padding(top = 4.dp) // Add space above date
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar Icon",
                    colorFilter = ColorFilter.tint(TextGray), // Use TextGray tint
                    modifier = Modifier.size(14.dp) // Consistent icon size
                )
                Text(
                    text = date,
                    color = Color.Black.copy(alpha = 0.7f),
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        } // End Column for Event Details

        // "Cek Detail" Button
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(14.dp))
                .background(color = NormalBlue)
                .clickable { /* TODO: Add detail navigation */ }
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Cek Detail",
                color = Color.White,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    } // End Row for Event Item
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact46Preview() { // Renamed Preview function
    AndroidCompact47(Modifier) // Call the correct composable
}
package com.example.finai.event

import androidx.annotation.DrawableRes // Keep if BottomNavItem is used elsewhere
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // <-- Import added
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.lazy.LazyColumn // <-- Import added
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.* // <-- Import added (remember, mutableStateOf)
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
import com.example.finai.R

// Define standard colors (make sure these are suitable)
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)
private val UpcomingYellow = Color(0xffe19b2a)
private val UpcomingYellowBg = Color(0xffffc973).copy(alpha = 0.5f)


@Composable
fun AndroidCompact46(modifier: Modifier = Modifier) {

    // State to track the selected tab
    var selectedTab by remember { mutableStateOf("Upcoming") }

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
                .padding(top = 70.dp) // Use padding
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
                .align(alignment = Alignment.BottomCenter) // Align to bottom
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 152.dp) // Start below blue header area
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp) // Rounded top corners
                )
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp))
        ) {
            Column(modifier = Modifier.fillMaxSize()) { // Column to hold Tabs and List

                // --- Tab Row ---
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 20.dp) // Padding around tabs
                        .height(50.dp) // Height of the tab container
                        .clip(RoundedCornerShape(30.dp)) // Rounded shape for the container
                        .background(NormalBlue.copy(alpha = 0.1f)) // Light background for tab area
                        .padding(5.dp), // Inner padding for the selection background effect
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
                    verticalArrangement = Arrangement.spacedBy(15.dp), // Space between event items
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp), // Padding for the list itself
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f) // Takes remaining space below tabs
                    // Removed offset and fixed width/height
                ) {
                    // Conditionally display items based on selectedTab
                    if (selectedTab == "Upcoming") {
                        item { EventListItem(isUpcoming = true, distance = "0.5 km", title = "Talk Show Investasi Saham", location = "Samantha Krida UB", date = "Sat 18, 2025 • 09:00 AM") }
                        item { EventListItem(isUpcoming = true, distance = "0.5 km", title = "Smart Finance Live", location = "Samantha Krida UB", date = "Sun 19, 2025 • 09:00 AM") }
                        item { EventListItem(isUpcoming = true, distance = "0.5 km", title = "Seminar Pasar Modal", location = "Samantha Krida UB", date = "Mon 20, 2025 • 09:00 AM") }
                        // Add more upcoming events...
                    } else { // Completed Events
                        // Add items for completed events here
                        item { Text("No completed events yet.", color=TextGray, modifier = Modifier.padding(16.dp)) }
                    }
                } // End LazyColumn
            } // End Column holding Tabs and List
        } // End Background Box
    } // End Root Box
}

// --- Composable for Tab Items ---
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
            .clip(RoundedCornerShape(30.dp)) // Fully rounded corners for individual tabs
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp), // Padding inside each tab
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            //lineHeight = 1.em, // Let Compose handle line height
            maxLines = 1,
            style = TextStyle(
                fontSize = 14.sp, // Slightly smaller font for tabs
                fontWeight = FontWeight.Bold
            )
        )
    }
}


// --- Composable for Event List Items ---
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
                        .background(color = if (isUpcoming) UpcomingYellowBg else Color.LightGray) // Conditional bg
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = if (isUpcoming) "Upcoming" else "Completed",
                        color = if (isUpcoming) UpcomingYellow else TextGray, // Conditional text color
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
                    //lineHeight = 1.33.em,
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
                    //lineHeight = 1.33.em,
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
                // .align(Alignment.CenterVertically) // Row already handles this
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
private fun AndroidCompact46Preview() {
    AndroidCompact46(Modifier)
}
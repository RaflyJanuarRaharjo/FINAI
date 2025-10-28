package com.example.finai.event

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.example.finai.R

// Define standard colors (make sure these are suitable)
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)


@Composable
fun AndroidCompact56(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue) // Use defined color
    ) {

        // --- HEADER ---
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(top = 56.dp, start = 30.dp)
        ) {
            Text(
                text = "Hi, Albert",
                color = Color.White,
                textAlign = TextAlign.Start,
                lineHeight = 0.69.em,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold))
            Text(
                text = "Your event experience starts here",
                color = Color.White.copy(alpha = 0.8f), // Slightly lighter
                textAlign = TextAlign.Start,
                lineHeight = 1.38.em,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium))
        }

        // --- KONTEN UTAMA (AREA PUTIH) ---
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter) // Align to bottom
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 152.dp) // Start below header
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp) // Add shape for rounded corners
                )
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)) // Clip content to rounded corners
        ) {
            // Use LazyColumn if content might exceed screen height
            LazyColumn( // Changed Column to LazyColumn
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight() // Fill available height in the Box
                    .padding(bottom = 40.dp) // Padding to avoid overlap with Nav Bar
                    .padding(horizontal = 20.dp, vertical= 20.dp) // Padding for content
            ) {
                item { // Wrap Image in item
                    Image(
                        painter = painterResource(id = R.drawable.bannerevent),
                        contentDescription = "Event Banner", // Changed description
                        modifier = Modifier
                            .fillMaxWidth() // Use fillMaxWidth
                            .requiredHeight(height = 136.dp) // Keep height or use aspectRatio
                            .clip(shape = RoundedCornerShape(20.dp)))
                }
                item { // Wrap header row in item
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween, // Use SpaceBetween
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                        // .padding(horizontal=20.dp) // Apply padding here if needed, or outside LazyColumn
                    ) {
                        Text( // Removed inner Row
                            text = "Nearby Event",
                            color = Color.Black,
                            textAlign = TextAlign.Start, // Align left
                            lineHeight = 1.1.em,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold))

                        Text( // Removed inner Row
                            text = "View all",
                            color = NormalBlue, // Use defined color
                            textAlign = TextAlign.End, // Align right
                            lineHeight = 1.57.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold))
                    }
                }

                // --- DAFTAR EVENT (Items inside LazyColumn) ---
                item { EventItem(R.drawable.event1, "Talk Show Investasi Saham", "Saturday, 18 July 2025") }
                item { EventItem(R.drawable.event2, "Seminar Pasar Modal", "Saturday, 18 July 2025") }
                item { EventItem(R.drawable.event3, "Smart Finance Live", "Saturday, 18 July 2025") }
                item { EventItem(R.drawable.event1, "Talk Show Investasi Saham", "Saturday, 18 July 2025") }
                // Add more items if needed

            } // End LazyColumn
        } // End White Content Box


        // --- PERUBAHAN: Navbar baru dimulai di sini ---
        Row(
            horizontalArrangement = Arrangement.SpaceAround, // Distributes items evenly with space around
            verticalAlignment = Alignment.CenterVertically, // Centers items vertically in the row
            modifier = Modifier
                .align(Alignment.BottomCenter) // Aligns this Row to the bottom of the parent Box
                .fillMaxWidth() // Makes the Row take the full screen width
                .requiredHeight(80.dp) // Sets a fixed height for the nav bar
                .background(Color.White) // Sets the background color to white
                .border(BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))) // Adds a light top border
        ) {
            // Navigation Item 1: Home
            BottomNavItem(
                iconRes = R.drawable.ic_homenonpick, // Icon resource
                label = "Home",                      // Text label
                isSelected = false,                  // Is this item currently selected?
                iconTint = TextGray                  // Color for the icon (unused in current BottomNavItem)
            )
            // Navigation Item 2: Event (Make selected based on current screen)
            BottomNavItem(
                iconRes = R.drawable.ic_eventpick, // Use selected icon
                label = "Event",
                isSelected = true, // Set to true for this screen
                iconTint = NormalBlue
            )

            // Placeholder for the FAB: Takes up space so other items distribute correctly
            Spacer(modifier = Modifier.weight(1f))

            // Navigation Item 4: Forum
            BottomNavItem(
                iconRes = R.drawable.ic_forumnonpick,
                label = "Forum",
                isSelected = false,
                iconTint = TextGray
            )
            // Navigation Item 5: Profile
            BottomNavItem(
                iconRes = R.drawable.ic_profilenonpick, // Use non-selected icon
                label = "Profile",
                isSelected = false,
                iconTint = TextGray
            )
        }

        // --- FAB (Floating Action Button) ---
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-30).dp)
                .size(64.dp)
                .clip(CircleShape)
                .clickable {
                    // --- TODO: Add your click action here! ---
                    println("FAB Clicked!")
                }, // <-- ADD CLICKABLE HERE
            contentAlignment = Alignment.Center
        ) {
            // --- REPLACE Icon WITH Image ---
            Image( // <-- Changed from Icon
                painter = painterResource(id = R.drawable.ic_ai), // Keep painter
                contentDescription = "AI Bot", // Keep contentDescription
                // tint = Color.White, // <-- Remove tint (Image doesn't use it directly)
                // If your ic_ai.png isn't white, uncomment and use ColorFilter:
                // colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(80.dp) // Keep size
            )
        }
        // --- AKHIR Navbar baru ---
    }
}

// --- Composable for individual Event Item (Refactored) ---
@Composable
fun EventItem(
    @DrawableRes imageRes: Int,
    title: String,
    date: String,
    location: String = "Samantha Krida UB" // Default location
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp), // Adjust spacing
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp)) // Add shadow
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .padding(all = 10.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$title image", // Dynamic description
            modifier = Modifier
                .weight(0.45f) // Adjust weight distribution
                .requiredHeight(height = 89.dp) // Keep height or use aspectRatio
                .clip(shape = RoundedCornerShape(10.dp))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp), // Space between text group and button
            modifier = Modifier.weight(0.55f) // Adjust weight distribution
        ) {
            Column( // Group Title, Location, Date
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    maxLines = 2, // Allow title to wrap
                    // lineHeight = 1.2.em,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Row( // Location Row
                    horizontalArrangement = Arrangement.spacedBy(3.5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location Icon",
                        colorFilter = ColorFilter.tint(Color(0xffff2424)),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = location,
                        color = Color.Black.copy(alpha = 0.8f),
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        // lineHeight = 1.2.em,
                        style = TextStyle(
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Row( // Calendar Row
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "Calendar Icon",
                        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f)),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = date,
                        color = Color.Black.copy(alpha = 0.8f),
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        // lineHeight = 1.2.em,
                        style = TextStyle(
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
            Surface( // Register Button using Surface
                shape = RoundedCornerShape(5.dp),
                color = NormalBlue,
                border = BorderStroke(1.dp, Color(0xffc1cce7).copy(alpha = 0.2f)),
                modifier = Modifier
                    .fillMaxWidth() // Button takes full width of its column
                    .clip(shape = RoundedCornerShape(5.dp))
                    .clickable { /* TODO: Register Action */ },
                shadowElevation = 2.dp
            ) {
                Text(
                    text = "Register",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 6.dp) // Padding inside button
                )
            }
        }
    }
}


// --- BottomNavItem composable (Required by the new Navbar) ---
@Composable
fun RowScope.BottomNavItem(
    @DrawableRes iconRes: Int,
    label: String,
    isSelected: Boolean,
    iconTint: Color // Parameter iconTint ini sekarang tidak digunakan langsung di sini
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .weight(1f) // Use weight within RowScope
            .clickable { /* TODO: Handle Navigation Click */ } // Make item clickable
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = if (isSelected) NormalBlue else TextGray, // Tint changes based on selection
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = if (isSelected) NormalBlue else TextGray, // Color changes based on selection
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact56Preview() {
    AndroidCompact56(Modifier)
}
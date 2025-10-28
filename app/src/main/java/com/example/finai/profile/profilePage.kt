package com.example.finai.profile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

// Define standard colors to replace AppColors
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)

// Removed the separate ProfileHeader function

@Composable
fun AndroidCompact43(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue) // Use defined color
    ) {
        // --- PERUBAHAN: Header dimasukkan langsung ---
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart) // Align to top start of the Box
                .padding(top = 70.dp, start = 30.dp) // Use padding for positioning
        ) {
            Text(
                text = "Hi, Albert ", // Original text had a space
                color = Color.White,
                textAlign = TextAlign.Start, // Changed from Center
                lineHeight = 0.69.em,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Manage your personal information here", // Original text
                color = Color.White.copy(alpha = 0.8f), // Made slightly lighter
                textAlign = TextAlign.Start, // Changed from Center
                lineHeight = 1.38.em,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        // --- AKHIR PERUBAHAN HEADER ---

        // --- Background Box ---
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter) // Align to bottom
                .fillMaxWidth()
                .fillMaxHeight() // Fill available height
                .padding(top = 152.dp) // Distance from top WHERE WHITE BOX STARTS
                .background(
                    color = LightGray, // Use defined color
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp) // Updated shape
                )
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)) // Clip content
        )

        // --- Content Column ---
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally, // Center items like "Account Setting"
            modifier = Modifier
                .align(alignment = Alignment.TopCenter) // Align content column to top center
                .padding(top = 180.dp, bottom = 93.dp) // Padding top (below header) & bottom (above nav) - ADJUST TOP PADDING
                .fillMaxHeight() // Allow column to take available space
                .padding(horizontal = 20.dp) // Horizontal padding for content
        ) {
            // --- Profile Header Row (Image + Info) ---
            Row(
                horizontalArrangement = Arrangement.Center, // Center items in the Row
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth() // Row takes full width to allow centering
                    .padding(vertical = 20.dp) // Padding around header content
            ) {
                // --- Profile Image ---
                Image(
                    painter = painterResource(id = R.drawable.fotoprofile), // Ensure this drawable exists
                    contentDescription = "User Profile Picture",
                    contentScale = ContentScale.Crop, // Crop image to fit circle
                    modifier = Modifier
                        .size(81.dp) // Use size for consistency
                        .shadow(elevation = 4.dp, shape = CircleShape) // Apply shadow before clip/border
                        .clip(CircleShape) // Clip before border
                        .border(
                            border = BorderStroke(3.dp, DarkBlue), // Thinner border?
                            shape = CircleShape
                        )
                )

                // --- Profile Info Column ---
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp), // Adjust spacing
                    modifier = Modifier
                        .padding(start = 15.dp) // Add padding for spacing
                ) {
                    Text( // Name
                        text = "Albert Jayendra",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text( // Subtitle
                        text = "Computer Science UB",
                        color = Color.Black.copy(alpha = 0.7f), // Lighter text
                        style = TextStyle(fontSize = 12.sp)
                    )
                    // --- Edit Profile Button Row ---
                    Row(
                        horizontalArrangement = Arrangement.Center, // Center text inside button
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            // Removed .align(Alignment.CenterHorizontally) to keep it left aligned
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = NormalBlue)
                            .padding(horizontal = 12.dp, vertical = 4.dp) // Adjust padding
                    ) {
                        Text(
                            text = "Edit Profile",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 16.sp, // Font size already updated
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }

            // --- Account Setting Title ---
            Text(
                text = "Account Setting",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth() // Align text to start (left)
                    .padding(vertical = 10.dp)
            )

            // --- Settings Items ---
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp), // Spacing between setting rows
                modifier = Modifier.fillMaxWidth()
            ) {
                SettingsRow(
                    iconRes = R.drawable.ic_performance, // Ensure this exists
                    iconDesc = "Performance Icon",
                    text = "Performance",
                    iconTint = NormalBlue
                )
                SettingsRow(
                    iconRes = R.drawable.ticketprof, // Ensure this exists
                    iconDesc = "My Event Icon",
                    text = "My event",
                    iconTint = NormalBlue
                )
                SettingsRow(
                    iconRes = R.drawable.locprofil, // Ensure this exists
                    iconDesc = "Set Location Icon",
                    text = "Set Location",
                    iconTint = NormalBlue
                )
                SettingsRow(
                    iconRes = R.drawable.langprofil, // Ensure this exists
                    iconDesc = "Language Icon",
                    text = "Language",
                    iconTint = NormalBlue
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Push logout button down

            // --- Logout Button ---
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 20.dp) // Padding around button
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = NormalBlue)
                    .padding(vertical = 12.dp)

            ) {
                Text(
                    text = "Logout",
                    color = LightGray,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        // --- Bottom Navigation ---
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .requiredHeight(80.dp)
                .background(Color.White)
                .border(BorderStroke(1.dp, Color.LightGray.copy(alpha=0.5f)))
        ) {
            BottomNavItem(R.drawable.ic_homenonpick, "Home", isSelected = false, iconTint = TextGray)
            BottomNavItem(R.drawable.ic_eventnonpick, "Event", isSelected = false, iconTint = TextGray)

            Spacer(modifier = Modifier.weight(1f)) // FAB Placeholder

            BottomNavItem(R.drawable.ic_forumnonpick, "Forum", isSelected = false, iconTint = TextGray)
            BottomNavItem(R.drawable.ic_profilepick, "Profile", isSelected = true, iconTint = NormalBlue) // Profile is selected
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
    }
}

// --- SettingsRow composable ---
@Composable
fun SettingsRow(
    @DrawableRes iconRes: Int,
    iconDesc: String,
    text: String,
    iconTint: Color = DarkBlue
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color.White) // White background for rows
            .border(
                border = BorderStroke(1.dp, NormalBlue.copy(alpha=0.3f)), // Lighter border
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 15.dp, vertical = 12.dp)
    ) {
        Row( // Group Icon and Text
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = iconDesc,
                tint = iconTint,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = text,
                color = iconTint,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.arrowprofil), // Ensure this exists
            contentDescription = "Arrow Right",
            tint = NormalBlue.copy(alpha = 0.6f),
            modifier = Modifier
                .size(30.dp)
                .rotate(degrees = 360f) // Keep rotation pointing right
        )
    }
}


// --- BottomNavItem composable ---
@Composable
fun RowScope.BottomNavItem( // Added RowScope receiver
    @DrawableRes iconRes: Int,
    label: String,
    isSelected: Boolean,
    iconTint: Color // Parameter iconTint ini sekarang tidak digunakan
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .weight(1f) // Use weight within RowScope
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = if (isSelected) NormalBlue else TextGray, // Tint diatur di sini
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = if (isSelected) NormalBlue else TextGray, // Warna teks diatur di sini
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact43Preview() {
    AndroidCompact43(Modifier)
}
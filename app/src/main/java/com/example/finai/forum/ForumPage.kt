package com.example.finai.forum // Assuming package based on context

import androidx.annotation.DrawableRes // Added for BottomNavItem
import androidx.compose.foundation.BorderStroke // Added BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border // Added border
import androidx.compose.foundation.clickable // Added clickable
import androidx.compose.foundation.layout.* // Import all layout components
import androidx.compose.foundation.shape.CircleShape // Added CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults // Not used
import androidx.compose.material3.Icon // Added Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate // Keep if needed
import androidx.compose.ui.draw.shadow // Added shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight // Added FontWeight
import androidx.compose.ui.text.style.TextAlign // Keep if needed elsewhere
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R // Ensure R is imported

// Define standard colors
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)

/*
// --- REMOVED: Old ForumWelcomeBanner Composable ---
// This composable has been removed as the banner is now directly an Image.
@Composable
fun ForumWelcomeBanner(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center, // Center the text
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth() // Take full width
            .clip(shape = RoundedCornerShape(20.dp))
            .background(DarkBlue.copy(alpha=0.8f)) // Added a background
            .padding(horizontal = 20.dp, // Adjusted padding
                vertical = 20.dp)
    ) {
        Text(
            text = "WELCOME TO FORUM\nFinAI",
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 1.25.em,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
// --- END REMOVED ---
*/

@Composable
fun AndroidCompact31(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue) // Use defined color
    ) {
        // --- Header Column ---
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(top = 56.dp, start = 30.dp, end = 30.dp) // Added end padding
                .fillMaxWidth() // Allow column to take width
        ) {
            Text(
                text = "Hi, Albert ", // Keep space or remove based on design
                color = Color.White,
                textAlign = TextAlign.Start, // Align left
                lineHeight = 0.69.em,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold))
            Text(
                text = "Your space to ask, share, and learn",
                color = Color.White.copy(alpha = 0.8f), // Slightly lighter
                textAlign = TextAlign.Start, // Align left
                lineHeight = 1.38.em,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium))
        }

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
            // --- Content Column ---
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp), // Space between items
                modifier = Modifier
                    .fillMaxSize() // Fill the light gray box
                    .padding(bottom = 80.dp) // Padding to avoid overlap with Nav Bar
                    .padding(horizontal = 20.dp, vertical = 30.dp) // Padding for content
            ) {

                // --- PERUBAHAN: Welcome Banner sekarang adalah Image ---

                Image(
                    painter = painterResource(id = R.drawable.bannerforum),
                    contentDescription = "Welcome to FinAI Forum Banner",
                    contentScale = ContentScale.Crop, // <-- Tambahkan ini agar gambar mengisi ruang
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp) // <-- TAMBAHKAN TINGGI YANG DIINGINKAN (misal: 160.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                // --- AKHIR PERUBAHAN ---

                // --- Welcome Message Row ---
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.Top, // Align items to the top
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // --- Avatar Image ---
                    Image(
                        painter = painterResource(id = R.drawable.robot_forum), // Ensure exists
                        contentDescription = "Forum Avatar", // Better description
                        modifier = Modifier
                            .size(size = 60.dp) // Use size
                            .clip(shape = CircleShape) // Make it circular
                            .padding(all = 2.dp) // Optional inner padding
                    )
                    // --- Message Bubble ---
                    Box( // Use Box for background and shadow
                        modifier = Modifier
                            .weight(1f) // Take remaining space
                            .shadow(elevation = 2.dp, // Apply shadow
                                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp))
                            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp))
                            .background(color = Color.White)
                            .padding(all = 12.dp) // Padding inside the bubble
                    ) {
                        Text(
                            text = "✨ Welcome to the Forum!\n📣 You're now part of the FinAI community.\nTempat terbaik untuk bertukar pikiran, berbagi tips, dan bertanya seputar keuangan pribadi — dari budgeting, menabung, sampai investasi cerdas.\n\n💬 Post a question, share your insight, or just explore.  Di sini, setiap obrolan bisa membantumu jadi lebih #FinSmart bersama FinAI.\n\n🔹 Why FinAI Forum?\n✅ Dapatkan jawaban dari sesama pengguna & pakar\n✅ Pelajari strategi finansial baru tiap hari\n✅ Diskusi terbuka, bebas judgment\n✅ Terhubung langsung dengan AI Smart Assistant FinAI",
                            color = Color.Black.copy(alpha = 0.9f), // Slightly darker text
                            lineHeight = 1.5.em,
                            style = TextStyle(fontSize = 11.sp), // Slightly larger font
                        )
                    }
                }
                // --- TODO: Add List of Forum Posts Here ---

            } // End Content Column
        } // End Background Box


        // --- Navbar baru dimulai di sini ---
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .requiredHeight(80.dp)
                .background(Color.White)
                .border(BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)))
        ) {
            BottomNavItem(R.drawable.ic_homenonpick, "Home", isSelected = false, iconTint = TextGray)
            BottomNavItem(R.drawable.ic_eventnonpick, "Event", isSelected = false, iconTint = TextGray)
            Spacer(modifier = Modifier.weight(1f))
            BottomNavItem(R.drawable.ic_forumpick, "Forum", isSelected = true, iconTint = NormalBlue) // Forum is selected
            BottomNavItem(R.drawable.ic_profilenonpick, "Profile", isSelected = false, iconTint = TextGray)
        }

        // --- FAB (Floating Action Button) ---
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

        // --- FAB (Add Post) as Clickable Image ---
        Image(
            painter = painterResource(id = R.drawable.ic_plus), // Ensure this drawable exists
            contentDescription = "Add Post",
            modifier = Modifier
                .align(Alignment.BottomEnd) // Align to bottom right
                .padding(end = 20.dp, bottom = 100.dp) // Padding from edges (above navbar)
                .size(size = 56.dp) // Set the size of the clickable area and image
                .clickable {
                    println("Add Post FAB Clicked!")
                }
        )
        // --- AKHIR FAB (Add Post) ---

    } // End Root Box
}


// --- BottomNavItem Composable ---
@Composable
fun RowScope.BottomNavItem(
    @DrawableRes iconRes: Int,
    label: String,
    isSelected: Boolean,
    iconTint: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .weight(1f)
            .clickable { /* TODO: Handle Navigation Click */ }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = if (isSelected) NormalBlue else TextGray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = if (isSelected) NormalBlue else TextGray,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact31Preview() {
    AndroidCompact31(Modifier)
}
package com.example.finai.profile // Assuming package based on context

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable // Added clickable
import androidx.compose.foundation.layout.* // Import all layout components
import androidx.compose.foundation.lazy.LazyColumn // Added LazyColumn import
import androidx.compose.foundation.shape.CircleShape // Added CircleShape import
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset // Added Offset import
import androidx.compose.ui.graphics.Brush // Added Brush import
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign // Keep if needed elsewhere
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

// Define standard colors
private val DarkBlue = Color(0xff192851)
private val NormalBlue = Color(0xff3759b3)
private val LightGray = Color(0xfff6f6f6)
private val TextGray = Color(0xff484c52)
private val ProgressBarGray = Color(0xff757575).copy(alpha = 0.3f) // Color for progress bar background
private val TrophyYellow = Color(0xffeab308)
private val TrophyYellowBg = Color(0xffffef52).copy(alpha = 0.5f)
private val MedalBlueBg = Color(0xffccd5f2) // Example color for Blue Light Hover
private val StarGreen = Color(0xff578453)
private val StarGreenBg = Color(0xffc6ebc3)


@Composable
fun AndroidCompact45(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = NormalBlue) // Use defined color
    ) {
        // --- Header Text ---
        Text(
            text = "Performance",
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

        // --- Background Box ---
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
        )

        // --- Scrollable Content ---
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp), // Space between items
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(top = 187.dp, bottom = 20.dp, start = 20.dp, end = 20.dp), // Padding around the list content
            modifier = Modifier
                .fillMaxSize() // Fill the parent Box
            // Removed offset and fixed width/height
        ) {
            // --- Overall Progress Section ---
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(), // Takes full width within padding
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Space within this section
                ) {
                    Text( // Title
                        text = "Overall Progress",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.Start) // Align title left
                    )
                    Row( // Course Completion Text Row
                        horizontalArrangement = Arrangement.SpaceBetween, // Pushes items apart
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Course Completion",
                            color = Color.Black.copy(alpha=0.8f), // Slightly lighter
                            // lineHeight = 1.14.em,
                            style = TextStyle(fontSize = 14.sp)
                        )
                        Text(
                            text = "75%",
                            color = NormalBlue, // Use defined color
                            // lineHeight = 1.14.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    // --- Progress Bar ---
                    Box( // Container for the progress bar background
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(11.dp) // Height of the progress bar
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = ProgressBarGray) // Background color
                    ) {
                        Box( // The actual progress indicator
                            modifier = Modifier
                                .fillMaxHeight() // Fill height of the container
                                .fillMaxWidth(fraction = 0.75f) // Fill 75% of the width
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(color = NormalBlue) // Progress color
                        )
                        // Removed the extra circle Box at the end
                    }
                } // End Overall Progress Column
            } // End item

            // --- Stats Row ---
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround, // Distribute evenly
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp) // Padding above/below stats
                ) {
                    StatItem(value = "3", label = "Lesson Progress")
                    StatItem(value = "1", label = "Remaining")
                    StatItem(value = "24 h", label = "Study Time")
                }
            } // End item

            // --- Grafik ---
            item {
                Image(
                    painter = painterResource(id = R.drawable.grafik), // Ensure this exists
                    contentDescription = "Study Progress Chart",
                    contentScale = ContentScale.FillWidth, // Scale to fit width
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 177.dp) // Keep height or use aspectRatio
                        .clip(RoundedCornerShape(15.dp)) // Add corners?
                )
            } // End item

            // --- Achievements Section ---
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Achievements",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .align(Alignment.Start) // Align title left
                            .padding(bottom = 5.dp) // Space below title
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween, // Space out achievements
                        verticalAlignment = Alignment.Top, // Align tops if heights differ slightly
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AchievementItem(
                            iconRes = R.drawable.ic_trophy,
                            label = "Fast Learner",
                            iconTint = TrophyYellow,
                            bgColor = TrophyYellowBg,
                            borderColor = TrophyYellow,
                            modifier = Modifier.weight(1f) // Distribute space
                        )
                        Spacer(Modifier.width(10.dp)) // Space between items
                        AchievementItem(
                            iconRes = R.drawable.ic_medal,
                            label = "Consistent",
                            iconTint = NormalBlue,
                            bgColor = MedalBlueBg, // Use defined color
                            borderColor = NormalBlue,
                            modifier = Modifier.weight(1f) // Distribute space
                        )
                        Spacer(Modifier.width(10.dp)) // Space between items
                        AchievementItem(
                            iconRes = R.drawable.ic_star,
                            label = "Top Scorer",
                            iconTint = StarGreen,
                            bgColor = StarGreenBg,
                            borderColor = StarGreen,
                            modifier = Modifier.weight(1f) // Distribute space
                        )
                    }
                }
            } // End item

            // --- Study Streak Section ---
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Study Streak",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .align(Alignment.Start) // Align title left
                            .padding(bottom = 5.dp) // Space below title
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(elevation = 2.dp, shape = RoundedCornerShape(20.dp)) // Add shadow
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(brush = Brush.linearGradient( // Gradient background
                                0f to Color(0xff3783b3),
                                1f to Color(0xff39184d),
                                start = Offset(Float.POSITIVE_INFINITY, 0f), // Adjust gradient angle if needed
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            ))
                            .padding(horizontal = 20.dp, vertical = 20.dp) // Padding inside
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_fire), // Ensure exists
                            contentDescription = "Streak Fire Icon",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier.size(size = 46.dp)
                        )
                        Text(
                            text = "3",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp, // Larger number
                                fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(
                            text = "Days in a row",
                            color = Color.White.copy(alpha = 0.9f), // Slightly transparent
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp, // Larger text
                                fontWeight = FontWeight.Medium), // Medium weight
                        )
                        Spacer(Modifier.height(4.dp)) // Add space
                        Text(
                            text = "Keep it up! You’re doing great!",
                            color = Color.White.copy(alpha = 0.9f),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal), // Normal weight
                        )
                    }
                }
            } // End item
        } // End LazyColumn
    } // End Root Box
}

// --- Composable for Stats Items ---
@Composable
fun StatItem(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp), // Space between value and label
        modifier = Modifier.padding(horizontal = 5.dp) // Padding around each stat item
    ) {
        Text(
            text = value,
            color = Color.Black,
            // lineHeight = 0.85.em,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        )
        Text(
            text = label,
            color = TextGray, // Use TextGray
            textAlign = TextAlign.Center, // Ensure label is centered
            style = TextStyle(fontSize = 12.sp)
        )
    }
}

// --- Composable for Achievement Items ---
@Composable
fun AchievementItem(
    @DrawableRes iconRes: Int,
    label: String,
    iconTint: Color,
    bgColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp), // Space icon and text
        modifier = modifier
            // .requiredWidth(width = 98.dp) // Let weight control width
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = bgColor)
            .border(border = BorderStroke(1.dp, borderColor),
                shape = RoundedCornerShape(15.dp))
            .padding(vertical = 10.dp, horizontal = 5.dp) // Adjust padding
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label, // Use label as description
            colorFilter = if(iconRes != R.drawable.ic_star) ColorFilter.tint(iconTint) else null, // Don't tint the star
            modifier = Modifier.size(size = 36.dp)
        )
        Text(
            text = label,
            color = iconTint, // Match text color to icon tint
            textAlign = TextAlign.Center, // Center text
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold)
        )
    }
}


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact45Preview() {
    AndroidCompact45(Modifier)
}
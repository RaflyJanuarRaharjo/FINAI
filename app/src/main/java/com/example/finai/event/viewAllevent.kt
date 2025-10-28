package com.example.finai.event

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset // Keep if offset is intended over padding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults // Not used
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R // Ensure R is imported correctly

@Composable
fun AndroidCompact30(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color(0xff3759b3))
    ) {
        Text(
            text = "Nearby event",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .padding(top = 79.dp) // Use padding instead of offset if possible
            // .offset(x = 0.dp, y = 79.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "Back Arrow", // Better description
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 26.dp, top = 71.dp) // Use padding instead of offset if possible
                // .offset(x = 26.dp, y = 71.dp)
                .requiredSize(size = 31.dp)
                .rotate(degrees = 360f) // <-- PERBAIKAN: Rotate left
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter) // Align to bottom
                .fillMaxWidth()
                .fillMaxHeight() // Fill available height
                .padding(top = 152.dp) // Distance from top
                .background(
                    color = Color(0xfff6f6f6),
                    // Optional: Add top corners if needed
                    // shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            // .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) // If using shape
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp), // Adjust spacing between items
                modifier = Modifier
                    .fillMaxSize() // Fill the parent Box
                    .padding(horizontal = 20.dp) // Horizontal padding for the list
                    .padding(top = 20.dp, bottom = 20.dp) // Padding inside the list
            ) {
                // --- EVENT ITEM 1 ---
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow( // Apply shadow before clip/background
                                elevation = 4.dp,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .padding(all = 10.dp)
                    ) {
                        Column( // Column for Image
                            // verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top), // Not needed for single image
                            modifier = Modifier
                                .weight(0.4f) // Give image slightly less weight
                            //.requiredWidth(width = 157.dp) // Use weight instead
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.event1),
                                contentDescription = "Event 1 Image", // Specific description
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 89.dp) // Keep height or use aspectRatio
                                    .clip(shape = RoundedCornerShape(10.dp)))
                        }
                        Column( // Column for Text Content
                            verticalArrangement = Arrangement.spacedBy(8.dp), // Adjust spacing
                            horizontalAlignment = Alignment.Start, // Align text left
                            modifier = Modifier
                                .weight(0.6f) // Give text more weight
                            //.requiredWidth(width = 152.dp) // Use weight instead
                            //.requiredHeight(height = 70.dp) // Let height wrap content
                        ) {
                            Column( // Group Title, Location, Date
                                verticalArrangement = Arrangement.spacedBy(4.dp), // Space within group
                                //modifier = Modifier.requiredHeight(height = 38.dp) // Let height wrap
                            ) {
                                Text(
                                    text = "Talk Show Investasi Saham",
                                    color = Color.Black,
                                    textAlign = TextAlign.Start, // Align text left
                                    lineHeight = 1.2.em, // Adjust line height
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold))
                                Row( // Location Row
                                    horizontalArrangement = Arrangement.spacedBy(3.5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_location), // Check name exists
                                        contentDescription = "Location Icon",
                                        colorFilter = ColorFilter.tint(Color(0xffff2424)),
                                        modifier = Modifier.size(14.dp)) // Use size
                                    Text( // Removed inner Row
                                        text = "Samantha Krida UB",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start, // Align text left
                                        lineHeight = 1.2.em, // Adjust line height
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium) // Medium weight might look better
                                    )
                                }
                                Row( // Calendar Row
                                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                    // modifier = Modifier.requiredWidth(width = 113.dp).requiredHeight(height = 14.dp).padding(horizontal = 2.dp) // Let it wrap
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_calendar), // Check name exists
                                        contentDescription = "Calendar Icon",
                                        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f)),
                                        modifier = Modifier.size(14.dp)) // Use size, consistent with location
                                    Text( // Removed inner Row
                                        text = "Saturday, 18 July 2025",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start, // Align text left
                                        lineHeight = 1.2.em, // Adjust line height
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium) // Medium weight
                                    )
                                }
                            }
                            // --- Register Button ---
                            Row( // Button Row (might replace with Button composable later)
                                horizontalArrangement = Arrangement.Center, // Center text inside
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth() // Fill available width in the column
                                    .padding(top = 4.dp) // Add some space above button
                                    .shadow( // Shadow before clip/background
                                        elevation = 2.dp, // Lighter shadow for button
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3759b3)) // PERBAIKAN: AppColors diganti
                                    .border(border = BorderStroke(1.dp, Color(0xffc1cce7).copy(alpha = 0.2f)),
                                        shape = RoundedCornerShape(5.dp))
                                    .padding(vertical = 6.dp) // Vertical padding inside button
                            ) {
                                Text(
                                    text = "Register",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    //lineHeight = 2.44.em, // Let Compose handle line height
                                    style = TextStyle(
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
                // --- EVENT ITEM 2 ---
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow( // Apply shadow before clip/background
                                elevation = 4.dp,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .padding(all = 10.dp)

                    ) {
                        Column(
                            modifier = Modifier
                                .weight(0.4f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.event2),
                                contentDescription = "Event 2 Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 89.dp)
                                    .clip(shape = RoundedCornerShape(10.dp)))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.weight(0.6f)
                        ) {
                            Column( // Group Title, Location, Date
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                                Text(
                                    text = "Smart Finance Live",
                                    color = Color.Black,
                                    textAlign = TextAlign.Start,
                                    lineHeight = 1.2.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold))
                                Row( // Location Row
                                    horizontalArrangement = Arrangement.spacedBy(3.5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_location),
                                        contentDescription = "Location Icon",
                                        colorFilter = ColorFilter.tint(Color(0xffff2424)),
                                        modifier = Modifier.size(14.dp))
                                    Text(
                                        text = "Samantha Krida UB",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                                Row( // Calendar Row
                                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = "Calendar Icon",
                                        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f)),
                                        modifier = Modifier.size(14.dp))
                                    Text(
                                        text = "Sunday, 19 July 2025",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                            }
                            Row( // Button Row
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                                    .shadow(
                                        elevation = 2.dp,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3759b3)) // PERBAIKAN: AppColors diganti
                                    .border(border = BorderStroke(1.dp, Color(0xffc1cce7).copy(alpha = 0.2f)),
                                        shape = RoundedCornerShape(5.dp))
                                    .padding( vertical = 6.dp)

                            ) {
                                Text(
                                    text = "Register",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
                // --- EVENT ITEM 3 ---
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow( // Apply shadow before clip/background
                                elevation = 4.dp,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .padding(all = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(0.4f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.event3),
                                contentDescription = "Event 3 Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 89.dp)
                                    .clip(shape = RoundedCornerShape(10.dp)))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.weight(0.6f)
                        ) {
                            Column( // Group Title, Location, Date
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                                Text(
                                    text = "Seminar Pasar Modal",
                                    color = Color.Black,
                                    textAlign = TextAlign.Start,
                                    lineHeight = 1.2.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold))
                                Row( // Location Row
                                    horizontalArrangement = Arrangement.spacedBy(3.5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_location),
                                        contentDescription = "Location Icon",
                                        colorFilter = ColorFilter.tint(Color(0xffff2424)),
                                        modifier = Modifier.size(14.dp))
                                    Text(
                                        text = "Samantha Krida UB",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                                Row( // Calendar Row
                                    horizontalArrangement = Arrangement.spacedBy(4.5.dp, Alignment.Start), // Original spacing
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = "Calendar Icon",
                                        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f)),
                                        modifier = Modifier.size(14.dp)) // Use size
                                    Text(
                                        text = "Monday, 20 July 2025",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                            }
                            Row( // Button Row
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                                    .shadow(
                                        elevation = 2.dp,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3759b3)) // PERBAIKAN: AppColors diganti
                                    .border(border = BorderStroke(1.dp, Color(0xffc1cce7).copy(alpha = 0.2f)),
                                        shape = RoundedCornerShape(5.dp))
                                    .padding(vertical = 6.dp)
                            ) {
                                Text(
                                    text = "Register",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
                // --- EVENT ITEM 4 --- (Copy of Item 1 for example)
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow( // Apply shadow before clip/background
                                elevation = 4.dp,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .padding(all = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(0.4f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.event1),
                                contentDescription = "Event 1 Image Repeat",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 89.dp)
                                    .clip(shape = RoundedCornerShape(10.dp)))
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.weight(0.6f)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                                Text(
                                    text = "Talk Show Investasi Saham",
                                    color = Color.Black,
                                    textAlign = TextAlign.Start,
                                    lineHeight = 1.2.em,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold))
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(3.5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_location),
                                        contentDescription = "Location Icon",
                                        colorFilter = ColorFilter.tint(Color(0xffff2424)),
                                        modifier = Modifier.size(14.dp))
                                    Text(
                                        text = "Samantha Krida UB",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = "Calendar Icon",
                                        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.8f)),
                                        modifier = Modifier.size(14.dp))
                                    Text(
                                        text = "Saturday, 18 July 2025",
                                        color = Color.Black.copy(alpha = 0.8f),
                                        textAlign = TextAlign.Start,
                                        lineHeight = 1.2.em,
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Medium)
                                    )
                                }
                            }
                            Row( // Button Row
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                                    .shadow(
                                        elevation = 2.dp,
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3759b3)) // PERBAIKAN: AppColors diganti
                                    .border(border = BorderStroke(1.dp, Color(0xffc1cce7).copy(alpha = 0.2f)),
                                        shape = RoundedCornerShape(5.dp))
                                    .padding(vertical = 6.dp)
                            ) {
                                Text(
                                    text = "Register",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
                // --- Add more items as needed ---
                // item { /* Event Item 5 */ }
                // item { /* Event Item 6 */ }

            } // End LazyColumn
        } // End Content Box
    } // End Root Box
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact30Preview() {
    AndroidCompact30(Modifier)
}
package com.example.finai.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun AndroidCompact51(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.Black.copy(alpha = 0.49f))
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(x = 0.5.dp,
                    y = (-48).dp)
                .requiredWidth(width = 339.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.White)
                .padding(all = 30.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Logout Confirmation",
                    color = Color.Black,
                    lineHeight = 1.25.em,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold))
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Are you sure want to do logout?",
                    color = Color(0xff9d9d9d),
                    lineHeight = 1.88.em,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium))
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xff3759b3)),
                            shape = RoundedCornerShape(15.dp))
                        .padding(horizontal = 15.dp,
                            vertical = 10.dp)
                ) {
                    Text(
                        text = "Cancel",
                        color = Color(0xff3759b3),
                        lineHeight = 1.5.em,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold))
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color(0xff3759b3))
                        .padding(horizontal = 15.dp,
                            vertical = 10.dp)
                ) {
                    Text(
                        text = "Confirm",
                        color = Color.White,
                        lineHeight = 1.5.em,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold))
                }
            }
        }
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact51Preview() {
    AndroidCompact51(Modifier)
}
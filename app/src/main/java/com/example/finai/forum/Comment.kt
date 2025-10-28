package com.example.finai.forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R

@Composable
fun AndroidCompact35(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color(0xff3759b3))
    ) {
        Text(
            text = "Forum",
            color = Color.White,
            lineHeight = 0.67.em,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.dp,
                    y = 79.dp))
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "iconamoon:arrow-up-2-bold",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 26.dp,
                    y = 71.dp)
                .requiredSize(size = 31.dp)
                .rotate(degrees = 360f))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 152.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 765.dp)
                .background(color = Color(0xfff6f6f6)))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.dp,
                    y = 180.dp)
                .padding(all = 10.dp)
        ) {
            Text(
                text = "Comments",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold))
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(x = 0.dp,
                    y = 250.dp)
                .requiredWidth(width = 316.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredSize(size = 40.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(color = Color.White)
                    .padding(all = 5.dp)
                    .shadow(elevation = 4.dp,
                        shape = RoundedCornerShape(30.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ftprof),
                    contentDescription = "image 24",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(20.dp)))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                modifier = Modifier
                    .requiredWidth(width = 248.dp)
                    .requiredHeight(height = 35.dp)
            ) {
                Text(
                    text = "ChristKay",
                    color = Color.Black,
                    lineHeight = 1.em,
                    style = TextStyle(
                        fontSize = 15.sp),
                    modifier = Modifier
                        .fillMaxWidth())
                Text(
                    text = "Semangatt Alberttt",
                    color = Color.Black.copy(alpha = 0.7f),
                    lineHeight = 1.25.em,
                    style = TextStyle(
                        fontSize = 12.sp),
                    modifier = Modifier
                        .fillMaxWidth())
            }
        }
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AndroidCompact35Preview() {
    AndroidCompact35(Modifier)
}
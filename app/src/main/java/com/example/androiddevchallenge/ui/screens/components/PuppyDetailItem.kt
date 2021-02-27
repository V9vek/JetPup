package com.example.androiddevchallenge.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PuppyDetailItem(
    title: String,
    subtitle: String,
    color: Color
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .requiredSize(88.dp)
            .background(color = color)
    ) {
        Column(
            modifier = Modifier.padding(8.dp).align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold)
            Text(text = title, style = style)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = subtitle, style = style)
        }
    }
}
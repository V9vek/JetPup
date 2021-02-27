package com.example.androiddevchallenge.ui.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.blue

@Composable
fun HomeTopBar() {
    TopAppBar {
        Row(
            modifier = Modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Pets,
                    contentDescription = "Paw Icon",
                    tint = blue
                )
            }
            Text(
                text = "JetPup",
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun DetailsTopBar(
    onNavigateBack: () -> Unit
) {
    TopAppBar(
        elevation = 0.dp
    ) {
        IconButton(onClick = onNavigateBack) {
            Icon(
                imageVector = Icons.Default.ChevronLeft,
                contentDescription = "Back Icon",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.model.getPuppyList
import com.example.androiddevchallenge.ui.screens.components.HomeTopBar
import com.example.androiddevchallenge.ui.screens.components.PuppyListItem

@Composable
fun HomeScreen(
    onPupClick: (Int) -> Unit
) {
    val puppyList = getPuppyList()

    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) {
        LazyColumn {
            items(puppyList) { puppy ->
                PuppyListItem(puppy = puppy, onPupClick = onPupClick)
            }
        }
    }
}


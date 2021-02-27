/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.getPuppyFromId
import com.example.androiddevchallenge.ui.screens.components.DetailsTopBar
import com.example.androiddevchallenge.ui.screens.components.PuppyDetailItem
import com.example.androiddevchallenge.ui.theme.blue
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.orange
import com.example.androiddevchallenge.ui.theme.pink
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun DetailsScreen(
    pupId: Int,
    onNavigateBack: () -> Unit
) {
    val puppy = getPuppyFromId(id = pupId)

    Scaffold(
        topBar = { DetailsTopBar(onNavigateBack = onNavigateBack) }
    ) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(id = puppy.photo),
                    contentDescription = "Puppy Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1.2f).fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(8.dp))
            }

            item { PuppyName(puppy.name, puppy.type) }

            item { PuppyDetailsRow(puppy.sex, puppy.age, puppy.weight, puppy.color) }

            item { PuppyDescription(puppy.name, puppy.description) }
        }
    }
}

@Composable
fun PuppyName(name: String, type: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column {
            Text(text = name, style = MaterialTheme.typography.h6)
            Text(text = type, style = MaterialTheme.typography.subtitle1)
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = pink)
                .clickable { /*ADOPT*/ }
        ) {
            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
                Icon(
                    imageVector = Icons.Default.Pets,
                    contentDescription = "Paw Icon",
                    tint = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Adopt",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }
}

@Composable
fun PuppyDetailsRow(sex: String, age: Int, weight: Int, color: String) {
    LazyRow {
        item { PuppyDetailItem(title = "SEX", subtitle = sex, color = blue.copy(0.3f)) }
        item { PuppyDetailItem(title = "AGE", subtitle = "$age years", color = orange.copy(0.3f)) }
        item {
            PuppyDetailItem(
                title = "WEIGHT",
                subtitle = "$weight kg",
                color = green.copy(0.3f)
            )
        }
        item {
            PuppyDetailItem(title = "COLOR", subtitle = color, color = red.copy(0.3f))
        }
    }
}

@Composable
fun PuppyDescription(name: String, description: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "More about $name", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = description)
    }
}

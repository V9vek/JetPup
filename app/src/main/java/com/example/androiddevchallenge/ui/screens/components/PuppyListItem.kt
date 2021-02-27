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
package com.example.androiddevchallenge.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red
import com.example.androiddevchallenge.ui.util.getBackgroundColor
import com.example.androiddevchallenge.ui.util.getGenderColor
import com.example.androiddevchallenge.ui.util.getGenderIcon

@Composable
fun PuppyListItem(
    puppy: Puppy,
    onPupClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp)
            .clickable { onPupClick(puppy.id) }
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .border(width = 4.dp, color = getBackgroundColor(), shape = CircleShape)
        ) {
            Image(
                painter = painterResource(id = puppy.photo),
                contentDescription = "Puppy Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(8.dp).clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = puppy.name, style = MaterialTheme.typography.body1)
            Text(
                text = puppy.type,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.size(4.dp))
            ChipsRow(puppy = puppy)
        }
    }
}

@Composable
fun ChipsRow(
    puppy: Puppy
) {
    Row {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = getGenderColor(sex = puppy.sex).copy(0.2f))
        ) {
            Icon(
                imageVector = getGenderIcon(sex = puppy.sex),
                contentDescription = "Gender Icon",
                modifier = Modifier.padding(4.dp),
                tint = getGenderColor(sex = puppy.sex)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = red.copy(alpha = 0.2f))
        ) {
            Text(
                text = "${puppy.age} years",
                style = MaterialTheme.typography.body2,
                color = red,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = green.copy(alpha = 0.2f))
        ) {
            Text(
                text = "${puppy.weight} kg",
                style = MaterialTheme.typography.body2,
                color = green,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
    }
}

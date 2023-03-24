package com.example.placeholderapp.android.post.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.placeholderapp.data.model.PostResponse
import kotlin.math.min


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.surface)
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .background(Color.White),
        contentAlignment = Alignment.CenterStart
    ) {
        Column {
            Text(
                text = "KMM Dummy Project",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ChipSection(
                "This is a placeholder list",
                chips = viewModel.postState.collectAsState().value
            )
        }
    }
}

@Composable
fun ChipSection(
    title: String,
    chips: List<PostResponse>
) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        ) {
            items(chips.size) { index ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = chips[index].title,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    }
}

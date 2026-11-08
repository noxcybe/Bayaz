package com.bayaz.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayaz.app.ui.theme.BayazTheme

data class MemoryCardData(
    val id: String,
    val title: String,
    val snippet: String,
    val dateFormatted: String,
    val personTag: String
) {
    constructor(
        id: Long,
        title: String,
        snippet: String,
        dateFormatted: String,
        personTag: String
    ) : this(id.toString(), title, snippet, dateFormatted, personTag)

    constructor(
        id: Int,
        title: String,
        snippet: String,
        dateFormatted: String,
        personTag: String
    ) : this(id.toString(), title, snippet, dateFormatted, personTag)
}

val sampleMemoryCards = listOf(
    MemoryCardData(
        id = "1",
        title = "Grandfather's Silk Road Journal",
        snippet = "Discovered handwritten notes from the 1952 journey across Samarkand. The ink is fading, but the pressed mountain flowers remain vivid.",
        dateFormatted = "October 14, 1952",
        personTag = "Grandfather Aziz"
    ),
    MemoryCardData(
        id = "2",
        title = "Autumn Chai in the Courtyard",
        snippet = "Mother recited Hafez as the pomegranate leaves turned amber. A quiet afternoon filled with the warmth of cardamom tea.",
        dateFormatted = "November 23, 1978",
        personTag = "Mother Farida"
    ),
    MemoryCardData(
        id = "3",
        title = "The Old Walnut Tree House",
        snippet = "Carving initials into the ancient bark before our final summer in Isfahan. The smell of cedar and roasted pistachios lingered.",
        dateFormatted = "August 6, 1989",
        personTag = "Uncle Reza"
    )
)

@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
    memories: List<MemoryCardData> = sampleMemoryCards,
    onAddClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 88.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(memories, key = { it.id }) { memory ->
                MemoryCard(memory = memory)
            }
        }

        FloatingActionButton(
            onClick = onAddClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Memory"
            )
        }
    }
}

@Composable
fun MemoryCard(
    memory: MemoryCardData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ochre tag for formatted date
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = memory.dateFormatted,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Terracotta tag for person
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = memory.personTag,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = memory.title,
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = memory.snippet,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimelineScreenPreview() {
    BayazTheme {
        TimelineScreen()
    }
}

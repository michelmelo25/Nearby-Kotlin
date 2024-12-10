package com.michel.nearby.ui.component.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michel.nearby.data.model.NearbyCategory
import com.michel.nearby.data.model.NearbyCategoryFilterChipView

@Composable
fun NearbyCategoryFilterChipList(
    modifier: Modifier = Modifier,
    categories: List<NearbyCategory>,
    onSelectedCategoryChanged: (NearbyCategory) -> Unit
) {
    var selectedCategoyId by remember {
        mutableStateOf(categories.firstOrNull()?.id.orEmpty())
    }

    LaunchedEffect(key1 = selectedCategoyId) {
        val selectedcategoryOrNull = categories.find { it.id == selectedCategoyId }
        selectedcategoryOrNull?.let {
            onSelectedCategoryChanged(it)
        }
    }

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = categories, key = { it.id }) { category ->
            NearbyCategoryFilterChip(
                category = category,
                isSelected = category.id == selectedCategoyId,
                onClick = { isSelected ->
                    if (isSelected)
                        selectedCategoyId = category.id
                }
            )
        }

    }
}

@Preview
@Composable
private fun NearbyCategoryFilterChipListPreview() {
    NearbyCategoryFilterChipList(
        modifier = Modifier.fillMaxWidth(),
        categories = listOf(
            NearbyCategory(
                "1",
                name = "Alimentação"
            ),
            NearbyCategory(
                "2",
                name = "Cinema"
            ),
            NearbyCategory(
                "3",
                name = "Farmácia"
            ),
            NearbyCategory(
                "4",
                name = "Supermercado"
            ),
        ),
        onSelectedCategoryChanged = {}
    )
}
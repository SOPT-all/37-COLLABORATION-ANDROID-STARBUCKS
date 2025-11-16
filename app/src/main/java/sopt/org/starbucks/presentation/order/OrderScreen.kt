package sopt.org.starbucks.presentation.order

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OrderRoute(paddingValues: PaddingValues) {
    OrderScreen(
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
}

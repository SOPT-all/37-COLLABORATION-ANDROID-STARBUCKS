package sopt.org.starbucks.ui.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import sopt.org.starbucks.ui.order.component.OrderHeader

@Composable
fun OrderRoute(
    paddingValues: PaddingValues,
    navigateToMyMenu: () -> Unit
) {
    OrderScreen(
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(OrderTab.ALL) }
    Column(
        modifier = modifier
    ) {
        OrderHeader(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

package sopt.org.starbucks.ui.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.ui.order.component.MyMenuItem
import sopt.org.starbucks.ui.order.component.OrderHeader
import sopt.org.starbucks.ui.order.component.StoreSelector

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
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 25.dp)
        ) {
            item {
                OrderHeader(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }

            item {
                MyMenuItem(
                    imgUrl = "https://i.pinimg.com/1200x/27/78/0f/27780fc651dff0eb419b06ecf93a3055.jpg",
                    title = "상큼발랄 프레셔",
                    menuName = "아이스 핑크 팝 캐모마일 릴렉서",
                    option = "ICED | Tall",
                    price = "6,500원",
                    onEditClick = {}
                )
            }
        }
        StoreSelector()
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderScreenPreview() {
    StarbucksTheme {
        OrderScreen()
    }
}

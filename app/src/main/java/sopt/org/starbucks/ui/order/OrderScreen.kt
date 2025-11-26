package sopt.org.starbucks.ui.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.core.util.onSuccess
import sopt.org.starbucks.ui.order.component.MyMenuItem
import sopt.org.starbucks.ui.order.component.OrderHeader
import sopt.org.starbucks.ui.order.component.StoreSelector

@Composable
fun OrderRoute(
    paddingValues: PaddingValues,
    navigateToMyMenu: (Long) -> Unit,
    viewModel: OrderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadMyMenuList()
    }

    OrderScreen(
        uiState = uiState,
        onTabSelected = viewModel::onTabSelected,
        onEditClick = navigateToMyMenu,
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun OrderScreen(
    uiState: OrderUiState,
    onTabSelected: (OrderTab) -> Unit,
    onEditClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(bottom = 25.dp)
        ) {
            item {
                OrderHeader(
                    selectedTab = uiState.currentTab,
                    onTabSelected = onTabSelected
                )
            }

            uiState.myMenuListLoadState.onSuccess { list ->
                val filteredList = when (uiState.currentTab) {
                    OrderTab.ALL -> list
                    OrderTab.DRINK -> list.filter { it.category == "DRINK" }
                    OrderTab.FOOD -> list.filter { it.category == "FOOD" }
                }
                items(filteredList) { myMenu ->
                    MyMenuItem(
                        imgUrl = myMenu.imgUrl,
                        myMenuName = myMenu.myMenuName,
                        menuName = myMenu.menuName,
                        option = myMenu.myMenuOption,
                        price = myMenu.price,
                        onEditClick = { onEditClick(myMenu.myMenuId) }
                    )
                }
            }
        }
        StoreSelector()
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderScreenPreview() {
    var uiState by remember {
        mutableStateOf(
            OrderUiState(
                myMenuListLoadState = UiState.Success(dummyMyMenu),
                currentTab = OrderTab.ALL
            )
        )
    }
    StarbucksTheme {
        OrderScreen(
            uiState = uiState,
            onTabSelected = {
                uiState = uiState.copy(
                    currentTab = it
                )
            },
            onEditClick = {},
            modifier = Modifier.statusBarsPadding()
        )
    }
}

package sopt.org.starbucks.ui.mymenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.core.util.onSuccess
import sopt.org.starbucks.core.util.toStringWithFormat
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.ui.mymenu.component.DrinkImageSection
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.DrinkTitleSection
import sopt.org.starbucks.ui.mymenu.component.EcoFriendlySection
import sopt.org.starbucks.ui.mymenu.component.MyMenuRegisterBar
import sopt.org.starbucks.ui.mymenu.component.NoticeBox
import sopt.org.starbucks.ui.mymenu.component.ProductInfoButton
import sopt.org.starbucks.ui.mymenu.component.SelectCupSection
import sopt.org.starbucks.ui.mymenu.component.TabToggle
import sopt.org.starbucks.ui.mymenu.component.TabType

@Composable
fun MyMenuRoute(
    paddingValues: PaddingValues,
    menuId: Long,
    onBackClick: () -> Unit,
    viewModel: MyMenuViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(menuId) {
        viewModel.loadMenu(menuId)
    }

    MyMenuScreen(
        uiState = uiState.value,
        onTabSelected = viewModel::selectTab,
        onSizeSelected = viewModel::selectSize,
        onPersonalCupToggle = viewModel::togglePersonalCup,
        onBackClick = onBackClick,
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
    )
}

@Composable
fun MyMenuScreen(
    uiState: MyMenuUiState,
    onTabSelected: (TabType) -> Unit,
    onSizeSelected: (DrinkSize) -> Unit,
    onPersonalCupToggle: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(StarbucksTheme.colors.white)
    ) {
        uiState.menuLoadState.onSuccess { menu ->
            MyMenuContent(
                menu = menu,
                selectedTab = uiState.selectedTab,
                selectedSize = uiState.selectedSize,
                isPersonalCupChecked = uiState.isPersonalCupChecked,
                onTabSelected = onTabSelected,
                onSizeSelected = onSizeSelected,
                onPersonalCupToggle = onPersonalCupToggle,
                onBackClick = onBackClick
            )
        }
    }
}

@Composable
private fun MyMenuContent(
    menu: MenuDetailModel,
    selectedTab: TabType,
    selectedSize: DrinkSize,
    isPersonalCupChecked: Boolean,
    onTabSelected: (TabType) -> Unit,
    onSizeSelected: (DrinkSize) -> Unit,
    onPersonalCupToggle: () -> Unit,
    onBackClick: () -> Unit
) {
    val sizePrice = when (selectedSize) {
        DrinkSize.TALL -> menu.sizePrices.tall
        DrinkSize.GRANDE -> menu.sizePrices.grande
        DrinkSize.VENTI -> menu.sizePrices.venti
    }
    val totalPrice = menu.price + sizePrice

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            val (imageUrl, koreanName, englishName) = when (selectedTab) {
                TabType.HOT -> Triple(menu.hotMenuImageUrl, menu.hotMenuKr, menu.hotMenuEng)
                TabType.ICED -> Triple(menu.iceMenuImageUrl, menu.iceMenuKr, menu.iceMenuEng)
            }

            DrinkImageSection(
                modifier = Modifier,
                imageUrl = imageUrl,
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            DrinkTitleSection(
                koreanTitle = koreanName,
                englishTitle = englishName,
                description = menu.info,
                isNew = menu.isNew,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(11.5.dp))

            Text(
                text = "${totalPrice.toStringWithFormat()}원",
                style = StarbucksTheme.typography.bodyBold22,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            TabToggle(
                selectedTab = selectedTab,
                onTabSelected = onTabSelected,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            NoticeBox(
                notices = menu.notices,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(19.dp))

            ProductInfoButton(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            SelectCupSection(
                selectedSize = selectedSize,
                onSizeSelected = onSizeSelected,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            EcoFriendlySection(
                isPersonalCupChecked = isPersonalCupChecked,
                onPersonalCupToggle = onPersonalCupToggle,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(9.dp))

            PersonalOptionContent()
        }

        MyMenuRegisterBar(
            optionInfo = "${selectedTab.title} | ${selectedSize.displayName}",
            onAddNewClick = { },
            onSaveClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyMenuScreenLoadingPreview() {
    StarbucksTheme {
        MyMenuScreen(
            uiState = MyMenuUiState(menuLoadState = UiState.Loading),
            onTabSelected = {},
            onSizeSelected = {},
            onPersonalCupToggle = {},
            onBackClick = {}
        )
    }
}

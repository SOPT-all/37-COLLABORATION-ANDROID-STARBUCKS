package sopt.org.starbucks.ui.mymenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.onSuccess
import sopt.org.starbucks.core.util.toStringWithFormat
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.data.model.PersonalOption
import sopt.org.starbucks.ui.mymenu.component.DrinkImageSection
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.DrinkTitleSection
import sopt.org.starbucks.ui.mymenu.component.EcoFriendlySection
import sopt.org.starbucks.ui.mymenu.component.MyMenuRegisterBar
import sopt.org.starbucks.ui.mymenu.component.NoticeBox
import sopt.org.starbucks.ui.mymenu.component.ProductInfoButton
import sopt.org.starbucks.ui.mymenu.component.SelectCupSection
import sopt.org.starbucks.ui.mymenu.component.StarbucksOrderDialog
import sopt.org.starbucks.ui.mymenu.component.TabToggle
import sopt.org.starbucks.ui.mymenu.component.TabType

@Composable
fun MyMenuRoute(
    menuId: Long,
    onBackClick: () -> Unit,
    navigateToOrder: () -> Unit,
    viewModel: MyMenuViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(menuId) {
        viewModel.loadMenu(menuId)
    }

    if (uiState.showDialog) {
        val content = when (uiState.dialogType) {
            DialogType.RESET -> "전체 초기화하면 설정하신 퍼스널 옵션을 되돌릴 수 없어요."
            DialogType.DELETE -> "${uiState.selectedOption?.name}"
        }
        StarbucksOrderDialog(
            onDismissRequest = viewModel::onDismissRequest,
            dialogType = uiState.dialogType,
            content = content,
            onConfirmClick = viewModel::onDialogConfirm,
            onCancelClick = viewModel::onDismissRequest
        )
    }

    MyMenuScreen(
        uiState = uiState,
        onTabSelected = viewModel::selectTab,
        onSizeSelected = viewModel::selectSize,
        onPersonalCupToggle = viewModel::togglePersonalCup,
        onBackClick = onBackClick,
        onResetClick = viewModel::onResetClick,
        onCancelClick = viewModel::onCancelClick,
        onSaveClick = {
            viewModel.onSaveOption(menuId)
            navigateToOrder()
        }
    )
}

@Composable
fun MyMenuScreen(
    uiState: MyMenuUiState,
    onTabSelected: (TabType) -> Unit,
    onSizeSelected: (DrinkSize) -> Unit,
    onPersonalCupToggle: () -> Unit,
    onBackClick: () -> Unit,
    onResetClick: () -> Unit,
    onCancelClick: (PersonalOption) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    uiState.menuLoadState.onSuccess { menu ->
        MyMenuContent(
            menu = menu,
            uiState = uiState,
            onTabSelected = onTabSelected,
            onSizeSelected = onSizeSelected,
            onPersonalCupToggle = onPersonalCupToggle,
            onBackClick = onBackClick,
            onResetClick = onResetClick,
            onCancelClick = onCancelClick,
            onSaveClick = onSaveClick,
            modifier = modifier
        )
    }
}

@Composable
private fun MyMenuContent(
    menu: MenuDetailModel,
    uiState: MyMenuUiState,
    onTabSelected: (TabType) -> Unit,
    onSizeSelected: (DrinkSize) -> Unit,
    onPersonalCupToggle: () -> Unit,
    onBackClick: () -> Unit,
    onResetClick: () -> Unit,
    onCancelClick: (PersonalOption) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(StarbucksTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 14.dp)
        ) {
            val (imageUrl, koreanName, englishName) = when (uiState.selectedTab) {
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
                text = "${uiState.totalPrice.toStringWithFormat()}원",
                style = StarbucksTheme.typography.bodyBold22,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            TabToggle(
                selectedTab = uiState.selectedTab,
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
                selectedSize = uiState.selectedSize,
                onSizeSelected = onSizeSelected,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            EcoFriendlySection(
                isPersonalCupChecked = uiState.isPersonalCupChecked,
                onPersonalCupToggle = onPersonalCupToggle,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(9.dp))

            PersonalOptionContent(
                optionList = uiState.optionList,
                onResetClick = onResetClick,
                onCancelClick = onCancelClick
            )
        }

        MyMenuRegisterBar(
            optionInfo = "${uiState.selectedTab.title} | ${uiState.selectedSize.displayName}",
            onAddNewClick = { },
            onSaveClick = onSaveClick
        )
    }
}

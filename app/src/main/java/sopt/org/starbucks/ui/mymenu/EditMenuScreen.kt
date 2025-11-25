package sopt.org.starbucks.ui.mymenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
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
fun EditMenuScreen(
    menu: MenuDetailModel,
    selectedTab: TabType,
    selectedSize: DrinkSize,
    isPersonalCupChecked: Boolean,
    onTabSelected: (TabType) -> Unit,
    onSizeSelected: (DrinkSize) -> Unit,
    onPersonalCupToggle: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StarbucksTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            DrinkImageSection(
                modifier = Modifier,
                imageUrl = menu.imageUrl,
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            DrinkTitleSection(
                koreanTitle = menu.koreanName,
                englishTitle = menu.englishName,
                description = menu.description,
                isNew = menu.isNew,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(11.5.dp))

            Text(
                text = "${menu.price}원",
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
private fun EditMenuScreenPreview() {
    var selectedTab by remember { mutableStateOf(TabType.ICED) }
    var selectedSize by remember { mutableStateOf(DrinkSize.TALL) }
    var isPersonalCupChecked by remember { mutableStateOf(false) }

    StarbucksTheme {
        EditMenuScreen(
            menu = MenuDetailModel(
                id = "1",
                koreanName = "아이스 핑크 팝 캐모마일 릴렉서",
                englishName = "Iced Pink Pop Chamomile Relaxer",
                description = "크리스마스에 어울리는 상큼한 핑크팝과 캐모마일 릴렉서! 리치, 레몬그라스, 캐모마일의 차분하면서도 새콤달콤한 조합",
                imageUrl = null,
                price = 6500,
                isNew = true,
                notices = listOf(
                    "* 리치 과육의 숙 캡슐이 있을 수 있지만 안심하고 드세요.",
                    "* 대체당(스테비아)을 일부 사용하여 당과 칼로리를 낮췄습니다."
                )
            ),
            selectedTab = selectedTab,
            selectedSize = selectedSize,
            isPersonalCupChecked = isPersonalCupChecked,
            onTabSelected = { selectedTab = it },
            onSizeSelected = { selectedSize = it },
            onPersonalCupToggle = { isPersonalCupChecked = !isPersonalCupChecked },
            onBackClick = {}
        )
    }
}

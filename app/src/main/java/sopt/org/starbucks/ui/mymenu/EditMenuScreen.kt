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
import sopt.org.starbucks.ui.edit.component.EcoFriendlySection
import sopt.org.starbucks.ui.mymenu.component.DrinkImageSection
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.DrinkTitleSection
import sopt.org.starbucks.ui.mymenu.component.MyMenuRegisterBar
import sopt.org.starbucks.ui.mymenu.component.NoticeBox
import sopt.org.starbucks.ui.mymenu.component.ProductInfoButton
import sopt.org.starbucks.ui.mymenu.component.SelectCupSection
import sopt.org.starbucks.ui.mymenu.component.TabToggle
import sopt.org.starbucks.ui.mymenu.component.TabType

@Composable
fun EditMenuScreen(
    modifier: Modifier = Modifier
        .background(StarbucksTheme.colors.white)
) {
    var selectedTab by remember { mutableStateOf(TabType.ICED) }
    var selectedSize by remember { mutableStateOf(DrinkSize.TALL) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 120.dp)
        ) {
            DrinkImageSection(
                modifier = Modifier,
                imageUrl = "",
            )

            Spacer(modifier = Modifier.height(20.dp))

            DrinkTitleSection(
                koreanTitle = "아이스 핑크 팝 캐모마일 릴렉서",
                englishTitle = "Iced Pink Pop Chamomile Relaxer",
                description = "크리스마스에 어울리는 상쾌한 핑크팝과 캐모마일 릴렉서! " +
                    "리치, 레몬그라스, 캐모마일의 차분하면서도 새콤달콤한 조합 " +
                    "그리스마스 오너먼트가 떠오르는 핑크 리치 보바로 팝! " +
                    "터지는 식감의 재미와 리치 풍미를 더했습니다",
                isNew = true,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(11.5.dp))

            Text(
                text = "6,500원",
                style = StarbucksTheme.typography.bodyBold22,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            TabToggle(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            NoticeBox(
                notices = listOf(
                    "* 리치 과육의 숙 캡슐이 있을 수 있지만 안심하고 드세요.",
                    "* 대체당(츄스티아)을 일부 사용하여 당과 칼로리를 낮췄습니다."
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(19.dp))

            ProductInfoButton(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            SelectCupSection(
                selectedSize = selectedSize,
                onSizeSelected = { selectedSize = it },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            EcoFriendlySection(
                isPersonalCupChecked = false,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(9.dp))

            PersonalOptionContent()
        }

        MyMenuRegisterBar(
            optionInfo = "${selectedTab.title} | ${selectedSize.displayName}",
            onAddNewClick = { },
            onSaveClick = { },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EditMenuScreenPreview() {
    StarbucksTheme {
        EditMenuScreen()
    }
}

package sopt.org.starbucks.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.ui.home.component.*

@Composable
fun HomeRoute(paddingValues: PaddingValues) {
    HomeScreen(
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var selectedTab by rememberSaveable { mutableStateOf(QuickOrderTab.MY_MENU) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(StarbucksTheme.colors.white)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            MainBanner(
                modifier = Modifier.matchParentSize(),
                line1 = "미국에서 온 케이크 팝과",
                line2 = "사탕 같은 시간을 보내요"
            )

            ChipSection(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = (-37).dp)
                    .padding(start = 22.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        QuickOrderHeader(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        QuickOrderList(
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun ChipSection(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_green_star,
                text = "Green",
                trailingText = "2",
                textColor = StarbucksTheme.colors.gray600,
                trailingTextColor = StarbucksTheme.colors.green500,
                showNewTag = true
            )
        }

        item {
            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_coupon,
                text = "Coupon"
            )
        }

        item {
            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_pay2,
                text = "Pay"
            )
        }

        item {
            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_buddy_pass,
                text = "Buddy Pass"
            )
        }
    }
}

@Composable
fun QuickOrderList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        items(sampleQuickOrderList) { item ->
            QuickOrderItem(
                item = item
            )
        }

        item {
            QuickOrderRegisterItem(
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

private val sampleQuickOrderList = listOf(
    QuickOrderUiModel(
        id = 1,
        title = "상큼발랄 프레셔",
        option = "ICED | Tall | 바닐라 시럽2 | 로즈마리 없이 | 얼음 적게 | 일반 휘핑 많이 | 핑크 리치 보바 없이",
        imageRes = R.drawable.img_sample_drink
    ),
    QuickOrderUiModel(
        id = 2,
        title = "나의 아메리카노",
        option = "ICED | Tall | 에스프레소 5샷",
        imageRes = R.drawable.img_sample_drink
    )
)

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 500
)
@Composable
private fun HomeScreenPreview() {
    StarbucksTheme {
        HomeScreen()
    }
}

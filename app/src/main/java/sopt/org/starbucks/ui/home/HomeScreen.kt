package sopt.org.starbucks.ui.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import sopt.org.starbucks.ui.home.component.Chip
import sopt.org.starbucks.ui.home.component.ChipStyle
import sopt.org.starbucks.ui.home.component.MainBanner
import sopt.org.starbucks.ui.home.component.NewsContent
import sopt.org.starbucks.ui.home.component.OnlineStoreCard
import sopt.org.starbucks.ui.home.component.QuickOrderHeader
import sopt.org.starbucks.ui.home.component.QuickOrderItem
import sopt.org.starbucks.ui.home.component.QuickOrderRegisterItem
import sopt.org.starbucks.ui.home.component.QuickOrderTab
import sopt.org.starbucks.ui.home.component.QuickOrderUiModel
import sopt.org.starbucks.ui.home.component.RecommendMenuList
import sopt.org.starbucks.ui.home.component.SectionHeader
import sopt.org.starbucks.ui.home.component.SectionType
import sopt.org.starbucks.ui.home.component.type.OnlineStoreType

@Composable
fun HomeRoute(paddingValues: PaddingValues) {
    HomeScreen(
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var selectedTab by rememberSaveable { mutableStateOf(QuickOrderTab.MY_MENU) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(StarbucksTheme.colors.white),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
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
        }

        item {
            QuickOrderHeader(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }

        item {
            QuickOrderList()
        }

        item {
            Column {
                SectionHeader(
                    type = SectionType.RECOMMEND_MENU,
                    title = "가요이님을 위한 추천메뉴",
                    subtitle = "최근 주문과 취향을 바탕으로, 지금 딱 어울리는 추천 메뉴를 \n준비했어요✨"
                )
                RecommendMenuList()
            }
        }

        item {
            Image(
                painter = androidx.compose.ui.res.painterResource(R.drawable.img_poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Column {
                SectionHeader(
                    type = SectionType.ONLINE_STORE,
                    title = "STARBUCKS ONLINE STORE"
                )

                Spacer(modifier = Modifier.height(6.dp))

                OnlineStoreCard(
                    onlineStoreType = OnlineStoreType.SSGDAY,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                OnlineStoreCard(
                    onlineStoreType = OnlineStoreType.HEART,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        }

        item {
            Column {
                SectionHeader(
                    type = SectionType.WHATS_NEW,
                    title = "What's New",
                    onSeeAllClick = { }
                )

                Spacer(modifier = Modifier.height(6.dp))

                NewsContent()
            }
        }
    }
}

@Composable
private fun ChipSection(modifier: Modifier = Modifier) {
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
private fun QuickOrderList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ) {
        items(sampleQuickOrderList) { item ->
            QuickOrderItem(
                item = item
            )
        }

        item {
            QuickOrderRegisterItem()
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
)
@Composable
private fun HomeScreenPreview() {
    StarbucksTheme {
        HomeScreen()
    }
}

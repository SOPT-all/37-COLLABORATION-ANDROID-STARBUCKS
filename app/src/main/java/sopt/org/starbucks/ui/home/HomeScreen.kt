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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.ui.home.component.ChipSection
import sopt.org.starbucks.ui.home.component.MainBanner
import sopt.org.starbucks.ui.home.component.NewsContent
import sopt.org.starbucks.ui.home.component.OnlineStoreCard
import sopt.org.starbucks.ui.home.component.QuickOrderHeader
import sopt.org.starbucks.ui.home.component.QuickOrderList
import sopt.org.starbucks.ui.home.component.QuickOrderTab
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
                painter = painterResource(R.drawable.img_poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
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
                Spacer(modifier = Modifier.height(8.dp))
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

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun HomeScreenPreview() {
    StarbucksTheme {
        HomeScreen()
    }
}

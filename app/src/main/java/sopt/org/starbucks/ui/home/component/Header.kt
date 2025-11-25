package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

enum class QuickOrderTab { MY_MENU, RECENT_MENU }
enum class SectionType {
    ONLINE_STORE,
    WHATS_NEW,
    RECOMMEND_MENU
}

@Composable
fun QuickOrderHeader(
    selectedTab: QuickOrderTab,
    onTabSelected: (QuickOrderTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Quick Order",
            style = StarbucksTheme.typography.headBold20,
            color = StarbucksTheme.colors.black
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row(
                modifier = Modifier.noRippleClickable {
                    onTabSelected(QuickOrderTab.MY_MENU)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_pencil_11),
                    contentDescription = null,
                    tint = StarbucksTheme.colors.black,
                    modifier = Modifier.size(11.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "나만의 메뉴",
                    style = if (selectedTab == QuickOrderTab.MY_MENU) {
                        StarbucksTheme.typography.headSemiBold14
                    } else {
                        StarbucksTheme.typography.captionRegular13
                    },
                    color = if (selectedTab == QuickOrderTab.MY_MENU) {
                        StarbucksTheme.colors.black
                    } else {
                        StarbucksTheme.colors.gray600
                    }
                )
            }

            Text(
                text = "최근메뉴",
                style = if (selectedTab == QuickOrderTab.RECENT_MENU) {
                    StarbucksTheme.typography.headSemiBold14
                } else {
                    StarbucksTheme.typography.captionRegular14
                },
                color = if (selectedTab == QuickOrderTab.RECENT_MENU) {
                    StarbucksTheme.colors.black
                } else {
                    StarbucksTheme.colors.gray600
                },
                modifier = Modifier.noRippleClickable {
                    onTabSelected(QuickOrderTab.RECENT_MENU)
                }
            )
        }
    }
}

@Composable
fun SectionHeader(
    type: SectionType,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    onSeeAllClick: () -> Unit = { }
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = StarbucksTheme.typography.headSemiBold18,
                color = StarbucksTheme.colors.gray900
            )

            if (type == SectionType.WHATS_NEW) {
                Text(
                    text = "See all",
                    style = StarbucksTheme.typography.bodySemiBold13,
                    color = StarbucksTheme.colors.green500,
                    modifier = Modifier.noRippleClickable { onSeeAllClick() }
                )
            }
        }

        subtitle?.let {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = it,
                style = StarbucksTheme.typography.captionRegular13,
                color = StarbucksTheme.colors.gray700
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickOrderHeaderPreview() {
    StarbucksTheme {
        var selectedTab by rememberSaveable { mutableStateOf(QuickOrderTab.MY_MENU) }

        QuickOrderHeader(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun SectionHeaderPreview() {
    SectionHeader(
        type = SectionType.ONLINE_STORE,
        title = "STARBUCKS ONLINE STORE"
    )
}

@Preview (showBackground = true)
@Composable
private fun SectionHeaderPreview2() {
    SectionHeader(
        type = SectionType.WHATS_NEW,
        title = "What's New",
        onSeeAllClick = { }
    )
}

@Preview (showBackground = true)
@Composable
private fun SectionHeaderPreview3() {
    SectionHeader(
        type = SectionType.RECOMMEND_MENU,
        title = "가요이님을 위한 추천메뉴",
        subtitle = "최근 주문과 취향을 바탕으로, 지금 딱 어울리는 추천 메뉴를 \n준비했어요✨"
    )
}

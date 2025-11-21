package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun QuickOrderHeader(
    selectedTab: QuickOrderTab,
    onTabSelected: (QuickOrderTab) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Quick Order",
            style = StarbucksTheme.typography.headBold20,
            color = StarbucksTheme.colors.black
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
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

            Spacer(modifier = Modifier.width(15.dp))

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

@Preview(showBackground = true)
@Composable
fun QuickOrderHeaderPreview() {
    StarbucksTheme {
        var selectedTab by rememberSaveable { mutableStateOf(QuickOrderTab.MY_MENU) }

        QuickOrderHeader(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

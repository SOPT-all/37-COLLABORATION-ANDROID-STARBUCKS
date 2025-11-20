package sopt.org.starbucks.ui.order.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.bottomBorder
import sopt.org.starbucks.core.util.noRippleClickable
import sopt.org.starbucks.ui.order.OrderTab

@Composable
fun OrderHeader(
    selectedTab: OrderTab,
    onTabSelected: (OrderTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(1.dp, StarbucksTheme.colors.gray200)
            .padding(horizontal = 16.dp)
            .padding(bottom = 13.dp, top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back_24),
                contentDescription = null,
                tint = StarbucksTheme.colors.gray500
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = null,
                tint = StarbucksTheme.colors.gray800
            )
        }
        Text(
            text = "나만의 메뉴",
            style = StarbucksTheme.typography.headBold21,
            color = StarbucksTheme.colors.black,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OrderTab.entries.forEach { tab ->
                TabButton(
                    text = tab.text,
                    selected = tab == selectedTab,
                    onClick = {
                        if (tab != selectedTab) {
                            onTabSelected(tab)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun TabButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shadowColor = Color(0f, 0f, 0f, 0.30f)
    val roundedCornerShape = RoundedCornerShape(22.dp)

    Box(
        modifier = modifier
            .shadow(
                elevation = if (selected) 0.dp else 4.dp,
                shape = roundedCornerShape,
                clip = false,
                ambientColor = shadowColor,
                spotColor = shadowColor
            ).clip(roundedCornerShape)
            .background(if (selected) StarbucksTheme.colors.gray900 else StarbucksTheme.colors.white, roundedCornerShape)
            .noRippleClickable(onClick)
            .padding(vertical = 5.dp, horizontal = 20.dp)
    ) {
        Text(
            text = text,
            style = StarbucksTheme.typography.captionRegular14,
            color = if (selected) StarbucksTheme.colors.white else StarbucksTheme.colors.gray700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderHeaderPreview() {
    var selectedTab by remember { mutableStateOf(OrderTab.ALL) }
    StarbucksTheme {
        OrderHeader(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

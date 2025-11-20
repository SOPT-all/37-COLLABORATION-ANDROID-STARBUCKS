package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

@Composable
fun TabToggle() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("HOT", "ICED")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(8.dp)
            .background(
                color = StarbucksTheme.colors.gray100,
                shape = RoundedCornerShape(19.dp)
            )
    ) {
        tabs.forEachIndexed { index, title ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .shadow(
                        elevation = if (selectedTab == index) 2.dp else 0.dp,
                        shape = RoundedCornerShape(19.dp),
                        spotColor = Color.Black.copy(0.3f),
                        ambientColor = Color.Black.copy(0.1f)
                    ).fillMaxHeight()
                    .background(
                        color = if (selectedTab == index) StarbucksTheme.colors.white else Color.Transparent,
                        shape = RoundedCornerShape(19.dp)
                    ).noRippleClickable { selectedTab = index },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = if (selectedTab == index) StarbucksTheme.colors.blue02 else StarbucksTheme.colors.gray500,
                    style = StarbucksTheme.typography.headSemiBold14
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabTogglePreview() {
    TabToggle()
}

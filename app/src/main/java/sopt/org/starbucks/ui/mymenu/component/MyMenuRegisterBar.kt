package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.dropShadow
import sopt.org.starbucks.core.util.noRippleClickable

@Composable
fun MyMenuRegisterBar(
    optionInfo: String,
    onAddNewClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .dropShadow(
                shape = RectangleShape,
                color = Color.Black.copy(0.25f),
                blur = 3.dp,
                offsetY = (-2).dp
            ).background(StarbucksTheme.colors.white)
            .padding(top = 11.dp, bottom = 36.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = optionInfo,
            style = StarbucksTheme.typography.bodyRegular13,
            color = StarbucksTheme.colors.gray700,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MyMenuButton(
                text = "새로 추가하기",
                textColor = StarbucksTheme.colors.green500,
                backgroundColor = StarbucksTheme.colors.white,
                onClick = onAddNewClick,
                modifier = Modifier.weight(1f)
            )
            MyMenuButton(
                text = "저장하기",
                textColor = StarbucksTheme.colors.white,
                backgroundColor = StarbucksTheme.colors.green500,
                onClick = onSaveClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun MyMenuButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .border(2.dp, StarbucksTheme.colors.green500, RoundedCornerShape(40.dp))
            .background(backgroundColor)
            .noRippleClickable(onClick)
            .padding(vertical = 13.dp, horizontal = 35.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = StarbucksTheme.typography.captionRegular14,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyMenuRegisterBarPreview() {
    StarbucksTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(StarbucksTheme.colors.white),
            verticalArrangement = Arrangement.Bottom
        ) {
            MyMenuRegisterBar(
                optionInfo = "ICED | Tall",
                onAddNewClick = {},
                onSaveClick = {}
            )
        }
    }
}

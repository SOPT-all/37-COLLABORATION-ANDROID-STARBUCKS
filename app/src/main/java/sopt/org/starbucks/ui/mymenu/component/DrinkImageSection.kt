package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun DrinkImageSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(330.dp)
            .background(StarbucksTheme.colors.red01)
    ) {
        // 뒤로가기
        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 62.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "뒤로가기",
                tint = Color.Unspecified,
                modifier = Modifier.size(33.dp)
            )
        }

        // 공유
        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 62.dp, end = 19.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "공유",
                modifier = Modifier.size(33.dp),
                tint = Color.Unspecified
            )
        }

        // 음료 이미지
        Icon(
            painter = painterResource(id = R.drawable.ic_order),
            contentDescription = "중앙 음료 이미자",
            modifier = Modifier
                .align(Alignment.Center)
                .size(330.dp),
            tint = Color.Unspecified
        )

        // 이미지
        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 22.dp, end = 19.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = "이미지",
                tint = Color.Unspecified,
                modifier = Modifier.size(33.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DrinkImageSectionPreview() {
    StarbucksTheme {
        DrinkImageSection()
    }
}

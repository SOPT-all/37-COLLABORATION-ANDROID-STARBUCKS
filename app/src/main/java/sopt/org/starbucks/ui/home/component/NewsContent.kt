package sopt.org.starbucks.ui.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun NewsContent(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            NewsItem(
                image = R.drawable.img_home_news_01,
                title = "각인 뉴턴 캔디 핑크 텀블러 355...",
                description = "러블리한 핑크빛 각인 텀블러를 쓱데이 헤택과 함께 만나보세요!"
            )
        }

        item {
            NewsItem(
                image = R.drawable.img_home_news_02,
                title = "2025 WINTER e-FREQUE...",
                description = "스타벅스 삼성카드로 2025 WINTER e-FREQUENCY 참여시 별★52개 적립!"
            )
        }
    }
}

@Composable
private fun NewsItem(
    @DrawableRes image: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(225.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "news image",
            modifier = Modifier.size(width = 225.dp, height = 150.dp)
        )

        Spacer(modifier = Modifier.height(11.dp))

        Text(
            text = title,
            style = StarbucksTheme.typography.headMedium16,
            color = StarbucksTheme.colors.gray900,
            modifier = Modifier.padding(bottom = 2.dp)
        )

        Text(
            text = description,
            style = StarbucksTheme.typography.captionRegular12,
            color = StarbucksTheme.colors.gray600
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NewsContentPreview() {
    StarbucksTheme {
        NewsContent()
    }
}

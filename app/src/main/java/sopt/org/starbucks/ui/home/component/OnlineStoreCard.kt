package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.ui.home.component.type.OnlineStoreType

@Composable
fun OnlineStoreCard(
    onlineStoreType: OnlineStoreType,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when(onlineStoreType) {
        OnlineStoreType.SSGDAY -> StarbucksTheme.colors.red02
        OnlineStoreType.HEART -> StarbucksTheme.colors.yellow03
    }

    val textColor = when(onlineStoreType) {
        OnlineStoreType.SSGDAY -> StarbucksTheme.colors.red01
        OnlineStoreType.HEART -> StarbucksTheme.colors.yellow01
    }

    val annotatedMessage = when(onlineStoreType) {
        OnlineStoreType.SSGDAY -> buildAnnotatedString {
            val blackColor = SpanStyle(color = StarbucksTheme.colors.black)
            val redColor = SpanStyle(color = StarbucksTheme.colors.red01)

            withStyle(blackColor) { append("매일 펼쳐지는 새로움!\n단 11일,") }
            withStyle(redColor) { append("쓱데이 ") }
            withStyle(blackColor) { append("한정\n혜택을 만나보세요") }
        }

        OnlineStoreType.HEART -> buildAnnotatedString {
            val blackColor = SpanStyle(color = StarbucksTheme.colors.black)
            val yellowColor = SpanStyle(StarbucksTheme.colors.yellow01)

            withStyle(blackColor) { append("Make Every Moment\nSweeter! ") }
            withStyle(yellowColor) { append("하트") }
            withStyle(blackColor) { append("로\n") }
            withStyle(yellowColor) { append("달콤한 사랑") }
            withStyle(blackColor) { append("을 전해보세요") }
        }
    }

    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp))

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(26.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "ONLINE STORE",
                    style = StarbucksTheme.typography.bodyMedium16,
                    color = textColor
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = annotatedMessage,
                    style = StarbucksTheme.typography.bodyMedium16
                )

                if (OnlineStoreType.SSGDAY == onlineStoreType) {
                    Text(
                        text = OnlineStoreType.SSGDAY.date.orEmpty(),
                        style = StarbucksTheme.typography.captionRegular12,
                        color = StarbucksTheme.colors.gray600,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }

            Image(
                painter = painterResource(onlineStoreType.image),
                contentDescription = "online img"
            )
        }
    }
}

@Preview
@Composable
private fun OnlineStoreCardPreview() {
    StarbucksTheme {
        OnlineStoreCard(
            onlineStoreType = OnlineStoreType.SSGDAY
        )
    }
}


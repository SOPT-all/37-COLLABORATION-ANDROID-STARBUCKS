package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

@Composable
fun QuickOrderItem(
    title: String,
    option: String,
    option2: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    var isFavorite by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier
            .size(width = 255.dp, height = 144.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(StarbucksTheme.colors.gray100)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite),
                    contentDescription = null,
                    tint = if (isFavorite) {
                        StarbucksTheme.colors.green500
                    } else {
                        StarbucksTheme.colors.gray400
                    },
                    modifier = Modifier
                        .padding(start = 2.dp, end = 1.dp)
                        .padding(vertical = 2.dp)
                        .noRippleClickable { isFavorite = !isFavorite }
                )
            }

            // 이미지 + 제목 + 옵션
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.Top
            ) {
                // 음료 이미지
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // 제목 + 옵션
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 2.dp, end = 16.dp)
                ) {
                    Text(
                        text = title,
                        style = StarbucksTheme.typography.headSemiBold12,
                        color = StarbucksTheme.colors.black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = option,
                            style = StarbucksTheme.typography.captionRegular12,
                            color = StarbucksTheme.colors.gray600
                        )
                        Text(
                            text = " | ",
                            style = StarbucksTheme.typography.captionBold11,
                            color = StarbucksTheme.colors.gray600
                        )
                        Text(
                            text = option2,
                            style = StarbucksTheme.typography.captionRegular12,
                            color = StarbucksTheme.colors.gray600
                        )
                    }
                }
            }

            // 구분선
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(StarbucksTheme.colors.gray200)
            )

            Spacer(modifier = Modifier.height(10.dp))

            //  하단 버튼 영역
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, bottom = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 매장 설정 -> 아이콘 + 텍스트
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = StarbucksTheme.colors.brown,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "매장을 설정 하세요.",
                        style = StarbucksTheme.typography.captionRegular12Underline,
                        color = StarbucksTheme.colors.brown
                    )
                }

                // 바로 주문하기 버튼
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(44.dp))
                        .background(Color.Black)
                        .noRippleClickable {}
                        .padding(horizontal = 9.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "바로 주문하기",
                        style = StarbucksTheme.typography.captionRegular11,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickOrderItemPreview() {
    StarbucksTheme {
        QuickOrderItem(
            title = "나만의 아이스 핑크 팝\n캐모마일 릴렉서",
            option = "ICED",
            option2 = "Tall",
            imageRes = R.drawable.img_sample_drink
        )
    }
}

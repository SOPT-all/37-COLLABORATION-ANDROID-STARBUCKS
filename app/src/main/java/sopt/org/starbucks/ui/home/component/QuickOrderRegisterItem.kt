package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun QuickOrderRegisterItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val borderColor = StarbucksTheme.colors.gray200

    Box(
        modifier = modifier
            .background(StarbucksTheme.colors.transparent)
            .drawBehind {
                val stroke = Stroke(
                    width = 1.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )

                drawRoundRect(
                    color = borderColor,
                    size = this.size,
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                    style = stroke
                )
            }
            .size(width = 255.dp, height = 144.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // 음료 컵 이미지 + 안내 텍스트
            Row(
                modifier = Modifier
                    .padding(top = 18.dp, start = 27.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(20.05.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_quick_order),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(25.dp)
                        .padding(top = 3.52.dp)
                )

                Column {
                    Text(
                        text = "나만의 메뉴를 등록하고\nHome에서 빠르게 주문해\n보세요 ☺️",
                        style = StarbucksTheme.typography.headSemiBold12,
                        color = StarbucksTheme.colors.black
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "음료,푸드만 주문 가능합니다",
                        style = StarbucksTheme.typography.captionRegular12,
                        color = StarbucksTheme.colors.gray600
                    )
                }
            }

            // 구분선
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(StarbucksTheme.colors.gray200)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 하단 원형 버튼
            Icon(
                painter = painterResource(id = R.drawable.btn_add_quick_order),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(26.dp)
                    .clickable { onClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickOrderRegisterItemPreview() {
    StarbucksTheme {
        QuickOrderRegisterItem(
            modifier = Modifier.padding(top = 80.dp)
        )
    }
}

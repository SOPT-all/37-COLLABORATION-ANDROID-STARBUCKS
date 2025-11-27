package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.bottomBorder
import sopt.org.starbucks.core.util.noRippleClickable

@Composable
fun QuickOrderRegisterItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val borderColor = StarbucksTheme.colors.gray200

    Column(
        modifier = modifier
            .width(255.dp)
            .height(144.dp)
            .drawBehind {
                val stroke = Stroke(
                    width = 1.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
                drawRoundRect(
                    color = borderColor,
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx()),
                    style = stroke
                )
            }.clip(RoundedCornerShape(12.dp))
            .background(StarbucksTheme.colors.white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .bottomBorder(1.dp, StarbucksTheme.colors.gray200)
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_quick_order),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "나만의 메뉴를 등록하고\nHome에서 빠르게 주문해\n보세요 ☺️",
                    style = StarbucksTheme.typography.headSemiBold12,
                    color = StarbucksTheme.colors.black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "음료, 푸드만 주문 가능합니다",
                    style = StarbucksTheme.typography.captionRegular12,
                    color = StarbucksTheme.colors.gray600,
                    maxLines = 1
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.btn_add_quick_order),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .weight(1f)
                .size(26.dp)
                .noRippleClickable { onClick() }
        )
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

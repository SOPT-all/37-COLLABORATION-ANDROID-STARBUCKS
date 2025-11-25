package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

data class QuickOrderUiModel(
    val id: Int,
    val title: String,
    val option: String,
    val imageRes: Int
)

// 샘플 데이터 - > 삭제 예정
val sampleQuickOrderList = listOf(
    QuickOrderUiModel(
        id = 1,
        title = "상큼발랄 프레셔",
        option = "ICED | Tall | 바닐라 시럽2 | 로즈마리 없이 | 얼음 적게 | 일반 휘핑 많이 | 핑크 리치 보바 없이",
        imageRes = R.drawable.img_sample_drink
    ),
    QuickOrderUiModel(
        id = 2,
        title = "나의 아메리카노",
        option = "ICED | Tall | 에스프레소 5샷",
        imageRes = R.drawable.img_sample_drink
    )
)

@Composable
fun QuickOrderList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ) {
        items(sampleQuickOrderList) { item ->
            QuickOrderItem(
                item = item
            )
        }

        item {
            QuickOrderRegisterItem()
        }
    }
}

@Composable
fun QuickOrderItem(
    item: QuickOrderUiModel,
    modifier: Modifier = Modifier
) {
    var isFavorite by rememberSaveable { mutableStateOf(true) }

    Box(
        modifier = modifier
            .width(255.dp)
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
                    tint = if (isFavorite) StarbucksTheme.colors.green500
                    else StarbucksTheme.colors.gray400,
                    modifier = Modifier
                        .padding(2.dp)
                        .noRippleClickable { isFavorite = !isFavorite }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(item.imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 2.dp, end = 16.dp)
                ) {
                    Text(
                        text = item.title,
                        style = StarbucksTheme.typography.headSemiBold12,
                        color = StarbucksTheme.colors.black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.option,
                        style = StarbucksTheme.typography.captionRegular12,
                        color = StarbucksTheme.colors.gray600,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(StarbucksTheme.colors.gray200)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 10.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_location),
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

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(44.dp))
                        .background(Color.Black)
                        .padding(horizontal = 9.dp, vertical = 5.dp)
                        .noRippleClickable {}
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

@Preview
@Composable
private fun QuickOrderItemPreview() {
    StarbucksTheme {
        QuickOrderItem(
            item = QuickOrderUiModel(
                id = 1,
                title = "돌체 콜드 브루",
                option = "톨 | 아이스 | 돌체 시럽 추가",
                imageRes = R.drawable.img_sample_drink
            )
        )
    }
}

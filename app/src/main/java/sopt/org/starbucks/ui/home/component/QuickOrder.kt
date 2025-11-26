package sopt.org.starbucks.ui.home.component

import android.R.attr.contentDescription
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
import coil.compose.AsyncImage
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable
import sopt.org.starbucks.data.model.MyHomeMenu

@Composable
fun QuickOrderList(
    list: List<MyHomeMenu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(list) { item ->
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
    item: MyHomeMenu,
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
                    tint = if (isFavorite) {
                        StarbucksTheme.colors.green500
                    } else {
                        StarbucksTheme.colors.gray400
                    },
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
                AsyncImage(
                    model = item.myMenuImage,
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
                        text = item.myMenuName,
                        style = StarbucksTheme.typography.headSemiBold12,
                        color = StarbucksTheme.colors.black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.myMenuOption,
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
            item = MyHomeMenu(
                myMenuId = 1,
                myMenuName = "돌체 콜드 브루",
                myMenuOption = "톨 | 아이스 | 돌체 시럽 추가",
                myMenuImage = ""
            )
        )
    }
}

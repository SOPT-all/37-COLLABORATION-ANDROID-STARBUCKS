package sopt.org.starbucks.ui.home.component

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
import sopt.org.starbucks.core.util.bottomBorder
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

    Column(
        modifier = modifier
            .width(255.dp)
            .height(144.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(StarbucksTheme.colors.gray100)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .bottomBorder(1.dp, StarbucksTheme.colors.gray200)
                .weight(2f)
                .padding(start = 8.dp, end = 16.dp, top = 12.dp, bottom = 10.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                model = item.myMenuImage,
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
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
                        .align(Alignment.End)
                        .noRippleClickable { isFavorite = !isFavorite }
                )

                Text(
                    text = item.myMenuName,
                    style = StarbucksTheme.typography.headSemiBold12,
                    color = StarbucksTheme.colors.black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item.myMenuOption,
                    style = StarbucksTheme.typography.captionRegular12,
                    color = StarbucksTheme.colors.gray600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 14.dp, end = 8.dp),
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
                    .padding(horizontal = 10.dp, vertical = 8.dp)
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

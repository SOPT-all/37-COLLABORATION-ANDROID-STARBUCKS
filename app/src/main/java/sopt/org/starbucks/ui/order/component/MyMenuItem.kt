package sopt.org.starbucks.ui.order.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

@Composable
fun MyMenuItem(
    imgUrl: String,
    title: String,
    menuName: String,
    option: String,
    price: String,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cancel),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End),
            tint = StarbucksTheme.colors.gray200
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            AsyncImage(
                model = imgUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(94.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = StarbucksTheme.typography.headMedium15,
                        color = StarbucksTheme.colors.black
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_pencil),
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp)
                            .noRippleClickable { onEditClick() },
                        tint = StarbucksTheme.colors.gray700
                    )
                }
                Text(
                    text = menuName,
                    style = StarbucksTheme.typography.captionRegular13,
                    color = StarbucksTheme.colors.gray600
                )
                Text(
                    text = option,
                    style = StarbucksTheme.typography.captionRegular13,
                    color = StarbucksTheme.colors.gray600
                )
                Text(
                    text = price,
                    style = StarbucksTheme.typography.headSemiBold14,
                    color = StarbucksTheme.colors.black
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(11.dp),
            modifier = Modifier.align(Alignment.End)
        ) {
            MyMenuItemButton(
                text = "담기",
                textColor = StarbucksTheme.colors.green500,
                backgroundColor = StarbucksTheme.colors.transparent
            )
            MyMenuItemButton(
                text = "주문하기",
                textColor = StarbucksTheme.colors.white,
                backgroundColor = StarbucksTheme.colors.green500
            )
        }
    }
}

@Composable
private fun MyMenuItemButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    borderColor: Color = StarbucksTheme.colors.green500,
    textStyle: TextStyle = StarbucksTheme.typography.captionRegular13
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(44.dp))
            .border(1.dp, borderColor, RoundedCornerShape(44.dp))
            .background(backgroundColor)
            .padding(vertical = 7.dp, horizontal = 12.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            style = textStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyMenuItemPreview() {
    StarbucksTheme {
        MyMenuItem(
            imgUrl = "https://i.pinimg.com/1200x/27/78/0f/27780fc651dff0eb419b06ecf93a3055.jpg",
            title = "상큼발랄 프레셔",
            menuName = "아이스 핑크 팝 캐모마일 릴렉서",
            option = "ICED | Tall",
            price = "6,500원",
            onEditClick = {}
        )
    }
}

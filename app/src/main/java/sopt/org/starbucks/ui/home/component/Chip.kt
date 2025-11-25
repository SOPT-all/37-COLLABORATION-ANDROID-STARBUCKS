package sopt.org.starbucks.ui.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

sealed interface ChipStyle {
    data object White : ChipStyle
    data object GreenOutline : ChipStyle
}

@Composable
fun ChipSection(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_green_star,
                text = "Green",
                trailingText = "2",
                textColor = StarbucksTheme.colors.gray600,
                trailingTextColor = StarbucksTheme.colors.green500,
                showNewTag = true
            )
        }

        item {
            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_coupon,
                text = "Coupon"
            )
        }

        item {
            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_pay2,
                text = "Pay"
            )
        }

        item {
            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_buddy_pass,
                text = "Buddy Pass"
            )
        }
    }
}

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    style: ChipStyle,
    @DrawableRes icon: Int? = null,
    text: String,
    trailingText: String? = null,
    textColor: Color? = null,
    trailingTextColor: Color? = null,
    showNewTag: Boolean = false,
    onClick: () -> Unit = {}
) {
    val shape = RoundedCornerShape(22.dp)

    val (backgroundColor, borderStroke, contentColor) = when (style) {
        ChipStyle.White -> Triple(
            StarbucksTheme.colors.white,
            null,
            StarbucksTheme.colors.gray600
        )

        ChipStyle.GreenOutline -> Triple(
            StarbucksTheme.colors.white,
            BorderStroke(1.dp, StarbucksTheme.colors.greenGradient),
            StarbucksTheme.colors.green400
        )
    }

    val finalTextColor = textColor ?: contentColor
    val finalTrailingTextColor = trailingTextColor ?: contentColor

    Box(
        modifier = modifier
            .noRippleClickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .background(backgroundColor, shape)
                .then(borderStroke?.let { Modifier.border(it, shape) } ?: Modifier)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                icon?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier.size(19.dp)
                    )
                }
                Text(
                    text = text,
                    style = StarbucksTheme.typography.captionRegular14,
                    color = finalTextColor
                )
            }
            trailingText?.let {
                Text(
                    text = it,
                    style = StarbucksTheme.typography.captionRegular14,
                    color = finalTrailingTextColor,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        if (showNewTag) {
            Image(
                painter = painterResource(id = R.drawable.ic_tag_new),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 7.dp, y = (-8).dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 300
)
@Composable
fun ChipPreview() {
    StarbucksTheme {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_tag_new),
                contentDescription = null
            )

            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_green_star,
                text = "Green",
                trailingText = "2",
                showNewTag = true,
                textColor = StarbucksTheme.colors.gray600,
                trailingTextColor = StarbucksTheme.colors.green500
            )

            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_green_star,
                text = "Green",
                trailingText = "2",
                textColor = StarbucksTheme.colors.gray600,
                trailingTextColor = StarbucksTheme.colors.green500
            )

            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_coupon,
                text = "Coupon"
            )

            Chip(
                style = ChipStyle.White,
                icon = R.drawable.ic_pay2,
                text = "Pay"
            )

            Chip(
                style = ChipStyle.GreenOutline,
                icon = R.drawable.ic_buddy_pass,
                text = "Buddy Pass"
            )
        }
    }
}

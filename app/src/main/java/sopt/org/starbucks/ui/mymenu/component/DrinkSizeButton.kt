package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable

enum class DrinkSize(
    val displayName: String,
    val volume: String,
    val iconRes: Int,
    val iconSelectedRes: Int,
    val iconWidth: Int,
) {
    TALL("Tall", "355ml", R.drawable.ic_tall, R.drawable.ic_tall_select, 35),
    GRANDE("Grande", "473ml", R.drawable.ic_grande, R.drawable.ic_grande_select, 43),
    VENTI("Venti", "591ml", R.drawable.ic_venti, R.drawable.ic_venti_select, 49)
}

@Composable
fun DrinkSizeButton(
    drinkSize: DrinkSize,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = if (isSelected) StarbucksTheme.colors.green500 else StarbucksTheme.colors.gray600,
                shape = RoundedCornerShape(size = 8.dp)
            ).background(
                color = StarbucksTheme.colors.white,
                shape = RoundedCornerShape(size = 8.dp)
            ).noRippleClickable(onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 컵 아이콘
            Image(
                painter = painterResource(
                    id = if (isSelected) drinkSize.iconSelectedRes else drinkSize.iconRes
                ),
                contentDescription = drinkSize.displayName,
                modifier = Modifier
                    .width(drinkSize.iconWidth.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 사이즈
            Text(
                text = drinkSize.displayName,
                style = StarbucksTheme.typography.bodySemiBold13,
                color = if (isSelected) StarbucksTheme.colors.black else StarbucksTheme.colors.gray700
            )

            // 용량
            Text(
                text = drinkSize.volume,
                style = StarbucksTheme.typography.captionRegular12,
                color = StarbucksTheme.colors.gray700
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DrinkSizeButtonPreview() {
    StarbucksTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DrinkSizeButton(
                drinkSize = DrinkSize.TALL,
                isSelected = true,
                onClick = { },
                modifier = Modifier.weight(1f)
            )

            DrinkSizeButton(
                drinkSize = DrinkSize.GRANDE,
                isSelected = false,
                onClick = { },
                modifier = Modifier.weight(1f)
            )

            DrinkSizeButton(
                drinkSize = DrinkSize.VENTI,
                isSelected = false,
                onClick = { },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

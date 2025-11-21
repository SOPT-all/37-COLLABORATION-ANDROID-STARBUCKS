package sopt.org.starbucks.ui.order.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.bottomBorder

@Composable
fun StoreSelector(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(StarbucksTheme.colors.gray900)
            .padding(start = 22.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(end = 20.dp)
                .bottomBorder(1.dp, StarbucksTheme.colors.gray800)
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "주문할 매장을 선택해 주세요",
                style = StarbucksTheme.typography.captionRegular14,
                color = StarbucksTheme.colors.white
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = StarbucksTheme.colors.gray100,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_bag),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 14.dp, bottom = 18.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreSelectorPreview() {
    StarbucksTheme {
        StoreSelector()
    }
}

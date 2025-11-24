package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun ProductInfoButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "제품영양정보",
            style = StarbucksTheme.typography.bodyBold16,
            color = StarbucksTheme.colors.black
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = "화살표",
            tint = StarbucksTheme.colors.black,
            modifier = Modifier
                .size(24.dp)
                .graphicsLayer {
                    rotationZ = 90f // Z축을 기준으로 90도 회전
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductInfoButtonPreview() {
    StarbucksTheme {
        ProductInfoButton()
    }
}

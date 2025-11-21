package sopt.org.starbucks.ui.edit.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun EcoFriendlySection(
    isPersonalCupChecked: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = StarbucksTheme.colors.green700A10,
                shape = RoundedCornerShape(size = 10.dp)
            ).padding(vertical = 22.dp, horizontal = 19.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(27.dp)
        ) {
            Text(
                text = "환경을 위해 친환경 캠페인에 동참해 보세요.",
                style = StarbucksTheme.typography.bodySemiBold13,
                color = StarbucksTheme.colors.black
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isPersonalCupChecked) R.drawable.ic_checked else R.drawable.ic_uncheck
                    ),
                    contentDescription = if (isPersonalCupChecked) "체크 O" else "체크 X",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "개인컵 사용하기",
                    style = StarbucksTheme.typography.captionRegular13,
                    color = StarbucksTheme.colors.gray700,
                    textAlign = TextAlign.Center
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.ic_tree),
            contentDescription = "친환경",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(52.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EcoFriendlySectionPreview() {
    StarbucksTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EcoFriendlySection(
                isPersonalCupChecked = false
            )

            EcoFriendlySection(
                isPersonalCupChecked = true
            )
        }
    }
}

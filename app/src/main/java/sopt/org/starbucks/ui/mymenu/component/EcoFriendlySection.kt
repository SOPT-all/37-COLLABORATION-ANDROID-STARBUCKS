package sopt.org.starbucks.ui.edit.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
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
    Box(
        modifier = modifier
            .width(328.dp)
            .height(105.dp)
            .background(
                color = Color(0x1A00653B),
                shape = RoundedCornerShape(size = 10.dp)
            ).padding(start = 19.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            Text(
                text = "환경을 위해 친환경 캠페인에 동참해 보세요.",
                style = StarbucksTheme.typography.bodySemiBold13,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(top = 13.dp, bottom = 10.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 12.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isPersonalCupChecked) R.drawable.ic_checked else R.drawable.ic_uncheck
                    ),
                    contentDescription = if (isPersonalCupChecked) "체크 O" else "체크 X",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

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
            modifier = Modifier
                .width(42.dp)
                .height(46.dp)
                .align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EcoFriendlySectionPreview() {
    StarbucksTheme {
        Column {
            EcoFriendlySection(
                isPersonalCupChecked = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcoFriendlySection(
                isPersonalCupChecked = true
            )
        }
    }
}

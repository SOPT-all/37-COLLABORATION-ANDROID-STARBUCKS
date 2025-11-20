package sopt.org.starbucks.ui.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun PersonalOptionContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "퍼스널 옵션",
                style = StarbucksTheme.typography.bodyBold16,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(end = 10.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_right),
                contentDescription = "ic_right"
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "전체 초기화",
                style = StarbucksTheme.typography.bodyRegular13,
                color = StarbucksTheme.colors.green500,
                modifier = Modifier.padding(end = 3.dp)
            )
        }

        Spacer(modifier = Modifier.height(9.dp))

        OptionTipBox()

        Spacer(modifier = Modifier.height(15.dp))

        OptionContent(
            option = "핑크 리치 보바 없음"
        )

        Spacer(modifier = Modifier.height(9.dp))

        OptionContent(
            option = "로즈마리 많이"
        )

        Spacer(modifier = Modifier.height(9.dp))

        OptionContent(
            option = "일반휘핑 많이",
            price = 800
        )
    }
}

@Composable
private fun OptionTipBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = StarbucksTheme.colors.gray100,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Text(
            text = "TIP 스타벅스 카드로 결제하면 퍼스널 옵션 추가 금액을 할인받을 수 있어요.",
            style = StarbucksTheme.typography.captionRegular11,
            color = StarbucksTheme.colors.gray600,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 13.dp)
        )
    }
}

@Composable
private fun OptionContent(
    option: String,
    modifier: Modifier = Modifier,
    price: Int? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cancel),
            contentDescription = "cancel icon",
            modifier = Modifier.padding(end = 5.dp),
            tint = StarbucksTheme.colors.gray200
        )

        Text(
            text = option,
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.brown
        )

        if (price != null) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "${price}원",
                style = StarbucksTheme.typography.captionRegular13,
                color = StarbucksTheme.colors.brown
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PersonalOptionContentPreview() {
    StarbucksTheme {
        PersonalOptionContent()
    }
}

package sopt.org.starbucks.ui.mymenu

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
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable
import sopt.org.starbucks.data.model.PersonalOption

@Composable
fun PersonalOptionContent(
    optionList: List<PersonalOption>,
    onResetClick: () -> Unit,
    onCancelClick: (PersonalOption) -> Unit,
    modifier: Modifier = Modifier
) {
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

            Row(
                modifier = Modifier.noRippleClickable(onClick = onResetClick),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "전체 초기화",
                    style = StarbucksTheme.typography.bodyRegular13,
                    color = StarbucksTheme.colors.green500,
                    modifier = Modifier.padding(end = 3.dp)
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_reset),
                    contentDescription = "ic_reset",
                    tint = StarbucksTheme.colors.green500
                )
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        OptionTipBox()

        Spacer(modifier = Modifier.height(15.dp))

        optionList.forEachIndexed { index, option ->
            OptionContent(
                option = option,
                onDeleteClick = onCancelClick
            )

            if (index != optionList.lastIndex) {
                Spacer(modifier = Modifier.height(9.dp))
            }
        }
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
    option: PersonalOption,
    onDeleteClick: (PersonalOption) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cancel),
            contentDescription = "cancel icon",
            modifier = Modifier
                .padding(end = 5.dp)
                .noRippleClickable(onClick = { onDeleteClick(option) }),
            tint = StarbucksTheme.colors.gray200
        )

        Text(
            text = option.name,
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.brown
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = if (option.price == 0) "" else "${option.price}원",
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.brown
        )
    }
}

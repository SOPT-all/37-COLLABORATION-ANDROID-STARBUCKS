package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun SelectCupSection(
    modifier: Modifier = Modifier
) {
    Column{
        Text(
            text = "컵 선택",
            style = StarbucksTheme.typography.bodyBold16,
            color = StarbucksTheme.colors.black
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DrinkSizeButton(
                drinkSize = DrinkSize.TALL,
                isSelected = true,
                onClick = { }
            )

            DrinkSizeButton(
                drinkSize = DrinkSize.GRANDE,
                isSelected = false,
                onClick = { }
            )

            DrinkSizeButton(
                drinkSize = DrinkSize.VENTI,
                isSelected = false,
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectCupSectionPreview() {
    StarbucksTheme {
        SelectCupSection()
    }
}

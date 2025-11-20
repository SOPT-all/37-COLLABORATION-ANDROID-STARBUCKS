package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun NoticeBox(
    notices: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = StarbucksTheme.colors.gray200,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(start = 9.dp, top = 13.dp, end = 9.dp, bottom = 13.dp)
    ) {
        notices.forEachIndexed { index, notice ->
            Text(
                text = notice,
                style = StarbucksTheme.typography.captionRegular11,
                color = StarbucksTheme.colors.gray600
            )
            if (index < notices.size - 1) {// 마지막 항목 아니면
                Spacer(
                    modifier = Modifier.padding(top = 3.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeBoxPreview() {
    StarbucksTheme {
        NoticeBox(
            notices = listOf(
                "* 리치 과육의 숙 캡슐이 있을 수 있지만 안심하고 드세요.",
                "* 대체당(츄스티아)을 일부 사용하여 당과 칼로리를 낮췄습니다.",
            ),
        )
    }
}

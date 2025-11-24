package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun DrinkTitleSection(
    koreanTitle: String,
    englishTitle: String,
    description: String,
    isNew: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // 한글 제목 + New 뱃지
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = koreanTitle,
                style = StarbucksTheme.typography.headBold21,
                color = StarbucksTheme.colors.black,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            if (isNew) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "New",
                    style = StarbucksTheme.typography.bodyRegular13,
                    color = StarbucksTheme.colors.green500,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // 영어 제목
        Text(
            text = englishTitle,
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.gray600
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 부가 설명
        Text(
            text = description,
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.gray700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DrinkTitleSectionPreview() {
    StarbucksTheme {
        DrinkTitleSection(
            koreanTitle = "아이스 핑크 팝 캐모마일 릴렉서",
            englishTitle = "Iced Pink Pop Chamomile Relaxer",
            description = "크리스마스에 어울리는 상쾌한 핑크팝과 캐모마일 릴렉서! " +
                "리치, 레몬그라스, 캐모마일의 차분하면서도 새콤달콤한 조합 " +
                "그리스마스 오너먼트가 떠오르는 핑크 리치 보바로 팝! " +
                "터지는 식감의 재미와 리치 풍미를 더했습니다",
            isNew = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

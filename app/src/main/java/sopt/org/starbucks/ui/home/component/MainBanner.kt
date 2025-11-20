package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun MainBanner(
    modifier: Modifier = Modifier,
    line1: String,
    line2: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_banner),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 69.dp, start = 22.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = line1,
                style = StarbucksTheme.typography.headBold21,
                color = StarbucksTheme.colors.black,
            )

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = line2,
                style = StarbucksTheme.typography.headBold21,
                color = StarbucksTheme.colors.black,
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 500
)
@Composable
private fun MainBannerPreview() {
    StarbucksTheme {
        Box(modifier = Modifier.fillMaxSize().padding(0.dp)) {
            MainBanner(
                line1 = "미국에서 온 케이크 팝과",
                line2 = "사탕 같은 시간을 보내요",
            )
        }
    }
}

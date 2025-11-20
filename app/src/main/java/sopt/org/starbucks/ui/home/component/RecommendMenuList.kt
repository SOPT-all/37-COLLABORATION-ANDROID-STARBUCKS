package sopt.org.starbucks.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.ui.home.model.RecommendMenuData

@Composable
fun RecommendMenuList(
    modifier: Modifier = Modifier
) {
    val menus = RecommendMenuData.menuList
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = menus,
            key = { it.id }
        ) { menu ->
            RecommendMenuItem(
                menuImage = menu.image,
                menuTitle = menu.name
            )
        }
    }
}

@Composable
private fun RecommendMenuItem(
    menuImage: Int,
    menuTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(122.dp)
            .padding(top = 10.dp, bottom = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(menuImage),
            contentDescription = "menu Image",
            modifier = Modifier.size(122.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = menuTitle,
            style = StarbucksTheme.typography.captionRegular13,
            color = StarbucksTheme.colors.gray900,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecommendMenuListPreview() {
    StarbucksTheme {
        RecommendMenuList()
    }

}

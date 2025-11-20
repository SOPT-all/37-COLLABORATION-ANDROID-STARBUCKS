package sopt.org.starbucks.ui.order

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun OrderRoute(
    paddingValues: PaddingValues,
    navigateToMyMenu: () -> Unit
) {
    OrderScreen(modifier = Modifier.padding(paddingValues))
}

@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
private fun OrderScreenPreview() {
    StarbucksTheme {
        OrderScreen()
    }
}

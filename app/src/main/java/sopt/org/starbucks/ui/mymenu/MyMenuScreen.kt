package sopt.org.starbucks.ui.mymenu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyMenuRoute(paddingValues: PaddingValues) {
    MyMenuScreen(
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
    )
}

@Composable
fun MyMenuScreen(modifier: Modifier = Modifier) {
}

package sopt.org.starbucks.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(navigator: MainNavigator = rememberMainNavigator()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            MainNavHost(
                navigator = navigator,
                paddingValues = paddingValues
            )
        },
        bottomBar = {
            MainBottomBar(
                visible = navigator.shouldShowBottomBar(),
                tabs = MainTab.entries,
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) }
            )
        }
    )
}

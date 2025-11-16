package sopt.org.starbucks.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme

@Composable
fun MainBottomBar(
    visible: Boolean,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    tabs: List<MainTab>,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visible
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            tabs.forEach { tab ->
                MainBottomBarItem(
                    tab = tab,
                    selected = tab == currentTab,
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    tab: MainTab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(StarbucksTheme.colors.gray100)
            .padding(top = 10.dp)
            .navigationBarsPadding()
            .align(Alignment.CenterVertically)
            .weight(1f)
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = tab.iconResId),
            contentDescription = stringResource(tab.label),
            tint = if (selected) tab.selectedColor else tab.defaultColor,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = stringResource(id = tab.label),
            color = if (selected) tab.selectedColor else tab.defaultColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainBottomBarPreview() {
    StarbucksTheme {
        MainBottomBar(
            visible = true,
            currentTab = MainTab.HOME,
            onTabSelected = {},
            tabs = MainTab.entries
        )
    }
}

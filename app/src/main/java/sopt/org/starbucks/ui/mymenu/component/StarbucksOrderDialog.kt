package sopt.org.starbucks.ui.mymenu.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import sopt.org.starbucks.core.designsystem.theme.StarbucksTheme
import sopt.org.starbucks.core.util.noRippleClickable
import sopt.org.starbucks.ui.mymenu.DialogType

@Composable
fun StarbucksOrderDialog(
    onDismissRequest: () -> Unit,
    dialogType: DialogType,
    content: String,
    onConfirmClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            color = StarbucksTheme.colors.white,
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Text(
                    text = dialogType.title,
                    style = StarbucksTheme.typography.headBold17,
                    color = StarbucksTheme.colors.black,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = content,
                    style = StarbucksTheme.typography.bodyRegular15,
                    color = StarbucksTheme.colors.gray600,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = StarbucksTheme.colors.gray100
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    DialogButton(
                        title = "취소",
                        titleColor = StarbucksTheme.colors.gray600,
                        onClick = onCancelClick,
                        modifier = Modifier.weight(1f)
                    )

                    VerticalDivider(
                        thickness = 1.dp,
                        color = StarbucksTheme.colors.gray100
                    )

                    DialogButton(
                        title = dialogType.label,
                        titleColor = StarbucksTheme.colors.green700,
                        onClick = { onConfirmClick() },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogButton(
    title: String,
    titleColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .noRippleClickable(onClick = onClick)
            .padding(vertical = 19.dp)
    ) {
        Text(
            text = title,
            style = StarbucksTheme.typography.bodyMedium16,
            color = titleColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


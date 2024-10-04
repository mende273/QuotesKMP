package mende273.quoteskmp.component.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.quoteskmp.ui.common.component.BackButton
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.component.TopBarMenuItem
import mende273.quoteskmp.ui.common.menu.MenuItem
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_favourite
import quoteskmp.composeapp.generated.resources.action_random
import quoteskmp.composeapp.generated.resources.baseline_favorite_border_24
import quoteskmp.composeapp.generated.resources.baseline_random

@Preview
@Composable
private fun TopBarWithMenuItemPreview() {
    TopBar(
        title = "Home",
        menuItem = MenuItem(
            Res.string.action_random,
            Res.drawable.baseline_random
        )
    )
}

@Preview
@Composable
private fun TopBarWithBackButtonAndMenuItemPreview() {
    TopBar(
        title = "Home",
        menuItem = MenuItem(
            Res.string.action_random,
            Res.drawable.baseline_random
        ),
        isBackButtonEnabled = true
    )
}

@Preview
@Composable
private fun TopBarWithBackButtonPreview() {
    TopBar(
        title = "Home",
        isBackButtonEnabled = true
    )
}


@Preview
@Composable
private fun BackButtonPreview() {
    BackButton(onBackPressed = {})
}


@Preview
@Composable
private fun MenuItemPreview() {
    TopBarMenuItem(
        menuItem = MenuItem(
            Res.string.action_favourite,
            Res.drawable.baseline_favorite_border_24
        )
    )
}
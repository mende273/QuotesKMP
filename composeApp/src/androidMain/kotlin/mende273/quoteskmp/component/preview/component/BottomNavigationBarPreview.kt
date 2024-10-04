package mende273.quoteskmp.component.preview.component

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.quoteskmp.ui.common.component.bottombar.BottomNavigationItem
import mende273.quoteskmp.navigation.Screen
import mende273.quoteskmp.ui.common.component.bottombar.BottomNavigationBar

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        currentScreen = Screen.Home,
        bottomNavigationItems = enumValues<BottomNavigationItem>(),
        onNavigateToScreen = {}
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BottomNavigationBarDarkPreview() {
    BottomNavigationBar(
        currentScreen = Screen.Home,
        bottomNavigationItems = enumValues<BottomNavigationItem>(),
        onNavigateToScreen = {}
    )
}

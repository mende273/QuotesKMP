package mende273.quoteskmp.ui.common.component.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mende273.quoteskmp.navigation.Screen
import mende273.quoteskmp.ui.theme.MediumDarkGreyColor
import mende273.quoteskmp.ui.theme.NavigationBarBackgroundColor
import mende273.quoteskmp.ui.theme.NavigationBarItemRippleColor
import mende273.quoteskmp.ui.theme.NavigationBarSelectedColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomNavigationBar(
    currentScreen: Screen?,
    bottomNavigationItems: Array<BottomNavigationItem>,
    onNavigateToScreen: (Screen) -> Unit
) {
    NavigationBar(
        modifier = Modifier,
        contentColor = NavigationBarItemRippleColor,
        tonalElevation = 0.dp,
        containerColor = NavigationBarBackgroundColor,
        content = {
            bottomNavigationItems.forEach { screen ->
                NavigationBarItem(
                    selected = currentScreen == screen.route,
                    onClick = { onNavigateToScreen(screen.route) },
                    label = { Text(text = stringResource(screen.resourceId)) },
                    enabled = true,
                    icon = {
                        Icon(
                            painter = painterResource(screen.icon),
                            contentDescription = ""
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = NavigationBarSelectedColor,
                        unselectedIconColor = MediumDarkGreyColor,
                        selectedTextColor = NavigationBarSelectedColor,
                        unselectedTextColor = MediumDarkGreyColor,
                        indicatorColor = NavigationBarBackgroundColor
                    )
                )
            }
        }
    )
}

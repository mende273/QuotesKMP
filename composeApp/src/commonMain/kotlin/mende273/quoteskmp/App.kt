package mende273.quoteskmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import mende273.quoteskmp.navigation.AppNavigation
import mende273.quoteskmp.navigation.Screen
import mende273.quoteskmp.ui.common.component.bottombar.BottomNavigationBar
import mende273.quoteskmp.ui.common.component.bottombar.BottomNavigationItem
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext


@Composable
@Preview
fun App() {
    KoinContext {

        val navController = rememberNavController()

        val bottomNavigationItems = enumValues<BottomNavigationItem>()

        var isNavigationBarVisible by remember { mutableStateOf(false) }

        val currentNavigationBarDestination = navController
            .currentBackStackEntryAsState()
            .value
            .currentDestinationFromNavigationBar(
                enumValues<BottomNavigationItem>()
                    .map { it.route }
            )

        isNavigationBarVisible = currentNavigationBarDestination != null

        QuotesKmpTheme {
            Scaffold(
                content = {
                    AppNavigation(
                        navHostController = navController
                    )
                },
                bottomBar = {
                    AnimatedVisibility(
                        visible = isNavigationBarVisible,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        BottomNavigationBar(
                            currentNavigationBarDestination,
                            bottomNavigationItems,
                            onNavigateToScreen = { navController.singleTopNavigate(it) }
                        )
                    }
                }
            )
        }
    }
}

private fun NavBackStackEntry?.currentDestinationFromNavigationBar(
    navigationBarItems: List<Screen>
): Screen? {
    var currentDestination: Screen? = null

    navigationBarItems.forEach { item ->
        if (this?.destination?.hierarchy?.any {
                it.hasRoute(item::class)
            } == true
        ) {
            currentDestination = item
        }
    }

    return currentDestination
}

private fun NavHostController.singleTopNavigate(screen: Screen) {
    navigate(screen) {
        launchSingleTop = true
        restoreState = true
    }
}

package mende273.quoteskmp.ui.common.component.bottombar

import mende273.quoteskmp.navigation.Screen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.baseline_favorite_24
import quoteskmp.composeapp.generated.resources.baseline_home_24
import quoteskmp.composeapp.generated.resources.baseline_today_24
import quoteskmp.composeapp.generated.resources.screen_favourites
import quoteskmp.composeapp.generated.resources.screen_home
import quoteskmp.composeapp.generated.resources.screen_quote_today

enum class BottomNavigationItem(
    val route: Screen,
    val resourceId: StringResource,
    val icon: DrawableResource
) {
    HOME(Screen.Home, Res.string.screen_home, Res.drawable.baseline_home_24),
    QUOTE_OF_THE_DAY(
        Screen.QuoteOfTheDay,
        Res.string.screen_quote_today,
        Res.drawable.baseline_today_24
    ),
    FAVORITES(
        Screen.Favourites,
        Res.string.screen_favourites,
        Res.drawable.baseline_favorite_24
    )
}

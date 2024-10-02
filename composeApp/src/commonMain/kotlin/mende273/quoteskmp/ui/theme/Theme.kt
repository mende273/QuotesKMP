package mende273.quoteskmp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorScheme = darkColorScheme(
    primary = BlackColor,
    secondary = GreyColor,
    tertiary = TertiaryColorDarkTheme,
    background = BlackColor
)

private val lightColorScheme = lightColorScheme(
    primary = GreyColor,
    secondary = BlackColor,
    tertiary = TertiaryColorLightTheme,
    background = GreyColor
)

val TertiaryColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) TertiaryColorLightTheme else TertiaryColorDarkTheme

val PrimaryTextColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) BlackColor else GreyColor

val PrimaryBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) GreyColor else BlackColor

val NavigationBarBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) WhiteColor else DarkGreyColor

val NavigationBarSelectedColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) BlackColor else WhiteColor

val NavigationBarItemRippleColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) {
        NavigationItemRippleColorLightTheme
    } else {
        NavigationItemRippleColorDarkTheme
    }

@Composable
fun QuotesKmpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

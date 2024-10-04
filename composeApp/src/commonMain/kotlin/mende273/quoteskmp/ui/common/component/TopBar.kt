package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mende273.quoteskmp.ui.common.menu.MenuItem
import mende273.quoteskmp.ui.theme.PrimaryBackgroundColor
import mende273.quoteskmp.ui.theme.PrimaryTextColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String = "",
    menuItem: MenuItem? = null,
    isBackButtonEnabled: Boolean = false,
    onMenuItemClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.background(PrimaryBackgroundColor),
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PrimaryBackgroundColor,
            scrolledContainerColor = PrimaryBackgroundColor,
            navigationIconContentColor = PrimaryTextColor,
            titleContentColor = PrimaryTextColor,
            actionIconContentColor = PrimaryTextColor
        ),
        actions = {
            menuItem?.let {
                TopBarMenuItem(menuItem = menuItem, onMenuItemClick = onMenuItemClick)
            }
        },
        navigationIcon = {
            if (isBackButtonEnabled) {
                BackButton(onBackPressed = onNavigateBack)
            }
        }
    )
}

@Composable
fun BackButton(onBackPressed: () -> Unit) {
    IconButton(onClick = onBackPressed) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
    }
}

@Composable
fun TopBarMenuItem(
    menuItem: MenuItem,
    onMenuItemClick: () -> Unit = {}
) {
    IconButton(onClick = onMenuItemClick) {
        Icon(
            painter = painterResource(menuItem.icon),
            contentDescription = stringResource(menuItem.titleText),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

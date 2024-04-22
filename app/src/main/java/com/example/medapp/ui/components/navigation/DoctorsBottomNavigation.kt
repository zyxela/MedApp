package com.example.medapp.ui.components.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.medapp.navigation.Screen
import com.example.medapp.ui.theme.Lime500


@Composable
fun DoctorsBottomNavigation(navController: NavController) {

    val bottomItems = listOf(
        Screen.Visits,
        Screen.DoctorsProfile
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = item.icon!!),
                        contentDescription = null
                    )
                },
                selectedContentColor = Lime500,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)

                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DoctorsBottomNavigationPreview() {
    DoctorsBottomNavigation(rememberNavController())
}
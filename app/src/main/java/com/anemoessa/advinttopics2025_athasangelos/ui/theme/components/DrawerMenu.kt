package com.anemoessa.advinttopics2025_athasangelos.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.HdrAuto
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anemoessa.advinttopics2025_athasangelos.CalculatorUI
import com.anemoessa.advinttopics2025_athasangelos.HomeScreen
import com.anemoessa.advinttopics2025_athasangelos.R
import kotlinx.coroutines.launch

@Preview(showBackground = true)//PREVIEW
@Composable
fun DrawerPreviewDraft(){

    //PREVIEW USAGE ONLY FOR THE LIST (Copy-paste ModalDrawerSheet form DrawerMenuContent and comment
    // onClick events)

    ModalDrawerSheet {
        DrawerHeader()
        HorizontalDivider()

        DrawerItem(
            icon = Icons.Filled.Home,
            text = "Home Screen",
            onClick = { /*navigateAndCloseDrawer("home")*/ }
        )
        HorizontalDivider()

        DrawerItem(
            icon = Icons.Filled.Calculate,
            text = "Calculator",
            onClick = {/* navigateAndCloseDrawer("calculator")*/ }
        )
        HorizontalDivider()
    }

    //PREVIEW USAGE FOR THE ITEM

    //DrawerItem(Icons.Filled.HdrAuto, "Drawer Item", {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigationDrawer(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenuContent(navController, drawerState)
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("LMAO") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { HomeScreen() }
                    composable("calculator") { CalculatorUI() }
                }
            }
        }
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.pfp), // <- Put a real image here
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Pliroforiako Systima",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Sto opoio den exo idea ti thema tha valo",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DrawerMenuContent(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    fun navigateAndCloseDrawer(destination: String) {
        scope.launch {
            navController.navigate(destination)
            drawerState.close()
        }
    }

    ModalDrawerSheet {
        DrawerHeader()  // Drawer Header

        HorizontalDivider()  // Divider between sections

        DrawerItem(
            icon = Icons.Filled.Home,
            text = "Home Screen",
            onClick = { navigateAndCloseDrawer("home") }
        )

        HorizontalDivider()  // Another Divider

        DrawerItem(
            icon = Icons.Filled.Calculate,
            text = "Calculator",
            onClick = { navigateAndCloseDrawer("calculator")}
        )

        HorizontalDivider()  // Another Divider
    }
}

@Composable
fun DrawerItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // make it span the drawer width
            .clickable(onClick = onClick)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}


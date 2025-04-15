package com.anemoessa.advinttopics2025_athasangelos.components

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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.material3.TopAppBarDefaults
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
import com.anemoessa.advinttopics2025_athasangelos.HomeScreen
import com.anemoessa.advinttopics2025_athasangelos.R
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme
import kotlinx.coroutines.launch

@Preview(showBackground = true)//PREVIEW
@Composable
fun DrawerPreviewDraft() {
    ADVINTTOPICS2025_athasangelosTheme(darkTheme = true){
        //PREVIEW USAGE ONLY FOR THE LIST (Copy-paste ModalDrawerSheet from DrawerMenuContent and comment
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
                icon = Icons.Filled.Person,
                text = "Users",
                onClick = {/* navigateAndCloseDrawer("users")*/ }
            )
            HorizontalDivider()
            DrawerItem(
                icon = Icons.Filled.Book,
                text = "Books",
                onClick = {/* navigateAndCloseDrawer("books")*/ }
            )
            HorizontalDivider()
            DrawerItem(
                icon = Icons.Filled.MenuBook,
                text = "Book Loans",
                onClick = {/* navigateAndCloseDrawer("loans")*/ }
            )
            HorizontalDivider()
        }

        //PREVIEW USAGE FOR THE ITEM

        //DrawerItem(Icons.Filled.HdrAuto, "Drawer Item", {})
    }
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
                    title = { Text("ANEMOESSA") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White,    // Title text color
                        navigationIconContentColor = Color.White, // Menu icon color
                        actionIconContentColor = Color.White)
                    )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { HomeScreen() }
                    composable("users") { UsersTab() }
                    composable("books") { HomeScreen() }
                    composable("loans") { HomeScreen() }
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
                    text = "Anemoessa",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Borrow a Book",
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
        DrawerHeader()
        HorizontalDivider()

        DrawerItem(
            icon = Icons.Filled.Home,
            text = "Home Screen",
            onClick = { navigateAndCloseDrawer("home")}
        )
        HorizontalDivider()

        DrawerItem(
            icon = Icons.Filled.Person,
            text = "Users",
            onClick = {navigateAndCloseDrawer("users")}
        )
        HorizontalDivider()
        DrawerItem(
            icon = Icons.Filled.Book,
            text = "Books",
            onClick = {navigateAndCloseDrawer("books")}
        )
        HorizontalDivider()
        DrawerItem(
            icon = Icons.Filled.MenuBook,
            text = "Book Loans",
            onClick = {navigateAndCloseDrawer("loans")}
        )
        HorizontalDivider()
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


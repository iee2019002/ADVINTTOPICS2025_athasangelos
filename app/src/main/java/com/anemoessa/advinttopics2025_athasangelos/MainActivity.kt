package com.anemoessa.advinttopics2025_athasangelos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.extended.*
import androidx.compose.material3.Button
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() { //RUNNABLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingPreview()
            val navController = rememberNavController()
            MyAppNavHost(navController)
        }
    }
}

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            //HomeScreen(navController)
        }
        composable("calculator") {
            //DestinationScreen()
        }
    }
}

@Preview(showBackground = true)//PREVIEW
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    MyNavigationDrawer(navController)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigationDrawer(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader() // Add your header here
                HorizontalDivider()
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            // This will navigate to another screen
                            navController.navigate("calculator")
                        }
                        //.then(Modifier.ripple()),
                ){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Home Icon
                        IconButton(onClick = {
                            navController.navigate("home")
                        }) {
                            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                        }

                        // Spacer between icon and text
                        Spacer(modifier = Modifier.width(8.dp))

                        // Text for Home Screen
                        Text(
                            text = "Home Screen",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                HorizontalDivider()
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            // This will navigate to another screen
                            navController.navigate("home")
                        }
                    //.then(Modifier.ripple()),
                ){Row(verticalAlignment = Alignment.CenterVertically) {
                    // Home Icon
                    IconButton(onClick = {
                        navController.navigate("calculator")
                    }) {
                        Icon(imageVector = Icons.Filled.Calculate, contentDescription = "Calc")
                    }

                    // Spacer between icon and text
                    Spacer(modifier = Modifier.width(8.dp))

                    // Text for Home Screen
                    Text(
                        text = "Calculator",
                        modifier = Modifier.padding(8.dp)
                    )
                }}
                HorizontalDivider()
            }
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
                Text("Main Content Goes Here", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun CalculatorUI() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = num1,
                onValueChange = { num1 = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                //label = { Text("Number 1") },
                modifier = Modifier.width(100.dp)
            )
            Text(
                text = "+",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = num2,
                onValueChange = { num2 = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                //label = { Text("Number 2") },
                modifier = Modifier.width(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val sum = (num1.toIntOrNull() ?: 0) + (num2.toIntOrNull() ?: 0)
            result = sum.toString()
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $result", fontSize = 20.sp)
    }
}
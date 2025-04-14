package com.anemoessa.advinttopics2025_athasangelos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.anemoessa.advinttopics2025_athasangelos.components.MyNavigationDrawer
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme

class MainActivity : ComponentActivity() { //RUNNABLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ADVINTTOPICS2025_athasangelosTheme {
                AppPreview()
            }
        }
    }
}

@Preview(showBackground = true)//PREVIEW
@Composable
fun AppPreview() {
    ADVINTTOPICS2025_athasangelosTheme (darkTheme = true) {
        val navController = rememberNavController()
        MyNavigationDrawer(navController)
    }
}


@Composable
fun HomeScreen(){

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


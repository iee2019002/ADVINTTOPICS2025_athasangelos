package com.anemoessa.advinttopics2025_athasangelos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anemoessa.advinttopics2025_athasangelos.R
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme

@Preview(showBackground = true)//PREVIEW
@Composable
fun DraftPreview() {
    ADVINTTOPICS2025_athasangelosTheme{
        UsersTab()
    }
}

@Composable
fun UsersTab() {
    Box(modifier = Modifier.fillMaxSize()) {
        UsersQuery()

        FloatingActionButton(
            onClick = { /* TODO: Trigger Add User Dialog or Navigation */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add User",
                tint = Color.White
            )
        }
    }
}


@Composable
fun UsersQuery() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        UserRow("2019001", "John Doe", "Student", R.drawable.pfp)
        UserRow("2019002", "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow("2019003", "Jane Smith", "Professor", null)
        UserRow("2019004", "Mike Johnson", "Professor", null)
        UserRow("2019001", "John Doe", "Student", R.drawable.pfp)
        UserRow("2019002", "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow("2019003", "Jane Smith", "Professor", null)
        UserRow("2019004", "Mike Johnson", "Professor", null)
        UserRow("2019001", "John Doe", "Student", R.drawable.pfp)
        UserRow("2019002", "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow("2019003", "Jane Smith", "Professor", null)
        UserRow("2019004", "Mike Johnson", "Professor", null)
        UserRow("2019001", "John Doe", "Student", R.drawable.pfp)
        UserRow("2019002", "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow("2019003", "Jane Smith", "Professor", null)
        UserRow("2019004", "Mike Johnson", "Professor", null)
        // Add as many users as needed
    }
}

@Composable
fun UserRow(
    userId: String,
    userName: String,
    userType: String,
    profileImageRes: Int? = null // Pass drawable resource ID here
) {
    val imagePainter = if (profileImageRes != null) {
        painterResource(id = profileImageRes) // Use painterResource for local images
    } else {
        painterResource(id = R.drawable.blank_pfp) // Default image when no photo is provided
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(text = userName, style = MaterialTheme.typography.titleMedium)
            Text(text = "ID: $userId", style = MaterialTheme.typography.bodySmall)
            Text(text = userType, style = MaterialTheme.typography.bodySmall)
        }
    }
}
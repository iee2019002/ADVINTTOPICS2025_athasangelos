package com.anemoessa.advinttopics2025_athasangelos.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anemoessa.advinttopics2025_athasangelos.R
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme

@Preview(showBackground = true)//PREVIEW
@Composable
fun DraftPreview() {
    ADVINTTOPICS2025_athasangelosTheme /*(darkTheme = true)*/{
        //UserRow(2019002, "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        //UsersQuery()
        UsersTab()
    }
}

@Composable
fun UsersTab() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action later */ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add User")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            UsersQueryNoDB()
        }
    }
}


@Composable
fun UsersQueryNoDB() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        UserRow(2019002, "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow(2019003, "Παπαδόπουλος Νίκος", "Καθηγητής", R.drawable.pfp)
        UserRow(2019004, "Ελένη Μαρκοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019005, "Γιώργος Αντωνίου", "Φοιτητής", R.drawable.pfp)
        UserRow(2019006, "Μαρία Παναγιωτοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019002, "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow(2019003, "Παπαδόπουλος Νίκος", "Καθηγητής", R.drawable.pfp)
        UserRow(2019004, "Ελένη Μαρκοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019005, "Γιώργος Αντωνίου", "Φοιτητής", R.drawable.pfp)
        UserRow(2019006, "Μαρία Παναγιωτοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019002, "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow(2019003, "Παπαδόπουλος Νίκος", "Καθηγητής", R.drawable.pfp)
        UserRow(2019004, "Ελένη Μαρκοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019005, "Γιώργος Αντωνίου", "Φοιτητής", R.drawable.pfp)
        UserRow(2019006, "Μαρία Παναγιωτοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019002, "Αθανασίου Άγγελος", "Φοιτητής", R.drawable.pfp)
        UserRow(2019003, "Παπαδόπουλος Νίκος", "Καθηγητής", R.drawable.pfp)
        UserRow(2019004, "Ελένη Μαρκοπούλου", "Γραμματεία", R.drawable.pfp)
        UserRow(2019005, "Γιώργος Αντωνίου", "Φοιτητής", R.drawable.pfp)
        UserRow(2019006, "Μαρία Παναγιωτοπούλου", "Γραμματεία", R.drawable.pfp)
    }
}


@Composable
fun UserRow(uid: Int, username: String, usertype: String, picdir: Int?) {
    val imageRes = picdir ?: R.drawable.blank_pfp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = username,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "ID: $uid",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = usertype,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}




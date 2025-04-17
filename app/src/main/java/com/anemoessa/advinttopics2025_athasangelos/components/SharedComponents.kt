package com.anemoessa.advinttopics2025_athasangelos.components

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.anemoessa.advinttopics2025_athasangelos.R
import com.anemoessa.advinttopics2025_athasangelos.roomdb.RDB
import com.anemoessa.advinttopics2025_athasangelos.roomdb.User
import com.anemoessa.advinttopics2025_athasangelos.roomdb.UserDao
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    val context = LocalContext.current

    val db = remember {
        Room.databaseBuilder(
            context.applicationContext,
            RDB::class.java,
            "rdb_database"
        ).build()
    }

    var users by remember { mutableStateOf<List<User>>(emptyList()) }

    fun refreshUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val updatedUsers = db.userDao().getAllUsers() // Get all users again
            withContext(Dispatchers.Main) {
                users = updatedUsers // Update the users list
            }
        }
    }

    LaunchedEffect(Unit) {
        refreshUsers() // Load the initial list of users
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                /* Add action later */
                    CoroutineScope(Dispatchers.IO).launch {
                        db.userDao().insertUser(User(
                            id = 2019001,
                            name = "I tritogkomena kai antio",
                            role = "Student",
                            profilePicResId = R.drawable.pfp)
                        )

                        db.userDao().deleteAllUsers()

                        refreshUsers()

                    }
                },
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
            //UsersQueryNoDB()
            UsersQuery(users)
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
fun UsersQuery(users: List<User>) {

    val context = LocalContext.current

    val db = remember {
        Room.databaseBuilder(
            context.applicationContext,
            RDB::class.java,
            "rdb_database"
        ).build()
    }

    //var users by remember { mutableStateOf(listOf<User>()) }



    // Scrollable view
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        if (users.isEmpty()){
            Text(
                text = "You haven't added any user. Click '+' to add a user",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(), // Make sure it occupies the full width
                textAlign = TextAlign.Center // Corrected alignment parameter
            )

        }
        users.forEach { user ->
            UserRow(
                user.id,
                user.name,
                user.role,
                R.drawable.pfp // Or user.pfp if dynamic
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    // Example: perform DB operations here (must be in coroutine)
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




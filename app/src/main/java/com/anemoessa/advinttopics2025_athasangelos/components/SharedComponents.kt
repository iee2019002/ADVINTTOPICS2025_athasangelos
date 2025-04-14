package com.anemoessa.advinttopics2025_athasangelos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.rememberAsyncImagePainter
import com.anemoessa.advinttopics2025_athasangelos.R
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme

@Preview(showBackground = true)//PREVIEW
@Composable
fun DraftPreview() {
    ADVINTTOPICS2025_athasangelosTheme () {
        UserRow("2019002", "Αθανασίου Άγγελος", "Φοιτητής")
    }
}

@Composable
fun UserRow(
    userId: String,
    userName: String,
    userType: String, // "Student" or "Professor"
    profileImageUrl: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val imagePainter = if (profileImageUrl.isNullOrBlank()) {
            painterResource(id = R.drawable.blank_pfp) // Replace with your default icon
        } else {
            rememberAsyncImagePainter(profileImageUrl)
        }

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


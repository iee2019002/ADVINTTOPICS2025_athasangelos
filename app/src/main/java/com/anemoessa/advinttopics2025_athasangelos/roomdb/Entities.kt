package com.anemoessa.advinttopics2025_athasangelos.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val role: String,
    val profilePicResId: Int
)
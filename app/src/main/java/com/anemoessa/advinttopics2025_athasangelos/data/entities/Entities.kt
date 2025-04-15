package com.anemoessa.advinttopics2025_athasangelos.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val userId: Int,
    val name: String,
    val type: String, // e.g., "Student" or "Professor"
    val profileImageRes: Int? = null
)

@Entity(tableName = "my_entity")
data class MyEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String
)
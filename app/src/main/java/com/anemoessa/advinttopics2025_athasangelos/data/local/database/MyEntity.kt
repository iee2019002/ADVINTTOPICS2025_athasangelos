package com.anemoessa.advinttopics2025_athasangelos.data.local.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_entity")
data class MyEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String
)

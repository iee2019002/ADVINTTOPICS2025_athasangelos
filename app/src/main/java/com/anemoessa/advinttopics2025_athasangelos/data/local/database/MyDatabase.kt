package com.anemoessa.advinttopics2025_athasangelos.data.local.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.anemoessa.advinttopics2025_athasangelos.data.local.database.MyEntity

@Database(entities = [MyEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao
}

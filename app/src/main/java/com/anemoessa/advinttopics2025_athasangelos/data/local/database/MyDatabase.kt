package com.anemoessa.advinttopics2025_athasangelos.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anemoessa.advinttopics2025_athasangelos.data.local.dao.UsersDao
import com.anemoessa.advinttopics2025_athasangelos.data.local.entities.User

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}

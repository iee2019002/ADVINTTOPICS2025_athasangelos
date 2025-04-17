package com.anemoessa.advinttopics2025_athasangelos.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class RDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var INSTANCE: RDB? = null

        fun getInstance(context: Context): RDB {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RDB::class.java,
                    "rdb_database"
                )
                    .createFromAsset("database/user_database.db") // Optional if you have a pre-populated db
                    .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
        }
    }
}

package com.anemoessa.advinttopics2025_athasangelos.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anemoessa.advinttopics2025_athasangelos.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>

    @Query("DELETE FROM users WHERE userId = :id")
    suspend fun deleteUserById(id: Int)
}
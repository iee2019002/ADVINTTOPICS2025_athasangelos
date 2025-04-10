package com.anemoessa.advinttopics2025_athasangelos.data.local.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.anemoessa.advinttopics2025_athasangelos.data.local.database.MyEntity

@Dao
interface MyDao {

    // Insert a new entity
    @Insert
    suspend fun insertEntity(myEntity: MyEntity)

    // Query to get all entities
    @Query("SELECT * FROM my_entity")
    suspend fun getAllEntities(): List<MyEntity>

    // Query to delete an entity
    @Query("DELETE FROM my_entity WHERE id = :id")
    suspend fun deleteEntityById(id: Long)
}


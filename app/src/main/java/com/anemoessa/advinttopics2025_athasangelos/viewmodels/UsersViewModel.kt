package com.anemoessa.advinttopics2025_athasangelos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anemoessa.advinttopics2025_athasangelos.data.dao.UsersDao
import com.anemoessa.advinttopics2025_athasangelos.data.entities.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UsersViewModel(private val dao: UsersDao) : ViewModel() {
    val users: StateFlow<List<User>> = dao.getAllUsers().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )

    fun addUser(user: User) = viewModelScope.launch {
        dao.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        dao.deleteUserById(user.userId)
    }
}
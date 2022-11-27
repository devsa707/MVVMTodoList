package com.example.tutorial.mvvmtodolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title: String,
    val description: String?,
    val idDone: Boolean,
    @PrimaryKey val id: Int? = null
)

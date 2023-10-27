package com.example.mvvmretrofitroomhiltdatabinding.modal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university_table")
data class University(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val alpha_two_code: String,
    val country: String,
    val domains : List<String>,
    val name: String,
    val web_pages : List<String>
)

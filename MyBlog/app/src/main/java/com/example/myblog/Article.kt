package com.example.myblog

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.RTRIM
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val body: String,
    @ColumnInfo(name = "author", typeAffinity = TEXT,  true, collate = RTRIM)
    val username: String,
    val date: Date
)
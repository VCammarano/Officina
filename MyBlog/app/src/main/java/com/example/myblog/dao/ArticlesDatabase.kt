package com.example.myblog.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myblog.Article
import com.example.myblog.dao.ArticleDao

@Database(version = 1, entities = [Article::class])
abstract class ArticlesDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao
}
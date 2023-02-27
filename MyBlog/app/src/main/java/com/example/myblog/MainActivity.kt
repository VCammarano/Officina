package com.example.myblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.myblog.dao.ArticlesDatabase

interface DbProvider {
    fun getDatabase(): ArticlesDatabase
}

class MainActivity : AppCompatActivity(), DbProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        override fun getDatabase(): ArticlesDatabase = Room.databaseBuilder(
            applicationContext,
            ArticlesDatabase::class.java,
            "articles-db"
        ).build()

}
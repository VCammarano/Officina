package com.example.officina.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.officina.entities.Auto
import com.example.officina.entities.Cliente
import com.example.officina.entities.Intervento
import com.example.officina.gestori.GestoreOfficina

@Database(
    entities = [Cliente::class, Auto::class, Intervento::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun autoDao(): AutoDao
    abstract fun interventoDao(): InterventoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val db = AppDatabase.getDatabase(context)
                val gestore = GestoreOfficina(db)
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
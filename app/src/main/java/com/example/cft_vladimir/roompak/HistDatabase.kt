package com.example.cft_vladimir.roompak

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Hist::class], version = 1, exportSchema = false)
abstract class HistDatabase : RoomDatabase() {
    abstract fun HistDao() : HistDao

    companion object {
        private var INSTANCE : HistDatabase ? = null

        fun getInstance(context: Context) : HistDatabase ? {
            if(INSTANCE == null)
            {
                synchronized(HistDatabase::class)
                {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        HistDatabase::class.java,
                        "hist.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

    }


}
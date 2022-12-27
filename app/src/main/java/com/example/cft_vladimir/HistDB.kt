package com.example.cft_vladimir

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ RoomHist::class, ], version = 1, exportSchema = false)
abstract class HistDB : RoomDatabase() {
    abstract fun histDao() : DaoHist

    companion object {
        private var INSTANCE : HistDB ?= null
        fun getInstance(context: Context) : HistDB ? {
            if(INSTANCE == null){
                synchronized(HistDB::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        HistDB::class.java,
                        "hist.db")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
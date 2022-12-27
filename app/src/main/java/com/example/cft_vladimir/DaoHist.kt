package com.example.cft_vladimir

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoHist {
    @Insert
    fun insert(vararg hists: RoomHist)
    @Delete
    fun delete(vararg hists: RoomHist)
    @Query("select * from hist")
    fun getAll(): LiveData<List<RoomHist>>
}
package com.example.cft_vladimir.roompak

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg books: Hist)

    @Delete
    fun delete(vararg books: Hist)

    @Query("select * from Hist")
    fun getAll(): LiveData<List<Hist>>

}
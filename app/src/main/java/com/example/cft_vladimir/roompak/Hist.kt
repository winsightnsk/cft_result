package com.example.cft_vladimir.roompak

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "hist")//, primaryKeys = ["title", "author"])
data class Hist (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var binNum:  String,
)
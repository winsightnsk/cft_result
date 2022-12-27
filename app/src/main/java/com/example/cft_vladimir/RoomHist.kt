package com.example.cft_vladimir

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "hist")
data class RoomHist(
    @PrimaryKey
    var text: String
)
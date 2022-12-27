package com.example.cft_vladimir

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class HistVM : AndroidViewModel(HistApp.instance) {
    private val db = HistDB.getInstance(getApplication())
    private val dao = db!!.histDao()
    private val service = Executors.newFixedThreadPool(1)

    fun getAll() : LiveData<List<RoomHist>>{
        return dao.getAll()
    }

    fun addHist(rhist: RoomHist)
    {
        service.submit {
            dao.insert(rhist)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }
}
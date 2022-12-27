package com.example.cft_vladimir.roompak

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class HistViewModel : AndroidViewModel(HistApplication.instance) {
    private val db = HistDatabase.getInstance(getApplication())
    private val dao = db!!.HistDao()
    private val service = Executors.newFixedThreadPool(1)

    fun getAll() : LiveData<List<Hist>>
    {
        return dao.getAll()
    }

    fun addBook(hist: Hist)
    {
        service.submit {
            dao.insert(hist)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }

}
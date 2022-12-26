package com.example.cft_vladimir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cft_vladimir.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import com.example.cft_vladimir.network.BinApi
//import com.example.cft_vladimir.network.BinApiService
//import com.example.cft_vladimir.network.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.net.URL

class MainActivity : AppCompatActivity(), Callback<JBin> {

    lateinit var amtext : TextView
    lateinit var amedit : EditText
    lateinit var ambuttongo : Button

    interface ApiS {
        @GET("55369138")
        fun getBinAnswer() : Call<JBin>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amtext = findViewById(R.id.amtext)
        amtext.text =""
        amedit = findViewById(R.id.amedit)
        ambuttongo = findViewById(R.id.ambuttongo)
        ambuttongo.setOnClickListener { _->
            val retro = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://lookup.binlist.net/")
                .build()
            val retrofitService = retro.create(ApiS::class.java)
            val gotretro = retrofitService.getBinAnswer()
            gotretro.enqueue(this)
        }
    }

    override fun onResponse(call: Call<JBin>, response: Response<JBin>) {
        var s = amtext.text.toString() + "\nResponse message:\n${response.message()}"
        val r = response.body() as JBin
        s+= "\nResponse body:\n${r}"
//        s+= "\nResponse successful: ${response.isSuccessful}"
        amtext.text = s
    }

    override fun onFailure(call: Call<JBin>, t: Throwable) {
        amtext.text = amtext.text.toString() + "\nonFailure\n${t.message}"
    }
}
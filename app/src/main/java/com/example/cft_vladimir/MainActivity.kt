package com.example.cft_vladimir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cft_vladimir.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.time.LocalDate
import java.util.Date

object BIN {
    var N: String = "55369138"
}
class MainActivity : AppCompatActivity(), Callback<JBin> {

    private lateinit var amtext : TextView
    private lateinit var amedit : EditText
    private lateinit var ambuttongo : Button

    private lateinit var model: HistVM

    interface ApiS {
        @GET("{bin}")
        fun getBinAnswer(@Path("bin") bin: String) : Call<JBin>
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
            BIN.N = amedit.text.toString()
            if (BIN.N.length in 6..8){
                try {
                    val gotretro = retrofitService.getBinAnswer(BIN.N)
                    gotretro.enqueue(this)
                    model.addHist(RoomHist(BIN.N))
                } catch (_: Exception){
                    amtext.text = "Ошибка обработки данных."
                }
            } else amtext.text = "от 6 до 8 символов."
        }
        model = ViewModelProvider(this)[HistVM::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.main_author -> {
                showAuthorDialog()
                return true
            }
            R.id.main_history -> {
                showHistDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showHistDialog() {
        val view = LayoutInflater.from(this)
            .inflate(R.layout.dialog_hist, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setTitle("История запросов")

        builder.setNegativeButton("Закрыть"){
            dialog, _ ->  dialog.cancel()
        }

        builder.create().show()
    }

    private fun showAuthorDialog() {
        val view = LayoutInflater.from(this)
            .inflate(R.layout.author, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setTitle("Об авторе")
        builder.create().show()
    }

    override fun onResponse(call: Call<JBin>, response: Response<JBin>) {
        var s = "BIN: ${BIN.N}\n\n"
        val r = response.body() as JBin
        s+= r.toS()
        amtext.text = s
    }

    override fun onFailure(call: Call<JBin>, t: Throwable) {
        val regex = """Unable to resolve host*""".toRegex()
        if (regex.containsMatchIn(t.message?:"")){
            amtext.text = "Проверьте подключение к интернету."
        }
        else amtext.text = "Неизвестная ошибка"
    }
}
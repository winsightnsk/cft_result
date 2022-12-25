package com.example.cft_vladimir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var amtext : TextView
    lateinit var amedit : EditText
    lateinit var ambuttongo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amtext = findViewById(R.id.amtext)
        amedit = findViewById(R.id.amedit)
        ambuttongo = findViewById(R.id.ambuttongo)
        ambuttongo.setOnClickListener { _->
            amtext.text="ttt"
        }
    }
}
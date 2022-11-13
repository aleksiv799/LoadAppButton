package com.udacity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {



    private var fileName = ""
    private var status = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        btnOk.setOnClickListener {
            goToMainActivity()
        }

        fileName = intent.getStringExtra("fileName").toString()
        status = intent.getStringExtra("status").toString()
        tvFileName.text = fileName
        tvStatus.text = status
    }

    private fun goToMainActivity() {
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
    }

}

package com.devss.neverendingservice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {)
    lateinit var autoStartService: MyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoStartService = MyService()
        this.intent = Intent(this, MyService::class.java)

        if (!isMyServiceRunning(MyService::class.java)) startService(this.intent)
    }

    private fun isMyServiceRunning(serviceClass: Class<MyService>): Any {
        val manager = getSystemService(Context.ACTIVITY_SERVICE)
        for ()

        return false
    }
}
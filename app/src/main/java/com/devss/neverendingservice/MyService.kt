package com.devss.neverendingservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*

class MyService() : Service() {

    private val TAG = "MyService"
    private var counter = 0
    private var timer: Timer? = null
    private lateinit var timerTask: TimerTask

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        startTimer()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: Service is destroyed :-(")
        val intent = Intent(this, RestartBroadcastService::class.java)
        sendBroadcast(intent) // Sending broadcast to restart the service
        stoptimerTask()
    }

    private fun startTimer() {
        timer = Timer()

        initialiseTimerTask()

        timer!!.schedule(timerTask, 1000, 1000)
    }

    private fun initialiseTimerTask() {
        timerTask = object : TimerTask() {
            override fun run() {
                Log.i(TAG, "Timer is running ${counter++}")
            }
        }
    }

    private fun stoptimerTask() {
        // Stop the timer, if it's already null
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}
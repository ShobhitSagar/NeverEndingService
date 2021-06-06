package com.devss.neverendingservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class RestartBroadcastService: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(RestartBroadcastService::class.simpleName, "Service is stopped but this is a never ending service.")

        context?.startService(Intent(context, MyService::class.java))
    }

}

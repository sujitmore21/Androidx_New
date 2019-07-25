package com.example.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var intentFilter: IntentFilter? = null

    val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val status = intent!!.getBooleanExtra("state", false)

            if (status) {
                progressBar.visibility = View.GONE
                imgAirplanemode.setImageResource(R.drawable.ic_airplanemode_active_black_24dp)
                val aniRotate = AnimationUtils.loadAnimation(applicationContext, R.anim.anim)
                imgAirplanemode.startAnimation(aniRotate)
            } else {
                imgAirplanemode.setImageResource(R.drawable.ic_airplanemode_inactive_black_24dp)
                val aniRotate = AnimationUtils.loadAnimation(applicationContext, R.anim.anim)
                imgAirplanemode.startAnimation(aniRotate)

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentFilter = IntentFilter()
        intentFilter!!.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        sendBroadcast(Intent())
    }

    override fun onStart() {
        registerReceiver(broadcastReceiver, intentFilter)
        super.onStart()
    }

    override fun onStop() {
        unregisterReceiver(broadcastReceiver)
        super.onStop()
    }

}

package com.example.androidx_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(TwoFragmet())

    }

    fun loadFragment(frag: Fragment){
        val txn = supportFragmentManager.beginTransaction()
        txn.replace(R.id.frame,frag)
        txn.commit()
    }
}



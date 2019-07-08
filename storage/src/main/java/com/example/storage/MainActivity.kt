package com.example.storage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appPrefs = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val actPrefs = getPreferences(Context.MODE_PRIVATE)

        btShRd.setOnClickListener {
            readFromSharedPrefs(appPrefs)
        }

        btShWr.setOnClickListener {
            writeToSharedPrefs(appPrefs)
        }
    }

    private fun writeToSharedPrefs(prefs: SharedPreferences) {
        val editor = prefs.edit()
        editor.putInt("top_score", 86)
        editor.putString("str", "android")
        editor.putBoolean("bool", true)
        editor.putFloat("flt", 89.65f)
        editor.apply()
    }

    private fun readFromSharedPrefs(prefs: SharedPreferences) {
        val prefsDt = """
                Boolean ${prefs.getBoolean("bool", false)}
                Int ${prefs.getInt("top_score", -1)}
                String ${prefs.getString("str", "codekul")}
        """.trimIndent()

        Log.i("@codekul", prefsDt)
    }

    fun writeToInternalStorage() {
        val file = File(filesDir, "my.txt")
        Log.i("@codekul", "Path to internal storage ${file.absolutePath}")
        file.bufferedWriter().use { bw -> bw.write("This is my data") }
    }

    fun readToInternalStorage() {
        val file = File(filesDir, "my.txt")
        val data = file.readText()
        Log.i("@codekul", "Data available in file is $data")
    }
}

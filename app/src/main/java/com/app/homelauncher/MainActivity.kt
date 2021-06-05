package com.app.homelauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.app.homelauncher.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bt_home_launcher=findViewById<Button>(R.id.bt_home_launcher)
        bt_home_launcher.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}
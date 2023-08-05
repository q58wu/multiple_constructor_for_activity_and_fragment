package com.example.multipleconstructorfragmentexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.go_to_next_screen_button).setOnClickListener {
            val newIntermediateData = SecondActivity.IntermediateData.NewIntermediateData(name = "John Foo", sex = "Male")
            startActivity(Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA", newIntermediateData)
            })
        }
        findViewById<Button>(R.id.go_to_next_screen_button_old).setOnClickListener {
            val oldIntermediateData = SecondActivity.IntermediateData.OldIntermediateData(name = "Mary Ann", sex = "Female", age = 65)
            startActivity(Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA", oldIntermediateData)
            })
        }
    }

}
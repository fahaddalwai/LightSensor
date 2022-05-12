package com.example.sensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.isDark.observe(this) {
            if (it) {
                textView.text=getString(R.string.dark)
                background.setBackgroundColor(getResources().getColor(R.color.black))
            }else{
                textView.text=getString(R.string.light)
                background.setBackgroundColor(getResources().getColor(R.color.white))
            }
        }

    }
}
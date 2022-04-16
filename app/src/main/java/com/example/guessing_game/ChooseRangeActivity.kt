package com.example.guessing_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guessing_game.databinding.ActivityChooseRangeBinding

class ChooseRangeActivity : AppCompatActivity() {
    lateinit var binding: ActivityChooseRangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseRangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { View ->
            if (binding.etNumberFrom.text.isNotEmpty() and binding.etNumberTo.text.isNotEmpty()) {
                var intent: Intent = Intent(this, MainActivity::class.java)
                intent.putExtra("NumberFrom", binding.etNumberFrom.text.toString())
                intent.putExtra("NumberTo", binding.etNumberTo.text.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
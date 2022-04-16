package com.example.guessing_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guessing_game.databinding.ActivityChooseRangeBinding
import com.example.guessing_game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var numberFrom: Int = intent.getStringExtra("NumberFrom").toString().toInt() - 1
        var numberTo: Int = intent.getStringExtra("NumberTo").toString().toInt() + 1

        var currentNumber: Int = numberFrom + (numberTo-numberFrom)/2
        binding.tvNumber.text = currentNumber.toString()

        binding.btMore.setOnClickListener { View ->
//            if ((numberTo-numberFrom)/2 == 1){
//                currentNumber+=1
//                Toast.makeText(this, "Вы загадали число: $currentNumber", Toast.LENGTH_SHORT).show()
//            }

            numberFrom = currentNumber
            currentNumber += (numberTo-numberFrom)/2
            binding.tvNumber.text = currentNumber.toString()


        }
        binding.btLess.setOnClickListener { View ->
//            if ((numberTo-numberFrom)/2 == 1){
//                currentNumber-=1
//                Toast.makeText(this, "Вы загадали число: $currentNumber", Toast.LENGTH_SHORT).show()
//            }
            numberTo = currentNumber
            currentNumber -= (numberTo-numberFrom)/2
            binding.tvNumber.text = currentNumber.toString()

        }
        binding.btRestart.setOnClickListener { View ->
            var intent: Intent = Intent(this, ChooseRangeActivity::class.java)
            startActivity(intent)
        }
    }

}
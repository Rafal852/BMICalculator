package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.NumberPicker
import com.example.bmicalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.weightScroll.minValue = 1
        binding.weightScroll.maxValue = 150

        binding.heightScroll.minValue = 10
        binding.heightScroll.maxValue = 250



        binding.bmiCalc.setOnClickListener {
            calculateBMI()
        }
        binding.calcAgain.setOnClickListener {
            binding.bmiView.visibility = GONE
            binding.bmiCalc.visibility = VISIBLE
            binding.female.visibility = VISIBLE
            binding.male.visibility = VISIBLE

        }


        binding.male.setOnClickListener {
            binding.female.visibility = GONE
        }
        binding.female.setOnClickListener {
            binding.male.visibility = GONE
        }

    }

    private fun calculateBMI(){
        val height = binding.heightScroll.value
        val doubleHeight = height.toDouble()/100

        val weight = binding.weightScroll.value

        val bmi = weight.toDouble()/ (doubleHeight * doubleHeight)

        binding.results.text = String.format("Your BMI is: %.2f", bmi)
        binding.advice.text = String.format("Considered: %s", healthyMessage(bmi))

        binding.bmiView.visibility = VISIBLE
        binding.bmiCalc.visibility = GONE

    }

    private fun healthyMessage(bmi: Double): String{

        if (bmi.compareTo(15f) <= 0){
            return  "Very servirly underweight, you should eat more."
        }
        else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0){
            return "Servirly underweight, you should eat more."

        }
        else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0){
            return  "Underweight,you should eat more."
        }
        else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0){
            return "Normal, you're healthy."
        }
        else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0){
            return "Overweight, you clould lose some weight."
        }
        else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0){
            return "Moderetly obese, you need to lose some weight"
        }
        else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0){
            return "Severly obese, lose weight."
        }
        else{
            return "Very severly obese."

        }
    }


}
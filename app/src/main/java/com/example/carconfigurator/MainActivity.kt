package com.example.carconfigurator

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val carImageView : ImageView = findViewById(R.id.car_imageview)

        val carImages = listOf(
            R.drawable.sedan,
            R.drawable.suv,
            R.drawable.hatchback
        )
        carImageView.setImageResource(carImages[0])

        var carTypeRadioGroup : RadioGroup = findViewById(R.id.car_type_radiogorup)
        var carType = "Sedan"

        carTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->

            val carTypeRadioButton : RadioButton = findViewById(checkedId)
            carType = "${carTypeRadioButton.text}"

            carImageView.setImageResource(
                when(carTypeRadioButton.text){

                    "Sedan"-> carImages[0]
                    "SUV" -> carImages[1]
                    "Hatchback" ->carImages[2]
                    else -> carImages[0]
                }
            )
        }


        val coolSeatCheckBox : CheckBox = findViewById(R.id.cool_seats_checkbox)
        var coolSeat = "podgrzewane"
        coolSeatCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
            {
                coolSeat = "chłodzone i podgrzewane"
            }
            else
            {
                coolSeat = "podgrzewane"
            }
        }

        val leatherSeatCheckBox : CheckBox = findViewById(R.id.leather_seats_checkbox)
        var leatherSeat = "sztuczna skóra"
        leatherSeatCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
            {
                leatherSeat = "skórzane"
            }
            else
            {
                leatherSeat = "sztuczna skóra"
            }
        }

        val orderTextView : TextView = findViewById(R.id.order_textview)

        val orderButton : Button = findViewById(R.id.order_button)

        orderButton.setOnClickListener {
            orderTextView.text = "Poddsumowanie zamówienia: \n Rodzaj samochodu: $carType \n Fotele: $coolSeat, $leatherSeat"
        }





    }
}
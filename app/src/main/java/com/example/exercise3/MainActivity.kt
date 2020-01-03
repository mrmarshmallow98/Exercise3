package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myData: PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        fun display(){
            if(myData.amount != 0.0)
                textViewPremium.text = "Total Premium:RM" + myData.amount.toString()
        }

        fun getPremium():Double{
            return when(spinnerAge.selectedItemPosition){
                0 -> 60.00
                1 -> 70.00 +
                        (if(radioButtonMale.isChecked)50.00 else 0.00)+
                        (if(checkBoxSmoker.isChecked)100.00 else 0.00)
                2 -> 90.00 +
                        (if(radioButtonMale.isChecked)100.00 else 0.00)+
                        (if(checkBoxSmoker.isChecked)150.00 else 0.00)
                3 -> 120.00 +
                        (if(radioButtonMale.isChecked)150.00 else 0.00)+
                        (if(checkBoxSmoker.isChecked)200.00 else 0.00)
                4 -> 150.00 +
                        (if(radioButtonMale.isChecked)200.00 else 0.00)+
                        (if(checkBoxSmoker.isChecked)250.00 else 0.00)
                else -> 150.00 +
                        (if(radioButtonMale.isChecked)200.00 else 0.00)+
                        (if(checkBoxSmoker.isChecked)300.00 else 0.00)
            }
        }

        buttonCalculate.setOnClickListener(){

            myData.amount= getPremium()
            display()
        }

        buttonReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked=false
            textViewPremium.setText("Total Premium:")
        }
    }
}

package com.biodun.compundintrestcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    var theMonthToYearConstant = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSimpleSpinner()

    }


    //setting up the spinners
    private fun setupSimpleSpinner() {

        val theadapter = ArrayAdapter.createFromResource(
            this,
            R.array.duration,
            android.R.layout.simple_spinner_dropdown_item
        )
        theadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter = theadapter
        spinner2.adapter = theadapter

        //giving functionality to the spinners
        spinner1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem1 = parent!!.getItemAtPosition(position)
                //Toast.makeText(this@MainActivity, "$selectedItem1 selected", Toast.LENGTH_SHORT).show()


            }

        }

        spinner2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var selectedItem2 = parent!!.getItemAtPosition(position)
                //Toast.makeText(this@MainActivity, "$selectedItem2 selected", Toast.LENGTH_SHORT).show()
                if (selectedItem2 == "year"){
                    theMonthToYearConstant = 12
                }
            }

        }

    }

    // Computing and displaying results
    fun calcEvent(view: View){
        var principalCI =  etNumber.text.toString().toDouble()
        val interestCI =  etInterest.text.toString().toDouble()
        var durationCI = etDuration.text.toString().toInt() * theMonthToYearConstant


        var x = 1 + (interestCI/100)
        var y = pow(x.toDouble(), durationCI.toDouble())
        var compoundInterest = principalCI * y

        tvSum.text = compoundInterest.toInt().toString()
    }

}
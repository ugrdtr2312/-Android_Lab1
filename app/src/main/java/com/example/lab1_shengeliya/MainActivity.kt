package com.example.lab1_shengeliya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.authors_spinner)
        ArrayAdapter.createFromResource(this, R.array.authors_array, R.layout.spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
    }

    fun onOk(view: View)
    {
        val spinner = findViewById<Spinner>(R.id.authors_spinner)
        val radioGroup = findViewById<RadioGroup>(R.id.radio)

        if (spinner.selectedItem.toString() == "")
        {
            Toast.makeText(this, "Author doesn't checked", Toast.LENGTH_LONG).show()
            return
        }
        if (radioGroup.checkedRadioButtonId == -1)
        {
            Toast.makeText(this, "Year doesn't checked", Toast.LENGTH_LONG).show()
            return
        }

        val radioText = radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
        findViewById<TextView>(R.id.textFinal).text = "Selected info:\n" + "Author - " + spinner.selectedItem.toString() + "\n" + "Published in " + radioText

        spinner.setSelection(0)
        radioGroup.clearCheck()
    }
}
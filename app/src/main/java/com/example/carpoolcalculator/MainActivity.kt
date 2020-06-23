package com.example.carpoolcalculator

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = this.getPreferences(0)

        text_average.setText(pref.getString("average", "0"))
        text_cost.setText(pref.getString("cost", "0"))
        text_extra.setText(pref.getString("extra", "0"))

        input_km.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (input_km.text.toString() == "0" || text_average.text.toString() == "0" || text_cost.text.toString() == "0") {
                    text_km.text = "0"
                    text_subcost.text = "0"
                    text_total.text = "0"
                } else {
                    val km=input_km.text.toString().toDouble();
                    val average=text_average.text.toString().toDouble();
                    val cost=text_cost.text.toString().toDouble();
                    val extra=text_extra.text.toString().toDouble();

                    val cal=km/average*cost

                    text_km.text = input_km.text;

                    text_subcost.text = cal.roundToInt().toString()

                    text_total.text = (cal+extra).roundToInt().toString()
                }
            }
        })

        average_btn.setOnClickListener(View.OnClickListener {
            pref.edit().putString("average", text_average.text.toString()).apply()

            val km=input_km.text.toString().toDouble();
            val average=text_average.text.toString().toDouble();
            val cost=text_cost.text.toString().toDouble();
            val extra=text_extra.text.toString().toDouble();

            val cal=km/average*cost

            text_km.text = input_km.text;

            text_subcost.text = cal.roundToInt().toString()

            text_total.text = (cal+extra).roundToInt().toString()
        })

        cost_btn.setOnClickListener(View.OnClickListener {
            pref.edit().putString("cost", text_cost.text.toString()).apply()

            val km=input_km.text.toString().toDouble();
            val average=text_average.text.toString().toDouble();
            val cost=text_cost.text.toString().toDouble();
            val extra=text_extra.text.toString().toDouble();

            val cal=km/average*cost

            text_km.text = input_km.text;

            text_subcost.text = cal.roundToInt().toString()

            text_total.text = (cal+extra).roundToInt().toString()
        })

        extra_btn.setOnClickListener(View.OnClickListener {
            pref.edit().putString("extra", text_extra.text.toString()).apply()

            val km=input_km.text.toString().toDouble();
            val average=text_average.text.toString().toDouble();
            val cost=text_cost.text.toString().toDouble();
            val extra=text_extra.text.toString().toDouble();

            val cal=km/average*cost

            text_total.text = (cal+extra).roundToInt().toString()
        })
    }
}
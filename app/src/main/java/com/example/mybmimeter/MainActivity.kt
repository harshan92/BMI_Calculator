package com.example.mybmimeter

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        check_btn.setOnClickListener {
            val h=height.text.toString().toDouble()/100
            val w=weight.text.toString().toDouble()
            val res=w/(h*h)
            var status:String=""
            if(res<=18.4) {
                status = "Underweight"
                result_text.setTextColor(Color.BLUE)
            }else if(res>18.4 && res<=24.9) {
                status = "Healthful weight"
                result_text.setTextColor(Color.GREEN)
            }
            else if(res>24.9 && res<=29.9) {
                status = "Overweight"
                result_text.setTextColor(Color.rgb(211, 77, 5))
            }
            else if(res>29.9 && res<=34.9) {
                status = "Obesity. Very high risk"
                result_text.setTextColor(Color.rgb(211, 77, 5))
            }
            else if(res>34.9 && res<=39.9) {
                status = "Obesity. Very high risk"
                result_text.setTextColor(Color.rgb(211, 77, 5))
            }
            else if(res>39.9) {
                status = "Extreme obesity. Extremely high risk"
                result_text.setTextColor(Color.RED)
            }
            result_text.text=""+status
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
         when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)

            }
             R.id.exit -> {
                 System.exit(0);

             }

            else -> super.onContextItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.cmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}

package com.example.kal_el.helloworld

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    var min_value = 0
    var max_value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Responding to onClick event of button
    // Check for entered edit text value min alway <= max
    // And generates random number between min and max and displays it on activity
    fun generateRandom(view: View) {

        try {
            // Making sure only numeric values are passed
            min_value = Integer.parseInt(min_et.text.toString())
            max_value = Integer.parseInt(max_et.text.toString())
            if (min_value > max_value) {
                Toast.makeText(this, "Min value must be less then or equal to max value", Toast.LENGTH_LONG).show()
            } else {
                // Generating random number
                val random = Random()
                val randomNumber = random.nextInt(max_value-min_value+1) + min_value

                random_tv.setText(randomNumber.toString())
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Value field can not be empty", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.v("Main Activity", item?.itemId.toString())

        when (item?.itemId) {
            R.id.menu_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }



        }
        return true
    }
}

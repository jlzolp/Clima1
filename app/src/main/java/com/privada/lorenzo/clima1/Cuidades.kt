package com.privada.lorenzo.clima1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Cuidades : AppCompatActivity() {
    val TAG = "com.privada.lorenzo.clima1.Cuidades.CUIDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuidades)
        val bMexico = findViewById<Button>(R.id.bMexico)
        val bBerlin = findViewById<Button>(R.id.bBerlin)
        bMexico.setOnClickListener {
            // codigo para validar red
            if (Network.hayRed(this)) {
                val intent = Intent(this,Main2Activity::class.java)
                intent.putExtra(TAG,"4003757")
                //https://openweathermap.org/
                // cd juarez  4003757
                startActivity(intent)
            } else {
                Toast.makeText(this, "no hay red", Toast.LENGTH_SHORT).show()
            }
        }
        bBerlin.setOnClickListener {
            // codigo para validar red
            if (Network.hayRed(this)) {
                val intent = Intent(this,Main2Activity::class.java)
                intent.putExtra(TAG,"3991547")  // pueblo yaqui
                startActivity(intent)
            } else {
                Toast.makeText(this, "no hay red", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

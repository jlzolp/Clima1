package com.privada.lorenzo.clima1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.io.IOException

class Main2Activity : AppCompatActivity() {

    var tvCuidad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvCuidad = findViewById(R.id.tvCuidad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)
        val cuidad= intent.getStringExtra("com.privada.lorenzo.clima1.Cuidades.CUIDAD")

        if (Network.hayRed(this)) {

            SolicitudHttpVolley("https://api.openweathermap.org/data/2.5/weather?id="+cuidad+"&appid=1718862af3051b8526dd425f0f1c04a9&units=metric&lang=es")
            //1718862af3051b8526dd425f0f1c04a9
            //3530597  cuida de mexico

        } else {
            Toast.makeText(this, "no hay red", Toast.LENGTH_SHORT).show()
        }


        //Toast.makeText(this,cuidad, Toast.LENGTH_SHORT).show()

      /*  val cuidadmx = cuidad("cuidad de Mexico",15,"Soleado")
        val cuidadBerlin = cuidad("cuidad de Berlin",2,"Invierno")

        if (cuidad =="cuidad-mexico")
        {
            tvCuidad?.text = cuidadmx.nombre
            tvGrados?.text = cuidadmx.grados.toString()+"°"
            tvEstatus?.text = cuidadmx.estatus
        }else if (cuidad =="cuidad-berlin")
        {
            tvCuidad?.text = cuidadBerlin.nombre
            tvGrados?.text = cuidadBerlin.grados.toString()+"°"
            tvEstatus?.text = cuidadBerlin.estatus
        }else{
            Toast.makeText(this,"No se encuentra la informacion", Toast.LENGTH_SHORT).show()
        }*/

    }


    private fun SolicitudHttpVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solictud = StringRequest(Request.Method.GET,url, Response.Listener<String >{
            response ->
            try {
                Log.d("solicitudHttpVolley",response)
                val gson = Gson()
                val cuidad = gson.fromJson(response,cuidad::class.java)
                //Log.d("Gson",cuidad.name)
                tvCuidad?.text = cuidad.name
                tvGrados?.text = cuidad.main?.temp.toString()+"°"
                tvEstatus?.text = cuidad.weather?.get(0)?.description
            }catch (e: IOException){

            }
        }, Response.ErrorListener {  })
        queue.add(solictud)

    }
}

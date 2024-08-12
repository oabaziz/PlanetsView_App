package com.example.planetsapp

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var lst :ListView
    val planets = arrayOf("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune")
    val moon_count = arrayOf(0,0,1,2,79,82,27,14)
    val images = arrayOf(R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.neptune)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)pp
        lst =findViewById(R.id.listview)
        val datasource = ArrayList<DataSource>()
        for(i in planets.indices)
        {
            val data = DataSource(planets[i],moon_count[i],images[i])
            datasource.add(data)
        }

        val adapter = CustomAdapter(this,datasource)
        lst.adapter = adapter

        lst.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position)
            val planet = item as DataSource

            Toast.makeText(this,"Planet ${planet.title} has ${planet.count} moons", Toast.LENGTH_SHORT).show()
        }

    }
}


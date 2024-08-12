package com.example.planetsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private val context: Context, private val dataSource: ArrayList<DataSource>) : BaseAdapter()
{
    override fun getCount(): Int {
      return dataSource.size
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_item,p2, false)
        val title =view.findViewById<TextView>(R.id.custom_text)
        val count =view.findViewById<TextView>(R.id.custom_text2)
        val image =view.findViewById<ImageView>(R.id.imageView)
        title.text = dataSource[p0].title
        count.text = dataSource[p0].count.toString()
        image.setImageResource(dataSource[p0].imageResourceId)
        return view
    }
}
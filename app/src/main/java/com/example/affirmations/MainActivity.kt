package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialize data
        val dataSet = Datasource().loadAffirmations()
        //initialize recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //apply the adapter that we created, using this context and the dataSet
        recyclerView.adapter = ItemAdapter(this, dataSet)
        //improve performance if the chance in content won't change the size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}
package com.example.krishi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class Checkout : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        recyclerView=findViewById(R.id.recyclerView1)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=CheckoutAdapter()

    }
}

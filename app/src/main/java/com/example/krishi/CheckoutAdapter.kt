package com.example.krishi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

private lateinit var bundle: Bundle
lateinit var context:Context

class CheckoutAdapter: RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val layoutInflater=LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.activity_checkout,parent,false)
        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val intent = Intent()
        bundle = intent.extras as Bundle
        holder.textView.text= bundle.getString("title")
        holder.textView1.text= bundle.getString("prices")

        val intent1=Intent(context,Checkout::class.java)


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textView=itemView.findViewById<TextView>(R.id.textView2)
        var textView1=itemView.findViewById<TextView>(R.id.textViewSubTotalPrice)
        var textView2=itemView.findViewById<TextView>(R.id.totalprice1234)

    }

}




package com.example.krishi

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.squareup.picasso.Picasso
import java.util.ArrayList

class ProductAdapeter(private val Products: ArrayList<Products>, itemView: View):RecyclerView.ViewHolder(
    itemView)
    //RecyclerView.Adapter<ProductAdapeter.ViewHolder>()
{

    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val textView: TextView = itemView.findViewById(R.id.textView)
    val textView1: TextView = itemView.findViewById(R.id.currency)

    //override fun onBindViewHolder(holder: ProductAdapeter.ViewHolder, position: Int) {
    //
    //}


    //@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        val holder = RecyclerView.ViewHolder(view)
        view.setOnClickListener {

            val intent = Intent(parent.context, ProductDetails::class.java)
           // intent.putExtra("title",Products[holder.adapterPosition].title)
            val bundle = Bundle()
           // bundle.putInt("prices", Products[holder.adapterPosition].prices!!.toInt())
           // bundle.putString("title", Products[holder.adapterPosition].title)
            intent.putExtras(bundle)
            parent.context.startActivity(intent)
        }
        return holder*/


    /// override fun getItemCount() = Products.size

    //  fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    //    val products = Products[position]

    //  holder.textView.text = products.title
    // holder.textView1.text = products.prices.toString()
    // Picasso.get().load(products.Photo).into(holder.imageView)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView1: TextView = itemView.findViewById(R.id.currency)
    }
}


//    private fun loadfirebaseRecyclerView()
  //  {

      /*  var FirebaseRecyclerAdapter=object :FirebaseRecyclerAdapter<Products,ViewHolder>(){
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
               ): RecyclerView.ViewHolder

            {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }*/
   // }


 /*           fun onBindViewHolder(
                holder: RecyclerView.ViewHolder,
                position: Int,
                model: Products
             )

            {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

*/
//}









package com.example.krishi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.navigationheader.*
import kotlinx.android.synthetic.main.productsist.*
import java.lang.Exception
import com.squareup.picasso.Callback as Callback1

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseref: DatabaseReference
    private lateinit var progressBar: ProgressBar
    //  lateinit var productlist: MutableList<Products>
    private lateinit var firebaseRecyclerAdapter: FirebaseRecyclerAdapter<Products, RecyclerView.ViewHolder>
    private lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productsist)
        setSupportActionBar(toolbar)
        val products = ArrayList<Products>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val drawer = findViewById<DrawerLayout>(R.id.drawerLayout)

        //    productlist = mutableListOf()
        progressBar = findViewById(R.id.ProgressBar)
        firebaseDatabase = FirebaseDatabase.getInstance()   //getInstance of Firebase
        firebaseref = firebaseDatabase.reference.child("Data")

        val option = FirebaseRecyclerOptions.Builder<Products>()
            .setQuery(firebaseref, Products::class.java)
            .build()

        firebaseRecyclerAdapter = object :
            FirebaseRecyclerAdapter<Products, RecyclerView.ViewHolder>(option) {

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
                val itemView = LayoutInflater.from(this@MainActivity)
                    .inflate(R.layout.activity_main, parent, false)
                return ViewHolder(itemView)
                //ProductAdapeter.ViewHolder(itemView)
            }

            override fun onBindViewHolder(
                holder: RecyclerView.ViewHolder,
                position: Int,
                model: Products
            ) {
//                holder.itemView.textView.text =
//                    model.Title//setText(products.get(position).Title)
                //holder.itemView.textView.text = model.Title
                //  holder.itemView.imageView=model.Image
//                holder.itemView.currency.text = model.Price
//                Picasso.get().load(model.Image).into(holder.itemView.imageView,object :com.squareup.picasso.Callback{
//                    override fun onSuccess() {
//                    }

//                    override fun onError(e: Exception?) {
//                       Toast.makeText(this@MainActivity,"Could not get the Image Check Internet!!",Toast.LENGTH_SHORT).show()
//                    }
//
//                })

                val refid = getRef(position).key.toString()
                holder.itemView.textView.setText(model.Title)
                holder.itemView.currency.setText(model.Price)
                Picasso.get().load(model.Image).into(holder.itemView.imageView)
                firebaseref.child(refid).addValueEventListener(object : ValueEventListener {


                    override fun onCancelled(p0: DatabaseError) {
                        Toast.makeText(this@MainActivity, p0.message, Toast.LENGTH_SHORT).show()

                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        progressBar.visibility = if (itemCount == 0) View.VISIBLE else View.GONE

//                        holder.itemView.textView.setText(model.Title)
//                        holder.itemView.currency.setText(model.Price)
//                        Picasso.get().load(model.Image).into(holder.itemView.imageView)

                        // if (p0.exists()) {

                        // for (h in p0.children) {
                        //   val prodcuts = h.getValue(Products::class.java)
                        //   if (prodcuts != null) {
                        //                              productlist.add(prodcuts)
                    }

                    //         }
                    //   }

                    //   }


                })

                holder.itemView.setOnClickListener {
                    val intent = Intent(this@MainActivity, ProductDetails::class.java)
                    val bundle = Bundle()
                    bundle.putInt("prices", model.Price!!.toInt())
                    bundle.putString("title", model.Title.toString())
                    intent.putExtras(bundle)
                    intent.putExtra("title", model.Title)
                    startActivity(intent)
                    //  Toast.makeText(this@MainActivity,"Hello",Toast.LENGTH_SHORT).show()
                }
            }


        }
        val toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        toggle.toolbarNavigationClickListener
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        //       for (i in 0..8) {
        //       //  products.add(
        //        Products(
        //          "",
        //        "https://via.placeholder.com/300x300",
        //      "20",
        //    "Something"
        // )
        //)
        //   }

        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        recyclerView.adapter = firebaseRecyclerAdapter

        recyclerView.hasFixedSize()


        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.menu.getItem(0).isCheckable = true

 //     header()




    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView1: TextView = itemView.findViewById(R.id.currency)
    }

//    private fun loadRecyclerView() {
//        val options = FirebaseRecyclerOptions.Builder<Products>()
//            .setQuery(firebaseref, Products::class.java)
//            .build()
//        firebaseRecyclerAdapter = object :
//            FirebaseRecyclerAdapter<Products, ProductAdapeter.ViewHolder>(options)
//
//
//    }

    override fun onStart() {
        super.onStart()
        firebaseRecyclerAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        firebaseRecyclerAdapter.stopListening()

    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {

            R.id.account -> {
                val intent = Intent(this, ContactUs::class.java)
                startActivity(intent)
            }

            R.id.myorders -> Toast.makeText(this, "This is MyOrders", Toast.LENGTH_SHORT).show()
            R.id.myFav -> Toast.makeText(this, "This is My Favourites", Toast.LENGTH_SHORT).show()
            R.id.ContactUs ->{
                    val intent = Intent(this, ContactUs::class.java)
                    startActivity(intent) }
            R.id.ShareApp -> Toast.makeText(this, "This is Share App", Toast.LENGTH_SHORT).show()
            R.id.About -> Toast.makeText(this, "This is About", Toast.LENGTH_SHORT).show()
            R.id.RateApp -> Toast.makeText(this, "This is Rate App", Toast.LENGTH_SHORT).show()
            R.id.Settings -> Toast.makeText(this, "This is Settings", Toast.LENGTH_SHORT).show()
            R.id.Login -> Toast.makeText(this, "This is Login", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun header() {

        //context=this
        //val objects = LoginPage()
        View.inflate(this,R.layout.navigationheader,relativeLayout)
       // setContentView(R.layout.navigationheader)
        val header: TextView = findViewById(R.id.textview1)
        header.setOnClickListener {
            Log.i("Tag","MEdssage")
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
          Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show()
        }

    }
}





package com.example.krishi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.carticonlayout.*
import kotlinx.android.synthetic.main.productdetails.*


class ProductDetails : AppCompatActivity(), NumberPicker.OnValueChangeListener {

    private lateinit var bundle: Bundle

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseref: DatabaseReference
    private lateinit var firebaseref1: DatabaseReference
    private lateinit var firebaseref2: DatabaseReference
    private lateinit var firebaseref3: DatabaseReference
    private lateinit var firebaseref4: DatabaseReference
    private lateinit var firebaseref5: DatabaseReference
    private lateinit var firebaseref6: DatabaseReference
    private lateinit var firebaseref7: DatabaseReference
    private lateinit var firebaseref8: DatabaseReference

    private lateinit var numberPicker: NumberPicker
    private lateinit var titleofproduct: TextView
    private lateinit var priceofproduct: TextView
    private lateinit var countItemscart: TextView
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productdetails)

       val mTopToolbar : Toolbar = findViewById(R.id.my_toolbar)
        setSupportActionBar(mTopToolbar)


        // val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //val view=layoutInflater.inflate(R.layout.carticonlayout,parent.)
        counter = 0
        bundle = Bundle()
        titleofproduct = findViewById(R.id.productDetailsTextView1)
        priceofproduct = findViewById(R.id.productDetailsTextView2)
        numberPicker = findViewById(R.id.numberPicker)
        //countitemscart=ProductDetails.findViewById(R.id.countItemsCart)
        val intent = intent
        bundle = intent.extras as Bundle

        //val objects = Products()
        //objects.Title = productDetailsTextView2.text.toString()

        firebaseDatabase = FirebaseDatabase.getInstance()
        firebaseref = firebaseDatabase.reference.child("Data")
        firebaseref1 = firebaseDatabase.reference.child("Data")
        firebaseref2 = firebaseDatabase.reference.child("Data")
        firebaseref3 = firebaseDatabase.reference.child("Data")
        firebaseref4 = firebaseDatabase.reference.child("Data")
        firebaseref5 = firebaseDatabase.reference.child("Data")
        firebaseref6 = firebaseDatabase.reference.child("Data")
        firebaseref7 = firebaseDatabase.reference.child("Data")
        firebaseref8 = firebaseDatabase.reference.child("Data")


        titleofproduct.text = bundle.getString("title")
        priceofproduct.text = bundle.getInt("prices").toString()

        // val map= HashMap<String,Products>()
        // val toReturn: ArrayList<Products> = ArrayList()

        firebaseref.addListenerForSingleValueEvent(object : ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("01").child("Description").value.toString().trim()

            }

        })



        firebaseref1.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("02").child("Description").value.toString().trim()
            }


        })

        firebaseref2.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("03").child("Description").value.toString().trim()
            }


        })
        firebaseref3.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("04").child("Description").value.toString().trim()
            }


        })
        firebaseref4.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("05").child("Description").value.toString().trim()
            }


        })
        firebaseref5.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("06").child("Description").value.toString().trim()
            }


        })
        firebaseref6.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("07").child("Description").value.toString().trim()
            }


        })
        firebaseref7.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("08").child("Description").value.toString().trim()
            }


        })
        firebaseref8.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                appleInfo.text = p0.child("09").child("Description").value.toString().trim()
            }


        })

        numberPicker.keepScreenOn=false
        numberPicker.minValue = 1
        numberPicker.maxValue = 10
        numberPicker.setOnValueChangedListener(this)


        addToCartButton.setOnClickListener {
            //   Toast.makeText(applicationContext, "Added to Cart", Toast.LENGTH_SHORT).show()
            counter++
            countItemsCart.text = counter.toString()


        }






        //   setView()
    }


    private fun setView() {
//        val objects: ProductDetails = this
//        objects.setContentView(R.layout.carticonlayout)
          val imageview:ImageView
//        carticonimage = objects.findViewById(R.id.cartIcon)
//        carticonimage.setOnClickListener {
//            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
//        }
    }


    //    fun setView()
//    {
//        val objects:ProductDetails=this
//        objects.setContentView(R.layout.carticonlayout)
//          val imageview:ImageView
//        imageview=findViewById(R.id.cartIcon)
//        imageview.setOnClickListener {
//            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onValueChange(p0: NumberPicker?, p1: Int, p2: Int) {
        priceNumber.text = (bundle.getInt("prices") * (p2)).toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cartmenu, menu)
       // val view: View? =menu?.findItem(R.id.cartIcon)?.actionView
      //  countItemscart= view?.findViewById(R.id.countItemsCart)!!

                return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        Toast.makeText(applicationContext, "Cart is Selected", Toast.LENGTH_SHORT).show()
    //    val carticonimage: ImageView = findViewById(R.id.cartIcon)

        val id=item.itemId

        return super.onOptionsItemSelected(item)
    }
    fun itemSelected(item: MenuItem) {

        if (item.itemId==R.id.item)
        {
            Log.i("Message","Hello")
            val intent1 = Intent(ProductDetails(), Checkout::class.java)
            val bundle1 = Bundle()
            bundle1.putInt("prices", (priceofproduct.text as String).toInt())
            bundle1.putString("title", titleofproduct.text as String?)
            intent1.putExtras(bundle1)
            //   intent1.putExtra("title", model.Title)
            startActivity(intent1)
            //
        }



        //
    }


}




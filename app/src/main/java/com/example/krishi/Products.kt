package com.example.krishi

import android.media.Image


class Products {

    constructor():this("","","","")

//    var Title:String
//     get() {
//         return Title
//     }
//     set(value) {}
//
//  var Image:String
//        get() {
//            return Image
//        }
//        set(value) {}
//
//  var Description:String
//        get() {
//            return Description
//        }
//        set(value) {}
//
//  var Price:String
//        get() {
//            return Price
//        }
//        set(value) {}


//    constructor(Title: String, Image: String, Price: String, Description: String) : this() {
//        this.Title = Title
//        this.Image = Image
//        this.Price = Price
//        this.Description = Description
//    }

   var Title: String? = null
    var Image: String? = null
    var Price: String? = null
    var Description: String? = null

    constructor(Title: String?, Image: String?, Price: String?, Description: String?) {
        this.Title = Title
        this.Image = Image
        this.Price = Price
        this.Description = Description
    }
}
package com.multiverseofmovie.utils

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.showShortToast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showLongToast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
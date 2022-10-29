package com.example.androidguidestudy.util

import android.view.View

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */

fun View.visibleIf(condition:Boolean){
   this.visibility = if (condition) View.VISIBLE else View.GONE
}
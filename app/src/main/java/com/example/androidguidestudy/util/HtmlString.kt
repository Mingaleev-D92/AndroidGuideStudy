package com.example.androidguidestudy.util

import android.text.Spanned
import androidx.core.text.HtmlCompat

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */

inline class HtmlString(private val input:String){
   fun getValue(): Spanned {
      return HtmlCompat.fromHtml(input, HtmlCompat.FROM_HTML_MODE_LEGACY)
   }
}
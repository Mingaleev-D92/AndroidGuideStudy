package com.example.androidguidestudy.ui.fragments.adapter

import com.example.androidguidestudy.model.Article

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

interface ArticleClickListener {
   fun onArticleLicked(article: Article)
}
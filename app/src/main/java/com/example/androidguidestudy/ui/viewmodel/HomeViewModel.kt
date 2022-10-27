package com.example.androidguidestudy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.model.Article

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

class HomeViewModel(
   articleRepository: ArticleRepository
) : ViewModel() {

   private val _article: MutableLiveData<List<Article>> = MutableLiveData()
   val articles: LiveData<List<Article>> = _article

   init{
      val fetchedArticles = articleRepository.fetchArticles()
      _article.value = fetchedArticles
   }
}
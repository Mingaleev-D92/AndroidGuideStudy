package com.example.androidguidestudy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
      viewModelScope.launch {
         val fetchedArticles = withContext(Dispatchers.IO){
            articleRepository.fetchArticles()
         }
         _article.value = fetchedArticles
      }

   }
}
package com.example.androidguidestudy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.data.DataResponse
import com.example.androidguidestudy.data.remote.ArticleListViewState
import com.example.androidguidestudy.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

class HomeViewModel(
  private val articleRepository: ArticleRepository
) : ViewModel() {

   private val _state: MutableLiveData<ArticleListViewState> = MutableLiveData()
   val state: LiveData<ArticleListViewState> = _state

   init {
      fetchArticlesFromRepository()

   }
   private fun fetchArticlesFromRepository() {

      viewModelScope.launch {
         _state.value = ArticleListViewState.Loading

         val response = articleRepository.fetchArticles()
         _state.value = when (response) {
            is DataResponse.Success -> ArticleListViewState.Success(response.data)
            is DataResponse.Error -> ArticleListViewState.Error(response.error)
         }
      }
   }
   fun retryClicked(){
      fetchArticlesFromRepository()
   }


}

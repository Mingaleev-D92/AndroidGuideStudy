package com.example.androidguidestudy.data.remote

import com.example.androidguidestudy.model.Article

sealed class ArticleListViewState {
   object Loading : ArticleListViewState()
   data class Success(val articles: List<Article>) : ArticleListViewState()
   data class Error(val error: Throwable) : ArticleListViewState()
}

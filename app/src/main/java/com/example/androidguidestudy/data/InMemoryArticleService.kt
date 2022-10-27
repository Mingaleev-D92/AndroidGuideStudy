package com.example.androidguidestudy.data

import com.example.androidguidestudy.model.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

class InMemoryArticleService(
   private val ioDispatcher:CoroutineDispatcher = Dispatchers.IO
) : ArticleRepository {
   override suspend fun fetchArticles(): List<Article> =
    withContext(ioDispatcher){
       listOf(
          Article(
             title = "Article 1",
             authorName = "Adam 1",
             url = "https://dictionary.cambridge.org/ru/translate/"
          ),
          Article(
             title = "Article 2",
             authorName = "Adam 2",
             url = "https://dictionary.cambridge.org/ru/translate/"
          ),
          Article(
             title = "Article 3",
             authorName = "Adam 3",
             url = "https://dictionary.cambridge.org/ru/translate/"
          ),
          Article(
             title = "Article 4",
             authorName = "Adam 4",
             url = "https://dictionary.cambridge.org/ru/translate/"
          )
       )
    }
}
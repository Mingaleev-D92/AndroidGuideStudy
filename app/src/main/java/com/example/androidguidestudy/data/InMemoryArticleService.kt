package com.example.androidguidestudy.data

import com.example.androidguidestudy.model.Article

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

class InMemoryArticleService : ArticleRepository {
   override fun fetchArticles(): List<Article> =
      listOf(
         Article(
            title = "Article 1",
            authorName = "Adam 1",
            url = ""
         ),
         Article(
            title = "Article 2",
            authorName = "Adam 2",
            url = ""
         ),
         Article(
            title = "Article 3",
            authorName = "Adam 3",
            url = ""
         ),
         Article(
            title = "Article 4",
            authorName = "Adam 4",
            url = ""
         )
      )
}
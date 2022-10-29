package com.example.androidguidestudy.data.remote

import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.model.Article

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */

class AndroidEssenceArticleService(
   private val api: AndroidEssenceRetrofitApi
) : ArticleRepository {
   override suspend fun fetchArticles(): List<Article> {
      return api.getFeed().items?.map ( AndroidEssenceFeedItem::toArticle ).orEmpty()
   }
}

private fun AndroidEssenceFeedItem.toArticle(): Article {
   return Article(
      title = this.title.orEmpty(),
      authorName = this.author?.name.orEmpty(),
      url = this.link?.href.orEmpty()
   )
}
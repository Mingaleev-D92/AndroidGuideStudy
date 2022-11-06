package com.example.androidguidestudy.data.remote

import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.data.DataResponse
import com.example.androidguidestudy.model.Article
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */

class AndroidEssenceArticleService @Inject constructor(
   private val api: AndroidEssenceRetrofitApi
) : ArticleRepository {
   override suspend fun fetchArticles(): DataResponse<List<Article>> {
      return try {
         val articles = api.getFeed().items?.map(AndroidEssenceFeedItem::toArticle).orEmpty()
         DataResponse.Success(articles)
      } catch (e: Throwable) {
         DataResponse.Error(e)
      }
   }
}

private fun AndroidEssenceFeedItem.toArticle(): Article {
   return Article(
      title = this.title.orEmpty(),
      authorName = this.author?.name.orEmpty(),
      url = this.link?.href.orEmpty()
   )
}
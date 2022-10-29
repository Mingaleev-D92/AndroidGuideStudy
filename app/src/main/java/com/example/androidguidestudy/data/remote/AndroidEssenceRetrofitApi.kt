package com.example.androidguidestudy.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 29/10/2022
 */

interface AndroidEssenceRetrofitApi {
   @GET("feed.xml")
   suspend fun getFeed(): AndroidEssenceFeed

   companion object {
      private const val BASE_URL = "https://androidessence.com/"

      fun getDefaultApi():AndroidEssenceRetrofitApi{

         val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
         }
         val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

         return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(client)
            .build()
            .create(AndroidEssenceRetrofitApi::class.java)
      }
   }
}
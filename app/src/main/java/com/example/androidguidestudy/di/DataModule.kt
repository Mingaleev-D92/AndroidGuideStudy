package com.example.androidguidestudy.di

import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.data.remote.AndroidEssenceArticleService
import com.example.androidguidestudy.data.remote.AndroidEssenceRetrofitApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModule {

   @Binds
   abstract fun bindArticleRepository(
      androidEssenceArticleService: AndroidEssenceArticleService
   ): ArticleRepository

}
package com.example.androidguidestudy.di

import com.example.androidguidestudy.data.remote.AndroidEssenceRetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object RetrofitModule {

   @Provides
   fun provideAndroidEssenceRetrofitAPI(): AndroidEssenceRetrofitApi {
      return AndroidEssenceRetrofitApi.getDefaultApi()
   }

}
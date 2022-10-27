package com.example.androidguidestudy.data

import com.example.androidguidestudy.model.Article

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */
/*
любой источник отображаемых стотей
 */

interface ArticleRepository {
   fun fetchArticles():List<Article>
}
package com.example.androidguidestudy.ui.fragments.adapter

import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidguidestudy.R
import com.example.androidguidestudy.databinding.ListItemArticleBinding
import com.example.androidguidestudy.model.Article
import com.example.androidguidestudy.util.HtmlString

/**
 * @author : Mingaleev D
 * @data : 27/10/2022
 */

class ArticleAdapter(
   private val clickListener: ArticleClickListener
) : RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

   var articles: List<Article> = emptyList()
      set(value) {
         field = value
         notifyDataSetChanged()
      }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val inflater = LayoutInflater.from(parent.context)
      val binding = ListItemArticleBinding.inflate(inflater, parent, false)
      return MyViewHolder(binding, clickListener)
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val article = articles[position]
      holder.bind(article)
   }

   override fun getItemCount(): Int {
      return articles.size
   }

   inner class MyViewHolder(
      private val binding: ListItemArticleBinding,
      private val clickListener: ArticleClickListener
   ) :
      RecyclerView.ViewHolder(binding.root), View.OnClickListener {
      private var article: Article? = null

      init {
         binding.root.setOnClickListener(this)
      }

      fun bind(article: Article) {
         this.article = article
         binding.articleTitle.text = HtmlString(article.title).getValue()
         binding.articleAuthor.text = itemView.context.getString(
            R.string.by_author,
            article.authorName
         )


      }

      override fun onClick(v: View?) {
         article?.let { clickListener::onArticleLicked }
      }
   }
}
package com.example.androidguidestudy.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidguidestudy.data.ArticleRepository
import com.example.androidguidestudy.data.InMemoryArticleService
import com.example.androidguidestudy.data.remote.AndroidEssenceArticleService
import com.example.androidguidestudy.data.remote.AndroidEssenceRetrofitApi
import com.example.androidguidestudy.databinding.FragmentHomeBinding
import com.example.androidguidestudy.model.Article
import com.example.androidguidestudy.ui.fragments.adapter.ArticleAdapter
import com.example.androidguidestudy.ui.fragments.adapter.ArticleClickListener
import com.example.androidguidestudy.ui.viewmodel.HomeViewModel


class HomeFragment : Fragment(), ArticleClickListener {
   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   private val adapter by lazy { ArticleAdapter(clickListener = this) }

   private lateinit var homeViewModel: HomeViewModel

   private val homeViewModelFactory = object :ViewModelProvider.Factory{
      override fun <T : ViewModel> create(modelClass: Class<T>): T {
         val repository:ArticleRepository =AndroidEssenceArticleService(
            api = AndroidEssenceRetrofitApi.getDefaultApi()
         )

         return HomeViewModel(articleRepository = repository) as T
      }
   }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      homeViewModel = ViewModelProvider(this,homeViewModelFactory)[HomeViewModel::class.java]
   }

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      setupRecyclerView()
      subscribeToViewModel()

   }

   private fun subscribeToViewModel() {
         homeViewModel.articles.observe(viewLifecycleOwner) {
            adapter.articles = it
      }
   }

   private fun setupRecyclerView() {
      binding.articleListRv.adapter = adapter
      binding.articleListRv.layoutManager = LinearLayoutManager(context)
      val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
      binding.articleListRv.addItemDecoration(dividerItemDecoration)
   }

   override fun onArticleLicked(article: Article) {
      val url = Uri.parse(article.url)
      val intent = Intent(Intent.ACTION_VIEW, url)
      startActivity(intent)
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }


}
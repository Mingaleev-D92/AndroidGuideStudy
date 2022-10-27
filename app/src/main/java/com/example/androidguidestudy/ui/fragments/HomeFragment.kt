package com.example.androidguidestudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidguidestudy.databinding.FragmentHomeBinding
import com.example.androidguidestudy.ui.fragments.adapter.ArticleAdapter


class HomeFragment : Fragment() {
   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   private val adapter by lazy { ArticleAdapter() }

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

   }

   private fun setupRecyclerView() {
      with(binding) {
         with(articleListRv) {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
         }
      }
      val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
      binding.articleListRv.addItemDecoration(dividerItemDecoration)
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }


}
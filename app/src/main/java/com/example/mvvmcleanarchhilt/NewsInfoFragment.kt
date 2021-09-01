package com.example.mvvmcleanarchhilt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.mvvmcleanarchhilt.databinding.FragmentNewsInfoBinding
import com.example.mvvmcleanarchhilt.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.zip.Inflater

class NewsInfoFragment : Fragment() {

    private lateinit var fragmentNewsInfoBinding: FragmentNewsInfoBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsInfoBinding = FragmentNewsInfoBinding.bind(view)

        val args : NewsInfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        viewModel = (activity as MainActivity).viewModel

        fragmentNewsInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if(article.url!=null){
                loadUrl(article.url)
            }
        }

        fragmentNewsInfoBinding.fabSave.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view,"Saved Successfully!",Snackbar.LENGTH_LONG).show()
        }
    }

}
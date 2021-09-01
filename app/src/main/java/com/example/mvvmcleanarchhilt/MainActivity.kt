package com.example.mvvmcleanarchhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmcleanarchhilt.databinding.ActivityMainBinding
import com.example.mvvmcleanarchhilt.presentation.adapter.NewsAdapter
import com.example.mvvmcleanarchhilt.presentation.viewmodel.NewsViewModel
import com.example.mvvmcleanarchhilt.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**

 Save secure data in gradle properties file e.g. key and add gradle.properties in .gitignore file
 Best practice : to store it in backend and receive it after authentication
 Refer -> https://guides.codepath.com/android/Storing-Secret-Keys-in-Android#hidden-in-buildconfigs
 Refer -> https://developer.android.com/training/articles/keystore

 MockWebServer : A Lib to test API i.e. A scriptable web server for testing HTTP clients
                 Refer: https://github.com/square/okhttp/tree/master/mockwebserver
**/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter:NewsAdapter
    lateinit var viewModel : NewsViewModel

    private lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        activityMainBinding.bottomNav.setupWithNavController(navController)

        viewModel = ViewModelProvider(this,factory).get(NewsViewModel::class.java)
    }
}
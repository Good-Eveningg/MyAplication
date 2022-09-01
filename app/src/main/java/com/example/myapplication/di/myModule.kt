package com.example.myapplication.di

import com.example.myapplication.data.sharedPref.data.ShredPref
import com.example.myapplication.ui.MainActivityViewModel
import com.example.myapplication.ui.detailedFragment.DetailedFragmentViewModel
import com.example.myapplication.ui.firstFragment.FirstFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single { ShredPref(androidContext()) }
}

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { DetailedFragmentViewModel(get()) }
    viewModel { FirstFragmentViewModel() }
}
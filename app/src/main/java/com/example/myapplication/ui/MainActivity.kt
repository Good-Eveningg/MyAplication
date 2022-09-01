package com.example.myapplication.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.R
import com.example.myapplication.bcReciever.BcReceiver
import com.example.myapplication.data.APP
import com.example.myapplication.data.BUNDLE_KEY
import com.example.myapplication.services.myService.MyService
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private val myBcReceiver = BcReceiver()
    private val intentFilter = IntentFilter("com.example.myapplication.MY_NOTIFICATION")
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    val navController by lazy { navHostFragment.navController }
    private val mainViewModel by viewModel<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP = this
        setContentView(R.layout.activity_main)
        startForegroundService(Intent(this, MyService::class.java))
        registerReceiver(myBcReceiver, intentFilter)

    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBcReceiver)
        stopService(Intent(this, MyService::class.java))
    }

    fun setScreen() {
        val bundle = Bundle()
        if (mainViewModel.getSharedpref() >= 0) {
           val item = mainViewModel.getItem(mainViewModel.getSharedpref())
            bundle.putSerializable(BUNDLE_KEY,item)
            navController.navigate(R.id.action_firstFragment_to_detailedFragment, bundle)
        }
    }
}
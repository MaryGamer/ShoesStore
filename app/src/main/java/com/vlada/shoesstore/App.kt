package com.vlada.shoesstore

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import io.paperdb.Paper

/**
 * Created by Vlada on 04.04.2018.
 */


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }


    fun isOnline(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}
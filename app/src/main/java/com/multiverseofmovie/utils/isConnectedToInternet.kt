package com.multiverseofmovie.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isConnectedToInternet(context: Context?) =
    (context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
        getNetworkCapabilities(activeNetwork)?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } ?: false
    }
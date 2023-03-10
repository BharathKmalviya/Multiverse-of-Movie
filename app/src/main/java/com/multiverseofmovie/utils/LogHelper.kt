package com.multiverseofmovie.utils

import android.util.Log
import com.multiverseofmovie.BuildConfig

// LogHelper is a helper class to print logs in debug mode
object LogHelper {
    fun systemOutPrint(log_str: String?) {
        if (BuildConfig.DEBUG) println(log_str)
    }

    fun systemErrPrint(log_str: String?) {
        if (BuildConfig.DEBUG) System.err.println(log_str)
    }

    fun printStackTrace(e: Exception) {
        if (BuildConfig.DEBUG) e.printStackTrace()
    }

    fun printStackTrace(t: Throwable) {
        if (BuildConfig.DEBUG) t.printStackTrace()
    }

    fun logD(tag: String?, log_str: String?) {
        if (BuildConfig.DEBUG) Log.d(tag, log_str!!)
    }

    fun logE(tag: String?, log_str: String?) {
        if (BuildConfig.DEBUG) Log.e(tag, log_str!!)
    }

    fun logI(tag: String?, log_str: String?) {
        if (BuildConfig.DEBUG) Log.i(tag, log_str!!)
    }

    fun logV(tag: String?, log_str: String?) {
        if (BuildConfig.DEBUG) Log.v(tag, log_str!!)
    }

    fun logW(tag: String?, log_str: String?) {
        if (BuildConfig.DEBUG) Log.w(tag, log_str!!)
    }
}
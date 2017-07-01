package com.example.riteshkumarsingh.todoapp

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}
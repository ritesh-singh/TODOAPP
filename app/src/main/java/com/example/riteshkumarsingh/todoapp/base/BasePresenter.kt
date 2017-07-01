package com.example.riteshkumarsingh.todoapp.base

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
interface BasePresenter {
    fun onCreate()
    fun onStart()
    fun onStop()
    fun onDestroy()
}
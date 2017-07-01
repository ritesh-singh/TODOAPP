package com.example.riteshkumarsingh.todoapp.ui.view

import android.content.Context
import com.example.riteshkumarsingh.todoapp.data.source.local.Task

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
interface MainView {
    fun getContext():Context
    fun onGetAllTaskSuccess(tasks:List<Task>?)
    fun onInsertTaskSuccess():Unit
}
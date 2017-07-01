package com.example.riteshkumarsingh.todoapp.ui.presenter

import com.example.riteshkumarsingh.todoapp.base.BasePresenter
import com.example.riteshkumarsingh.todoapp.data.source.local.AppDatabase
import com.example.riteshkumarsingh.todoapp.ui.view.MainView

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
class MainActivityPresenter(view: MainView) : BasePresenter {
    var appDB: AppDatabase? = null

    init {
        appDB = AppDatabase.getInMemoryDatabase(view.getContext())
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
    }
}
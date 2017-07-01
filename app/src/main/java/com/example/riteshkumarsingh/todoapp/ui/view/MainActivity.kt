package com.example.riteshkumarsingh.todoapp.ui.view

import android.content.Context
import android.os.Bundle
import com.example.riteshkumarsingh.todoapp.R
import com.example.riteshkumarsingh.todoapp.base.BaseActivity
import com.example.riteshkumarsingh.todoapp.ui.presenter.MainActivityPresenter

class MainActivity : BaseActivity(), MainView {

    var mPresenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainActivityPresenter(this)
    }

    override fun getContext(): Context {
        return getContext()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
    }
}

package com.example.riteshkumarsingh.todoapp.ui.view

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.riteshkumarsingh.todoapp.R
import com.example.riteshkumarsingh.todoapp.base.BaseActivity
import com.example.riteshkumarsingh.todoapp.data.source.local.Task
import com.example.riteshkumarsingh.todoapp.ui.presenter.MainActivityPresenter
import com.example.riteshkumarsingh.todoapp.ui.view.adapter.RecyclerViewAdapter

class MainActivity : BaseActivity(), MainView {

    var mPresenter: MainActivityPresenter? = null

    var editText: EditText? = null
    var recyclerView: RecyclerView? = null
    var addButton: Button? = null
    var rvAdapter:RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text) as? EditText
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        addButton = findViewById(R.id.add) as Button?
        mPresenter = MainActivityPresenter(this)
        initUI()
        initListeners()
    }

    private fun initListeners() {
        addButton?.setOnClickListener(View.OnClickListener {
            var text = editText?.text.toString()
            if (!(TextUtils.isEmpty(text) || text == null)) {
                var task: Task = Task()
                task.name = text
                mPresenter?.insertDataInDb(task)
            }
        })
    }


    override fun onGetAllTaskSuccess(tasks: MutableList<Task>?) {
        rvAdapter = RecyclerViewAdapter(tasks)
        recyclerView?.adapter = rvAdapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }


    override fun onInsertTaskSuccess(task:Task) {
        editText?.clearFocus()
        editText?.setText("")
        rvAdapter?.addItem(task)
    }

    private fun initUI() {
        mPresenter?.getAllTasks()
    }


    override fun getContext(): Context {
        return applicationContext
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
    }
}

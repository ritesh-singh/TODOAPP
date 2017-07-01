package com.example.riteshkumarsingh.todoapp.ui.presenter

import android.os.AsyncTask
import com.example.riteshkumarsingh.todoapp.base.BasePresenter
import com.example.riteshkumarsingh.todoapp.data.source.local.AppDatabase
import com.example.riteshkumarsingh.todoapp.data.source.local.Task
import com.example.riteshkumarsingh.todoapp.ui.view.MainView

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
class MainActivityPresenter(view: MainView) : BasePresenter {
    private val view = view
    private var appDB: AppDatabase? = null
    private var asyncTaskGetAllTask: AsyncTask<Void, Void, List<Task>>? = null
    private var asyncTaskInsertDataInDb: AsyncTask<Void, Void, Void>? = null

    init {
        appDB = AppDatabase.getInMemoryDatabase(this.view.getContext())
    }


    fun getAllTasks() {
        asyncTaskGetAllTask = object : AsyncTask<Void, Void, List<Task>>() {
            override fun doInBackground(vararg params: Void): List<Task>? {
                return appDB?.taskDao()
                        ?.findAllTasks()
            }

            override fun onPostExecute(result: List<Task>?) {
                super.onPostExecute(result)
                view.onGetAllTaskSuccess(result)
            }
        }

        asyncTaskGetAllTask?.execute()
    }

    fun insertDataInDb(task: Task) {
        asyncTaskInsertDataInDb = object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void): Void? {
                appDB?.taskDao()
                        ?.insertTask(task)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                view.onInsertTaskSuccess()
            }
        }
        asyncTaskInsertDataInDb?.execute()
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
        asyncTaskGetAllTask?.cancel(true)
        asyncTaskInsertDataInDb?.cancel(true)
    }
}
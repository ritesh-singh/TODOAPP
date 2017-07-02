package com.example.riteshkumarsingh.todoapp.ui.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.example.riteshkumarsingh.todoapp.R
import com.example.riteshkumarsingh.todoapp.data.source.local.Task

/**
 * Created by riteshkumarsingh on 02/07/17.
 */
class RecyclerViewAdapter(task: MutableList<Task>?) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val tasks: MutableList<Task>? = task

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val task = tasks?.get(position)
        holder?.name?.text = task?.name
        if (task?.mCompleted == null) holder?.checkBox?.isChecked = false else
            holder?.checkBox?.isChecked = task?.mCompleted
        holder?.creationDateView?.text = task?.createdOn?.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks?.size ?: 0
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView?.findViewById(R.id.name) as TextView
        var checkBox: CheckBox = itemView?.findViewById(R.id.checkbox) as CheckBox
        var creationDateView: TextView = itemView?.findViewById(R.id.creation_date) as TextView
    }

    fun addItem(task: Task) {
        tasks?.add(task)
        notifyItemInserted(itemCount - 1)
    }
}
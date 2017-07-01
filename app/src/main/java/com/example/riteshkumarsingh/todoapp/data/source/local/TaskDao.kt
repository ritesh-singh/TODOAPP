package com.example.riteshkumarsingh.todoapp.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Created by riteshkumarsingh on 01/07/17.
 */

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun findAllTasks(): List<Task>

}
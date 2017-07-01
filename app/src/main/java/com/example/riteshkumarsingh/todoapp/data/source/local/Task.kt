package com.example.riteshkumarsingh.todoapp.data.source.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
@Entity
class Task {
    @PrimaryKey
    val id: String? = null
    val name: String? = null
    val mDescription: String? = null
    @Ignore
    val mCompleted: Boolean = false
}
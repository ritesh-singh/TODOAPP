package com.example.riteshkumarsingh.todoapp.data.source.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import java.util.*

/**
 * Created by riteshkumarsingh on 01/07/17.
 */
@Entity
class Task {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""
    var createdOn: Date? = null
    var mCompleted: Boolean = false
}
package com.example.riteshkumarsingh.todoapp.data.source.local

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by riteshkumarsingh on 02/07/17.
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long? {
        return date?.time
    }

}
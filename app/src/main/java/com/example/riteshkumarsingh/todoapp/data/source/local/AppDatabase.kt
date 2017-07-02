package com.example.riteshkumarsingh.todoapp.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.TypeConverters
import android.content.Context


/**
 * Created by riteshkumarsingh on 01/07/17.
 */

@Database(entities = arrayOf(Task::class), version = 1)
@TypeConverters(*arrayOf(DateConverter::class))
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object Factory {
        private var instance: AppDatabase? = null
        fun getInMemoryDatabase(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "todo_list").build()
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}
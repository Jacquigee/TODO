package com.maskerteers.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var databaseInstance: AppDatabase? = null

        fun getDatabaseInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = databaseInstance

                if (instance == null) {
                    instance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "app_database",
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    databaseInstance = instance
                }
                return instance
            }
        }
    }
}


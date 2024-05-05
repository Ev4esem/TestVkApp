package com.example.testvkapp.data.local_layer

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao() : NewsDao

}
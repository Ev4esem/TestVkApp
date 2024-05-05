package com.example.testvkapp.data.local_layer

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter {

    @TypeConverter
    fun fromStringList(list : List<String>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toStringList(list : String) : List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(list, listType)
    }


}
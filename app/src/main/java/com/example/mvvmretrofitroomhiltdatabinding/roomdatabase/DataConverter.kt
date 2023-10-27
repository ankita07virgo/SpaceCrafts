package com.example.mvvmretrofitroomhiltdatabinding.roomdatabase

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    @TypeConverter
    fun fromArrayListString(value : List<String>) : String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value : String) : List<String>{
        return try{
            Gson().fromJson<List<String>>(value)
        }
        catch (e : Exception){
            listOf()
        }
    }

    inline fun <reified T> Gson.fromJson(json : String) = fromJson<T>(json,object : TypeToken<T>() {}.type)
    inline fun <reified T> Gson.fromJsonX(json : T){
        T::class.java
    }
}
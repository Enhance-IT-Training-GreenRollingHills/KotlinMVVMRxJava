package com.cc.kotlinmvvmrxjava.model.db

import androidx.room.TypeConverter
import com.cc.kotlinmvvmrxjava.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converter {

    @TypeConverter
    fun fromListToJsonString(list: List<Result>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Result>>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun fromJsonStringToList(string: String?): List<Result>? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Result>>() {}.type
        return gson.fromJson<List<Result>>(string, type)
    }

    @TypeConverter
    fun jsonStringToTimeZone(string: String?): Timezone  = Gson().fromJson(string,Timezone::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Timezone?): String =Gson().toJson(obj)

    @TypeConverter
    fun jsonStringToResult(string: String?): Result  = Gson().fromJson(string,Result::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Result?): String =Gson().toJson(obj)



    @TypeConverter
    fun jsonStringToRegistered(string: String?): Registered  = Gson().fromJson(string,Registered::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Registered?): String =Gson().toJson(obj)



    @TypeConverter
    fun jsonStringToPicture(string: String?): Picture  = Gson().fromJson(string,Picture::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Picture?): String =Gson().toJson(obj)



    @TypeConverter
    fun jsonStringToName(string: String?): Name  = Gson().fromJson(string,Name::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Name?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToLogin(string: String?): Login  = Gson().fromJson(string,Login::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Login?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToLocation(string: String?): Location  = Gson().fromJson(string,Location::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Location?): String =Gson().toJson(obj)





    @TypeConverter
    fun jsonStringToInfo(string: String?): Info  = Gson().fromJson(string,Info::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Info?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToId(string: String?): Id  = Gson().fromJson(string,Id::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Id?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToDob(string: String?): Dob  = Gson().fromJson(string,Dob::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Dob?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToCoordinates(string: String?): Coordinates  = Gson().fromJson(string,Coordinates::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Coordinates?): String =Gson().toJson(obj)




    @TypeConverter
    fun jsonStringToStreet(string: String?): Street  = Gson().fromJson(string,Street::class.java)

    @TypeConverter
    fun itemEntityToString(obj: Street?): String =Gson().toJson(obj)
}
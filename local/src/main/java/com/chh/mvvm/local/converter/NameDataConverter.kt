package com.chh.mvvm.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.chh.mvvm.data.model.NameData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class NameDataConverter @Inject constructor(
    private val moshi: Moshi,
) {

    @TypeConverter
    fun fromString(value: String): List<NameData>? {
        val listType = Types.newParameterizedType(List::class.java, NameData::class.java)
        val adapter: JsonAdapter<List<NameData>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromNameData(type: List<NameData>?): String {
        val listType = Types.newParameterizedType(List::class.java, NameData::class.java)
        val adapter: JsonAdapter<List<NameData>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

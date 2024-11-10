package com.chh.cleanarchitecture.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.chh.cleanarchitecture.data.model.TypeData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class TypeDataConverter @Inject constructor(
    private val moshi: Moshi,
) {

    @TypeConverter
    fun fromString(value: String): List<TypeData>? {
        val listType = Types.newParameterizedType(List::class.java, TypeData::class.java)
        val adapter: JsonAdapter<List<TypeData>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromTypeData(type: List<TypeData>?): String {
        val listType = Types.newParameterizedType(List::class.java, TypeData::class.java)
        val adapter: JsonAdapter<List<TypeData>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

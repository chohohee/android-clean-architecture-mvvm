package com.chh.mvvm.data.mapper

interface DataToDomainMapper<T> {
    fun toDomain(): T
}
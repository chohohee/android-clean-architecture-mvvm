package com.chh.cleanarchitecture.data.mapper

interface DataToDomainMapper<T> {
    fun toDomain(): T
}
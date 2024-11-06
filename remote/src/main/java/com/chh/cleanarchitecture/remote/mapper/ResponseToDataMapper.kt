package com.chh.cleanarchitecture.remote.mapper

interface ResponseToDataMapper<T> {
    fun toData(): T
}
package com.chh.mvvm.remote.mapper

interface ResponseToDataMapper<T> {
    fun toData(): T
}
package com.chh.cleanarchitecture.data.util

import androidx.paging.PagingSource.LoadParams

internal fun getLimit(params: LoadParams<Int>, key: Int): Int =
    when (params) {
        is LoadParams.Prepend -> {
            if (key < params.loadSize) {
                key
            } else {
                params.loadSize
            }
        }

        else -> params.loadSize
    }

internal fun getOffset(params: LoadParams<Int>, key: Int, itemCount: Int): Int =
    when (params) {
        is LoadParams.Prepend -> {
            if (key < params.loadSize) {
                0
            } else {
                key - params.loadSize
            }
        }

        is LoadParams.Append -> key
        is LoadParams.Refresh -> {
            if (key >= itemCount) {
                maxOf(0, itemCount - params.loadSize)
            } else {
                key
            }
        }
    }
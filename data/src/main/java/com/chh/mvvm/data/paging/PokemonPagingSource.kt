package com.chh.mvvm.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.data.utils.getLimit
import com.chh.mvvm.data.utils.getOffset

internal class PokemonPagingSource(
    private val local: PokemonLocalDataSource
) : PagingSource<Int, PokemonData>() {

    private var itemCount = INITIAL_ITEM_COUNT

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonData> =
        try {
            if (itemCount == INITIAL_ITEM_COUNT) {
                itemCount = getDatabaseItemCount()
            }
            loadData(params, itemCount)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, PokemonData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        return maxOf(0, anchorPosition - state.config.initialLoadSize / 2)
    }

    private suspend fun getDatabaseItemCount(): Int = local.getPokemonCount()

    private suspend fun loadData(
        params: LoadParams<Int>,
        itemCount: Int
    ): LoadResult<Int, PokemonData> {

        val key = params.key ?: 0
        val limit = getLimit(params, key)
        val offset = getOffset(params, key, itemCount)
        val data = local.getPokemonList(limit, offset)

        val nextOffset = offset + data.size
        val hasNotNextPage = data.isEmpty() || data.size < limit || nextOffset >= itemCount
        val nextKey = if (hasNotNextPage) null else nextOffset
        val prevKey = if (offset <= 0 || data.isEmpty()) null else offset

        return LoadResult.Page(
            data = data,
            prevKey = prevKey,
            nextKey = nextKey,
            itemsBefore = offset,
            itemsAfter = maxOf(0, itemCount - nextOffset)
        )
    }

    companion object {
        const val INITIAL_ITEM_COUNT = -1
    }
}

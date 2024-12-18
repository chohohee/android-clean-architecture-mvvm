package com.chh.mvvm.data.paging

import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.data.source.PokemonRemoteDataSource
import javax.inject.Inject
import com.chh.mvvm.data.utils.Result

internal class PokemonRemoteMediator @Inject constructor(
    private val local: PokemonLocalDataSource,
    private val remote: PokemonRemoteDataSource
) : RemoteMediator<Int, PokemonData>() {

    override suspend fun initialize(): InitializeAction =
        if (local.getPokemonCount() > 0) SKIP else LAUNCH

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonData>
    ): MediatorResult {

        val offset = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> local.getPokemonCount()
        }

        val limit = if (loadType == LoadType.REFRESH) {
            state.config.initialLoadSize
        } else {
            state.config.pageSize
        }

        when (val result = remote.fetchPokemonPaged(limit = limit, offset = offset)) {
            is Result.Success -> {
                val pokemonDataList = result.data.results
                val endOfPaginationReached = pokemonDataList.size < limit

                local.insertAll(pokemonDataList)
                notifyListeners()

                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            }

            is Result.Error -> return MediatorResult.Error(result.error)
        }
    }

    private var listeners = arrayListOf<() -> Unit>()

    fun addListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    private fun removeListener(listener: () -> Unit) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        ArrayList(listeners).forEach {
            it()
            removeListener(it)
        }
    }

    companion object {
        val SKIP = InitializeAction.SKIP_INITIAL_REFRESH
        val LAUNCH = InitializeAction.LAUNCH_INITIAL_REFRESH
    }
}

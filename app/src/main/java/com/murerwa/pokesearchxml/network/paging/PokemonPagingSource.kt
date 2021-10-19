package com.murerwa.pokesearchxml.network.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.murerwa.pokesearchxml.network.resources.Constants.DEFAULT_PAGE_SIZE
import com.murerwa.pokesearchxml.network.resources.Constants.STARTING_PAGING_INDEX
import com.murerwa.pokesearchxml.network.retrofit.PokemonApi
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokemonDto
import retrofit2.HttpException
import java.io.IOException

class PokemonPagingSource constructor(private val apiClient: PokemonApi) :
    PagingSource<Int, PokemonDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonDto> {
        val page = params.key ?: STARTING_PAGING_INDEX

        val defaultPageLimit = DEFAULT_PAGE_SIZE

        return try {
            val networkResponse = apiClient.getPokemonList(offset = page+20)

            Log.d("PAGING SOURCE", networkResponse.next)

            LoadResult.Page(
                data = networkResponse.results,
                prevKey = if (page == STARTING_PAGING_INDEX) null else page - defaultPageLimit,
                nextKey = if (page >= networkResponse.count) null else page + defaultPageLimit
            )

        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonDto>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            val anchorPage = state.closestPageToPosition(anchorPos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
package com.murerwa.pokesearchxml.presentation.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.murerwa.pokesearchxml.network.repositories.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

//    fun getPokemonList(): Flow<Resource<List<Pokemon>>> = flow {
//        try {
//            emit(Resource.Loading())
//
//            // Load pokemon from list
//            val pokemon = repository.getPokemonList(0, 20).result.map { it.toPokemon() }
//
//            emit(Resource.Success(pokemon))
//        } catch(e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
//        } catch(e: IOException) {
//            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
//        }
//    }

    suspend fun getPokemonList() = repository.getPokemonList().cachedIn(viewModelScope)
}
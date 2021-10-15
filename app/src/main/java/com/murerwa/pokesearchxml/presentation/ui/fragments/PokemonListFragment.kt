package com.murerwa.pokesearchxml.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murerwa.pokesearchxml.R
import com.murerwa.pokesearchxml.databinding.FragmentPokemonListBinding
import com.murerwa.pokesearchxml.presentation.ui.adapters.PokemonListAdapter
import com.murerwa.pokesearchxml.presentation.viewmodels.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class PokemonListFragment: Fragment(R.layout.fragment_pokemon_list) {
    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonListViewModel by viewModels()

    private val pokemonAdapter by lazy {
        PokemonListAdapter()
    }

    private lateinit var rvPokemonList: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPokemonListBinding.bind(view)

        initUi()
    }

    private fun initUi() {
        // Initialize all views
        binding.apply {
            rvPokemonList = this.recyclerViewPokemon
        }

        // Set up recyclerview properties
        rvPokemonList.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = pokemonAdapter
        }

        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        lifecycleScope.launchWhenResumed {
            viewModel.getPokemonList().collect {
                pokemonAdapter.submitData(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}
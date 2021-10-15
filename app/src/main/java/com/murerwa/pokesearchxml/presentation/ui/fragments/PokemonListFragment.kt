package com.murerwa.pokesearchxml.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.murerwa.pokesearchxml.R
import com.murerwa.pokesearchxml.databinding.FragmentPokemonListBinding

class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {
    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPokemonListBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}
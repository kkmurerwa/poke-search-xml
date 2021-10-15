package com.murerwa.pokesearchxml.presentation.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.murerwa.pokesearchxml.data.models.Pokemon
import com.murerwa.pokesearchxml.databinding.ListItemPokemonBinding
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokemonDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.toPokemon

class PokemonListAdapter: PagingDataAdapter<PokemonDto, PokemonListAdapter.MyViewHolder>(PokemonComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ListItemPokemonBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val context = holder.itemView.context
        val pokemon = getItem(position)!!.toPokemon()

        holder.bindView(context, pokemon)
    }

    class MyViewHolder(private val binding: ListItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindView(context: Context, pokemon: Pokemon) {
            binding.textViewPokemonName.text = pokemon.name
        }
    }

    object PokemonComparator : DiffUtil.ItemCallback<PokemonDto>() {
        override fun areItemsTheSame(oldItem: PokemonDto, newItem: PokemonDto): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PokemonDto, newItem: PokemonDto): Boolean {
            return oldItem == newItem
        }

    }
}
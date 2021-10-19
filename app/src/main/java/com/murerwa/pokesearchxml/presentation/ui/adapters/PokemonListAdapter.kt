package com.murerwa.pokesearchxml.presentation.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.murerwa.pokesearchxml.R
import com.murerwa.pokesearchxml.data.models.Pokemon
import com.murerwa.pokesearchxml.databinding.ListItemPokemonBinding
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokemonDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.toPokemon
import kotlin.random.Random

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

            val imageViewPokemon = binding.imageViewPokemonSprite

            // Create spinner drawable for the glide placeholder
            val progressDrawable = CircularProgressDrawable(binding.root.context)
            progressDrawable.strokeWidth = 5f
            progressDrawable.centerRadius = 30f
            progressDrawable.start()

            // Generate random card color
            val from = 80
            val to = 256

            val color: Int = Color.argb(255, (from..to).random(), (from..to).random(), (from..to).random())
            binding.materialCardSprite.setBackgroundColor(color)

            // Create a custom load error placeholder for glide based on gender
            val customDrawable = R.drawable.pikachu

            val arrOfUrl = pokemon.url.split("/")

            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${arrOfUrl[6]}.png")
                .placeholder(progressDrawable)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(customDrawable)
                .fallback(customDrawable)
                .into(binding.imageViewPokemonSprite)
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
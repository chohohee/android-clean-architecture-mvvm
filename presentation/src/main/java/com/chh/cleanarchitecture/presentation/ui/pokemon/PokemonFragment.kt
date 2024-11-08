package com.chh.cleanarchitecture.presentation.ui.pokemon

import androidx.fragment.app.viewModels
import com.chh.cleanarchitecture.presentation.R
import com.chh.cleanarchitecture.presentation.databinding.FragmentPokemonBinding
import com.chh.cleanarchitecture.presentation.ui.adapter.PokemonPagingAdapter
import com.chh.cleanarchitecture.presentation.ui.base.BaseFragment
import com.chh.cleanarchitecture.presentation.util.launchAndRepeatWithViewLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment : BaseFragment<FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    private val viewModel: PokemonViewModel by viewModels()

    private val pokemonAdapter by lazy { PokemonPagingAdapter() }

    override fun initView() {
        with(binding) {
            vm = viewModel
            adapter = pokemonAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        launchAndRepeatWithViewLifecycle {
            launch { pokemon.collect { pokemonAdapter.submitData(it) } }
        }
    }
}
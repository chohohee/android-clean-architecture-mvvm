package com.chh.cleanarchitecture.presentation.ui.pokemon

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import com.chh.cleanarchitecture.presentation.R
import com.chh.cleanarchitecture.presentation.databinding.FragmentPokemonBinding
import com.chh.cleanarchitecture.presentation.ui.adapter.PokemonPagingAdapter
import com.chh.cleanarchitecture.presentation.ui.base.BaseFragment
import com.chh.cleanarchitecture.presentation.util.launchAndRepeatWithViewLifecycle
import com.chh.cleanarchitecture.presentation.ui.pokemon.PokemonViewModel.NavigationState.PokemonDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment : BaseFragment<FragmentPokemonBinding>(R.layout.fragment_pokemon) {

    private val viewModel: PokemonViewModel by viewModels()

    private val pokemonAdapter by lazy { PokemonPagingAdapter(viewModel::onPokemonClicked) }

    private val loadStateListener: (CombinedLoadStates) -> Unit =
        { viewModel.onLoadStateUpdate(it) }

    override fun initView() {
        with(binding) {
            vm = viewModel
            adapter = pokemonAdapter
        }

        setupListener()
        observeViewModel()
    }

    private fun setupListener() {
        pokemonAdapter.addLoadStateListener(loadStateListener)
    }

    private fun observeViewModel() = with(viewModel) {
        launchAndRepeatWithViewLifecycle {
            launch { pokemon.collect { pokemonAdapter.submitData(it) } }
            launch { navigationState.collect { handleNavigationState(it) } }
        }
    }

    private fun handleNavigationState(state: PokemonViewModel.NavigationState) = when (state) {
        is PokemonDetails -> {
            findNavController().navigateUp()
            findNavController().navigate(PokemonFragmentDirections.actionPokemonToDetail(state.pokemon))
        }
    }
}
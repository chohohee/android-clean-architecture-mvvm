package com.chh.mvvm.presentation.ui.details

import androidx.fragment.app.viewModels
import com.chh.mvvm.presentation.R
import com.chh.mvvm.presentation.databinding.FragmentDetailBinding
import com.chh.mvvm.presentation.ui.adapter.PokemonTypeAdapter
import com.chh.mvvm.presentation.ui.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseBottomSheetDialogFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val viewModel by viewModels<DetailViewModel>()

    private val pokemonTypeAdapter by lazy { PokemonTypeAdapter() }

    override fun initView() {
        with(binding) {
            vm = viewModel
            adapter = pokemonTypeAdapter
        }
    }
}

package com.chh.cleanarchitecture.presentation.ui.details

import androidx.navigation.fragment.navArgs
import com.chh.cleanarchitecture.presentation.R
import com.chh.cleanarchitecture.presentation.databinding.FragmentDetailBinding
import com.chh.cleanarchitecture.presentation.ui.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseBottomSheetDialogFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    override fun initView() {
        with(binding) {
            pokemon = args.pokemon
        }
    }
}

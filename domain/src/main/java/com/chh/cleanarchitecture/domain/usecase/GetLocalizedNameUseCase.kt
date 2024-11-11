package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.Name
import java.util.Locale
import javax.inject.Inject

class GetLocalizedNameUseCase @Inject constructor() {

    operator fun invoke(names: List<Name>?): String? =
        names?.find {
            it.language == Locale.getDefault().language
        }?.name
}

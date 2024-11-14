package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.Name
import java.util.Locale
import javax.inject.Inject

class GetLocalizedNameUseCase @Inject constructor() {

    operator fun invoke(names: List<Name>?): String? =
        names?.find { it.language == Locale.getDefault().language }?.name
}

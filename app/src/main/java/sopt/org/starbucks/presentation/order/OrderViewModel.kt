package sopt.org.starbucks.presentation.order

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sopt.org.starbucks.domain.repository.DummyRepository
import javax.inject.Inject

@HiltViewModel
class OrderViewModel
    @Inject
    constructor(
        private val dummyRepository: DummyRepository
    ) : ViewModel()

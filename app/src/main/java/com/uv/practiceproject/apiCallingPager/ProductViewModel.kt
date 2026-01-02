package com.uv.practiceproject.apiCallingPager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

class ProductViewModel(repo: ProductPager = ProductPager()): ViewModel() {

    val productFlow = repo.getProduct().flow.cachedIn(viewModelScope)
}
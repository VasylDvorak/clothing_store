package com.geekbrains.clothing_store.android.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import com.geekbrains.clothing_store.ProductApi
import com.geekbrains.clothing_store.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private var _requestState:MutableState<RequestState> = mutableStateOf(RequestState.Idle)
    val requestState: State<RequestState> = _requestState;

    init {
        viewModelScope.launch (Dispatchers.Main) {
            ProductApi().fetchProducts(limit = 10).collectLatest {
                _requestState.value = it
            }
        }
    }
}
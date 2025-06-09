package com.example.instagram

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainActivityViewModel : ViewModel() {
    private var _clicked = MutableStateFlow(true)
    var clicked = _clicked.asStateFlow()

    fun changedClicked(){
        _clicked.update { !_clicked.value }
    }
}
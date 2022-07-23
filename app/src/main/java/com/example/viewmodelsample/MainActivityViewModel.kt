package com.example.viewmodelsample

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = 0

    fun getCurrentCount():Int = count

    fun getUpdatedCount():Int = ++count

}
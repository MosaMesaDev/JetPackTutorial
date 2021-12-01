package com.mosamesadev.jetpacktutorial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllArticlesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the home Fragment"
    }
    val text: LiveData<String> = _text
}
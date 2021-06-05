package com.app.homelauncher.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {
    var toast=MutableLiveData<String>()

}
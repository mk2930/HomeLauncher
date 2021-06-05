package com.app.homelauncher.home

import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import com.app.homelauncher.base.BaseViewModel

class ApplistAdapterViewModel:BaseViewModel() {
    var appname=MutableLiveData<String>()
    var icon=MutableLiveData<Drawable>()

}
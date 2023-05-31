/*
 * Copyright (c) Code Developed by Prof. Fabio Ciravegna
 * All rights Reserved
 */
package it.torino.livedatalabclass

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class MyViewModel(application: Application) : AndroidViewModel(application) {
    private var TAG = this::class.simpleName
    var currentValue: MutableLiveData<String> = MutableLiveData<String>()
    var pastValues: MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    private val model = Model()
    init{
        findAnotherValue()
        Log.i(TAG, "init: generating value ${currentValue.value}")
    }

    fun findAnotherValue() {
        // to detect a value change, you have to recreate the list If you just add to the existing
        // list the value of the variable does not change
        currentValue.value = model.findAnotherValue()
        pastValues.value = model.getPastValues()
        Log.i(TAG, "generating value ${currentValue.value}")
    }

}
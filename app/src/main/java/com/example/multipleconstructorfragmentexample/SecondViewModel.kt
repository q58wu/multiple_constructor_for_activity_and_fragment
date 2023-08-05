package com.example.multipleconstructorfragmentexample

import android.util.Log
import androidx.lifecycle.ViewModel

class SecondViewModel: ViewModel() {
    private lateinit var name: String
    private lateinit var sex: String
    private var age: Int? = null

    fun init(intermediateData: SecondActivity.IntermediateData.NewIntermediateData){
        name = intermediateData.name
        sex = intermediateData.sex
        Log.d("SecondViewModel", "new data: $name, $sex, $age")
    }

    fun init(intermediateData: SecondActivity.IntermediateData.OldIntermediateData){
        name = intermediateData.name
        sex = intermediateData.sex
        age = intermediateData.age

        Log.d("SecondViewModel", "old data: $name, $sex, $age")
    }
}
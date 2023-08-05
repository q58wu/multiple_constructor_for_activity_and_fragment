package com.example.multipleconstructorfragmentexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.parcel.Parcelize

class SecondActivity : AppCompatActivity() {

    private lateinit var intermediateData: IntermediateData
    private lateinit var viewModel: SecondViewModel

    // feel free to delete this, but then use getParcelable(key: String) instead
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]

        setContentView(R.layout.activity_second)
        processData(intent.extras?.getParcelable("EXTRA", IntermediateData::class.java))
    }

    private fun processData(newIntermediateData: IntermediateData?){
        when(newIntermediateData){
            is IntermediateData.NewIntermediateData -> {
                intermediateData = newIntermediateData
                viewModel.init(intermediateData as IntermediateData.NewIntermediateData)
            }
            is IntermediateData.OldIntermediateData -> {
                intermediateData = newIntermediateData
                viewModel.init(intermediateData as IntermediateData.OldIntermediateData)
            }
            else -> {
                Log.e("SecondActivity", "failed to init second activity")
            }
        }
    }
    /**
     * IntermediateData is coupled with SecondActivity
     * */
    sealed class IntermediateData: Parcelable {
        abstract val name: String
        @Parcelize
        class NewIntermediateData(override val name: String, val sex: String): IntermediateData()

        @Parcelize
        class OldIntermediateData(override val name: String, val sex: String, val age: Int): IntermediateData()
    }
}

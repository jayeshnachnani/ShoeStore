package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe
import androidx.fragment.app.activityViewModels
import kotlin.reflect.KProperty

class ShoeDetailViewModel : ViewModel(){
    //private val viewModel: ShoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    val shoe = MutableLiveData <Shoe>()
    //val list = mutableListOf<Shoe>()
    //val shoe1 = Shoe("i23",12.0,"bata", "images")

    init{
        //shoe.value = Shoe("",0.0,"","")
    }

    override fun onCleared() {
        super.onCleared()
    }

    private fun onSave() {
        //shoeList.value?.add(Shoe("i23",12.0,"bata", "images"))
        //shoeList.value = shoeList.value
        //https://stackoverflow.com/questions/47941537/notify-observer-when-item-is-added-to-list-of-livedata/49022687#49022687
        //https://stackoverflow.com/questions/59895548/android-add-new-items-to-mutablelivedata-and-observe
    }

}


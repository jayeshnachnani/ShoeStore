package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel(){
    var shoe: Shoe = Shoe("",0.0,"", "")
    private val _list = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList : LiveData<List<Shoe>>
        get() {
            return _shoeList
        }
    /*val shoeList : LiveData<List<Shoe>>
        get() {
            return _shoeList
        }*/

    init{
        //_list = ArrayList<Shoe>()
        //shoeList.value = ArrayList()
    }

    override fun onCleared() {
        super.onCleared()
        //_list = _list
        _shoeList.value = _list
    }

    fun addToList() {
        //_list.add(Shoe("i23",12.0,"bata", "images"))
       // Timber.i("shoe now is" + shoe.toString())
        _list.add(shoe)
        Timber.i("list now is:" )
         _list.forEach{Timber.i(it.name.toString() + "\n")}
        _shoeList.value = _list
        //shoeList.value = _shoeList.value
        //Above line doesn't do anything

        //https://stackoverflow.com/questions/47941537/notify-observer-when-item-is-added-to-list-of-livedata/49022687#49022687
        //https://stackoverflow.com/questions/59895548/android-add-new-items-to-mutablelivedata-and-observe
    }
}


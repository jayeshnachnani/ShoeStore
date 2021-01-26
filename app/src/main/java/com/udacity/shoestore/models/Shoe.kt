package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Observable, Parcelable {

    constructor() : this("", 0.0, "", "")

    private val propertyChangeRegistry = PropertyChangeRegistry()

    @Bindable
    fun getname(): String {
        return name
    }
    @Bindable
    fun setname(newName: String) {
        if(name != newName) {
            name = newName
            //propertyChangeRegistry.notifyChange(this,BR.name)

        }
    }

    @Bindable
    fun getsize(): Double {
        return size
    }
    @Bindable
    fun setsize(newSize: Double) {
        if(newSize != size) {
            size = newSize
            //propertyChangeRegistry.notifyChange(this, BR.size)
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}
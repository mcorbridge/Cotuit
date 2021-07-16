package com.example.cotuit.hilt

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cotuit.menu.NavIcon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ExampleRepository,
) : ViewModel() {

    var foo:String = "foo"
    var bar:Float = 1.0f

}


class ExampleRepository{

}
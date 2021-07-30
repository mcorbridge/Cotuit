package com.example.cotuit.hilt

import androidx.compose.runtime.Composable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestFoo @Inject constructor(val testInject: TestInject){

    @Composable
    fun doSomething(){
        testInject.TestNetwork()
    }


}
package com.example.cotuit.hilt

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {
    private val exampleViewModel: ExampleViewModel by viewModels()


}
package com.example.tutorial.mvvmtodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tutorial.mvvmtodolist.ui.theme.MVVMtodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMtodoListTheme {

            }
        }
    }
}

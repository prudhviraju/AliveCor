package com.alivecor.shared.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.alivecor.R

abstract class BaseActivity : AppCompatActivity(){

    lateinit var parentViewGroup: ViewGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.base_activity)
        parentViewGroup = findViewById(R.id.activity_parent_container)
    }
}
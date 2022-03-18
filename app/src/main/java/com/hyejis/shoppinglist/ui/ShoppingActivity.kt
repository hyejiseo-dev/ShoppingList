package com.hyejis.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hyejis.shoppinglist.R
import com.hyejis.shoppinglist.db.ShoppingDatabase
import com.hyejis.shoppinglist.repository.ShoppingRepository
import com.hyejis.shoppinglist.ui.shoppinglist.ShoppingViewModel
import com.hyejis.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}
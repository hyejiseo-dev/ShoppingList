package com.hyejis.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.hyejis.shoppinglist.db.entities.ShoppingItem
import com.hyejis.shoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel(){
    //코루틴 시작 시 어떤 동작을 할지 설정 - Main 사용(room)
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}
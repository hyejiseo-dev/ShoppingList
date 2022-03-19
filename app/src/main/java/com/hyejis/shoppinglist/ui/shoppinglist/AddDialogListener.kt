package com.hyejis.shoppinglist.ui.shoppinglist

import com.hyejis.shoppinglist.db.entities.ShoppingItem

interface AddDialogListener {
    fun addButtonClick(item: ShoppingItem)
}
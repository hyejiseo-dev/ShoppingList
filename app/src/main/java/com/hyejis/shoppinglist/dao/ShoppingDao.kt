package com.hyejis.shoppinglist.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hyejis.shoppinglist.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    //업데이트 될때 마다 갱신
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}
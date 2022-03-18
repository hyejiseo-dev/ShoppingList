package com.hyejis.shoppinglist.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "shopping_items"
)
data class ShoppingItem(  //가장 먼저 설정하기!
    @ColumnInfo(name="item_name")
    var name: String,
    @ColumnInfo(name="item_amount")
    var amount: Int
){
    //id 지정 - 자동 업데이트, nullable
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null
}
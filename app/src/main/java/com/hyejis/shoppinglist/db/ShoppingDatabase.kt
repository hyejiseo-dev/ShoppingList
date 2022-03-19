package com.hyejis.shoppinglist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hyejis.shoppinglist.dao.ShoppingDao
import com.hyejis.shoppinglist.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1, exportSchema = false
)
abstract class ShoppingDatabase : RoomDatabase() {  //Room 데이터베이스 세팅

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // 인스턴스 생성할 때 null일 경우..
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
            ShoppingDatabase::class.java,
                "ShoppingDB.db").allowMainThreadQueries().build()
    }

}
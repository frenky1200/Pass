package com.example.vpb.pass

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable("Customer", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "name" to TEXT,
            "login" to TEXT,
            "pass" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("User", true)
    }

    fun delete(id: Int){
        writableDatabase
        use{
            delete("Customer",
                "id = $id")
        }
    }

    fun getAll(): ArrayList<Entity>{
        val a = ArrayList<Entity>()
        readableDatabase
        use{
            select("Customer",
                "id",
                "name",
                "login",
                "pass").exec {
                while (moveToNext())
                    a.add(Entity(getInt(0), getString(1), getString(2), getString(3)))
            }
        }
        return a
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)
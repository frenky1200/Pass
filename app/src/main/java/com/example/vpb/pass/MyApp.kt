package com.example.vpb.pass

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {

        super.onCreate()

        instance = this
        db = this.database

    }

    companion object {
        lateinit var db: MyDatabaseOpenHelper
            private set
        var instance: MyApp? = null
            private set
    }

}
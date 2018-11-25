package com.example.vpb.pass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vpb.pass.MyApp.Companion.db
import kotlinx.android.synthetic.main.second_activity.*
import org.jetbrains.anko.db.insert

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        button.setOnClickListener {
            db.writableDatabase
            db.use{
                insert("Customer",
                    "name" to editName.text.toString(),
                    "login" to editLogin.text.toString(),
                    "pass" to editPass.text.toString())
            }
        }

    }
}
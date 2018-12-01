package com.example.vpb.pass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vpb.pass.MyApp.Companion.db
import kotlinx.android.synthetic.main.second_activity.*
import org.jetbrains.anko.db.update

class UpdateActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val id = intent.getIntExtra("id", 1)
        button.setOnClickListener {
            db.writableDatabase
            db.use{
                update("Customer",
                    "name" to editName.text.toString(),
                    "login" to editLogin.text.toString(),
                    "pass" to editPass.text.toString()
                    ).whereArgs("id = {id}", "id" to id).exec()
            }
        }

    }
}
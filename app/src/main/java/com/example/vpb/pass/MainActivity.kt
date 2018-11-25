package com.example.vpb.pass

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import com.example.vpb.pass.MyApp.Companion.db
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.matchConstraint

class MainActivity : AppCompatActivity() {

    //private lateinit var adapter: MyAdapter
    private lateinit var list: ArrayList<Entity>
    private lateinit var adapter: ArrayAdapter<Entity>
    private lateinit var a: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //button2.setOnClickListener {
         //   startActivity<SecondActivity>()
        //}
        constraintLayout {
            val b = button("Добавить"){ id = R.id.qq }.lparams(width = wrapContent, height = wrapContent) {
                leftMargin = dip(2)
                rightMargin = dip(10)
                bottomMargin = dip(10)
                topToTop = PARENT_ID
                leftToLeft = PARENT_ID
                //bottomToBottom = PARENT_ID
                rightToRight = PARENT_ID
                //horizontalBias = 0.25f
            }
            b.setOnClickListener { startActivity<SecondActivity>() }
            a = listView { }.lparams(width = matchConstraint, height = matchConstraint) {
                leftMargin = dip(2)
                rightMargin = dip(10)
                bottomMargin = dip(10)
                topToBottom = R.id.qq
                leftToLeft = PARENT_ID
                bottomToBottom = PARENT_ID
                rightToRight = PARENT_ID
                //horizontalBias = 0.25f
            }
        }
    }

    override fun onResume() {
        super.onResume()
        //adapter = MyAdapter(db.getAll())
        //rView.layoutManager = LinearLayoutManager(this)
        //rView.adapter = adapter
        list = db.getAll()
        adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, list)
        a.adapter = adapter
        a.setOnItemClickListener { parent, view, position, id -> startActivity<SecondActivity>() }
        a.setOnItemLongClickListener { parent, view, position, id ->
            list.remove(db.getAll()[position])
            db.delete(db.getAll()[position].id)
            adapter.notifyDataSetChanged()
            true }
    }
}

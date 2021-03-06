package com.example.vpb.pass

import android.view.MenuInflater
import android.view.View
import android.view.View.inflate
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class SomeActivity : AnkoComponent<MyAdapter> {

    override fun createView(ui: AnkoContext<MyAdapter>): View = with(ui) {
        linearLayout {
            orientation = LinearLayout.HORIZONTAL

            constraintLayout {
                id = Ids.linearLayout

                textView {
                    id = Ids.textViewName
                }.lparams(width = dip(0), height = wrapContent)

                textView("Ranchi, Jharkhand") {
                    id = Ids.textViewLogin
                }.lparams(width = dip(0), height = wrapContent)

                textView("TextView") {
                    id = Ids.textViewPass
                }.lparams(width = dip(0), height = wrapContent)

                imageButton(android.R.drawable.ic_input_add){
                    id = Ids.iVbutton
                }
            }.lparams(width = matchParent, height = wrapContent)
        }
    }

    private object Ids {
        val linearLayout = 1
        val textViewLogin = 2
        val textViewName = 3
        val textViewPass = 4
        val iVbutton = 5
    }
}

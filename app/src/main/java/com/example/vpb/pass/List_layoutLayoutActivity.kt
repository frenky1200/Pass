import android.app.*
import android.view.*
import android.widget.*
import org.jetbrains.anko.*
import android.os.Bundle
import com.example.vpb.pass.MyAdapter
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

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
            }.lparams(width = matchParent, height = wrapContent)
        }
    }

    private object Ids {
        val linearLayout = 1
        val textViewLogin = 2
        val textViewName = 3
        val textViewPass = 4
    }
}

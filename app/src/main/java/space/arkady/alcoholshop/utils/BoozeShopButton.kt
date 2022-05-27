package space.arkady.alcoholshop.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class BoozeShopButton(context: Context, attributeset: AttributeSet) :
    AppCompatButton(context, attributeset) {

        init {
            applyFont()
        }

    private fun applyFont() {
        val typeface: Typeface =
            Typeface.createFromAsset(context.assets, "quigley.TTF")
        setTypeface(typeface)
    }
}
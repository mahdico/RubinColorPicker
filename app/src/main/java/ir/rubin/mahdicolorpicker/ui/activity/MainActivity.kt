package ir.rubin.mahdicolorpicker.ui.activity

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import ir.rubin.mahdicolorpicker.R
import ir.rubin.mahdicolorpicker.ui.fragment.ColorPickerFragment
import ir.rubin.mahdicolorpicker.util.ColorUtil


/**
 *
 *
 * @author Mahdi Giveie
 *
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.frame, ColorPickerFragment())
            .commitAllowingStateLoss()
    }

}

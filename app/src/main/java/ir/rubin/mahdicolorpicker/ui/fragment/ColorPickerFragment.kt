package ir.rubin.mahdicolorpicker.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.flexbox.FlexboxLayoutManager
import ir.rubin.mahdicolorpicker.R
import ir.rubin.mahdicolorpicker.adapter.SegmentedColorAdapter
import ir.rubin.mahdicolorpicker.listener.ColorSelectedListener
import ir.rubin.mahdicolorpicker.util.ColorUtil
import ir.rubin.mahdicolorpicker.util.DefaultColors
import kotlinx.android.synthetic.main.fragment_color_picker.*

/**
 *
 * @author Mahdi Giveie
 */
class ColorPickerFragment : Fragment(R.layout.fragment_color_picker) {

    private var mColor = 0
    private var currentPosition = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val primaryColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        val adapter = SegmentedColorAdapter(DefaultColors.getColors())
        rv_recent_colors.layoutManager = FlexboxLayoutManager(context)
        rv_recent_colors.adapter = adapter

        view_color_picker.setColor(primaryColor)
        view_color_picker.setColorListener { color, _ ->
            view_color_picker.setColor(color)
            adapter.setSegmentColor(
                ColorUtil.formatColor(color = color),
                position = currentPosition
            )
        }

        adapter.setColorListener(object : ColorSelectedListener {
            override fun onColorSelected(color: Int, colorHex: String, position: Int) {

                view_color_picker.setColor(color)
                adapter.setSegmentStatus(true, position)
                currentPosition = position
            }
        })
    }

}

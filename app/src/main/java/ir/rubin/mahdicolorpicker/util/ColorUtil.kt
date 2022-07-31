package ir.rubin.mahdicolorpicker.util

import android.content.Context
import android.graphics.Color
import androidx.core.graphics.ColorUtils
import org.json.JSONObject
import java.util.Collections

/**
 * Color Utility
 *
 */
object ColorUtil {

    /**
     * Cache Color Palette
     *
     * key = ColorSwatch value [ir.rubin.mahdicolorpicker.model.ColorSwatch.value]
     * value = List of Hex Color [ir.rubin.mahdicolorpicker.model.ColorSwatch] value
     */
    private lateinit var mColorMap: Map<String, MutableList<String>>

    @JvmStatic
    fun parseColor(color: String): Int {
        return if (color.isBlank()) 0
        else Color.parseColor(color)
    }

    @JvmStatic
    fun formatColor(color: Int): String {
        return String.format("#%06x", color and 0xffffff)
    }

    @JvmStatic
    fun isDarkColor(color: String) = isDarkColor(parseColor(color))

    @JvmStatic
    fun isDarkColor(color: Int): Boolean {
        return ColorUtils.calculateLuminance(color) <= 0.4
    }

    @JvmStatic
    fun isEqualColor(color1: String, color2: String, tolerance: Int = 50): Boolean {
        return isEqualColor(parseColor(color1), parseColor(color2), tolerance)
    }

    @JvmStatic
    fun isEqualColor(color1: Int, color2: Int, tolerance: Int = 50): Boolean {
        val red1 = Color.red(color1)
        val green1 = Color.green(color1)
        val blue1 = Color.blue(color1)

        val red2 = Color.red(color2)
        val green2 = Color.green(color2)
        val blue2 = Color.blue(color2)

        return (
            red1 >= (red2 - tolerance) &&
                red1 <= (red2 + tolerance) &&
                green1 >= (green2 - tolerance) &&
                green1 <= (green2 + tolerance) &&
                blue1 >= (blue2 - tolerance) && blue1 <= (blue2 + tolerance)
            )
    }
}

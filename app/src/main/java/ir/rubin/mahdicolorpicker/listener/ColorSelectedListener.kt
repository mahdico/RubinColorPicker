package ir.rubin.mahdicolorpicker.listener

/**
 * Color Select Listener
 *
 */
interface ColorSelectedListener {

    /**
     *
     * Call when user select color
     *
     * @param color Color Resource
     * @param colorHex Hex String of Color Resource
     */
    fun onColorSelected(color: Int, colorHex: String,position:Int)
}

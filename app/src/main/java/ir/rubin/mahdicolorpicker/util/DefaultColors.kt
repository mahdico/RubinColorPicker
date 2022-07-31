package ir.rubin.mahdicolorpicker.util

import ir.rubin.mahdicolorpicker.model.SegmentsSelectedColor

object DefaultColors {

    fun getColors(): List<SegmentsSelectedColor> {
        return listOf(
            SegmentsSelectedColor(color = "#00c2a3", true),
            SegmentsSelectedColor(color = "#4ba54f", false),
            SegmentsSelectedColor(color = "#ff6100", false)
        )
    }
}
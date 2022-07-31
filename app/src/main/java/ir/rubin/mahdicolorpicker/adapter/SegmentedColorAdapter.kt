package ir.rubin.mahdicolorpicker.adapter

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rubin.mahdicolorpicker.listener.ColorSelectedListener
import ir.rubin.mahdicolorpicker.model.ColorShape
import ir.rubin.mahdicolorpicker.model.SegmentsSelectedColor
import kotlinx.android.synthetic.main.adapter_material_color_picker.view.*

/**
 * Adapter for Recent Color
 *
 */
class SegmentedColorAdapter(private val colors: List<SegmentsSelectedColor>) :
    RecyclerView.Adapter<SegmentedColorAdapter.MaterialColorViewHolder>() {

    private var colorShape = ColorShape.CIRCLE
    private var colorListener: ColorSelectedListener? = null
    private var emptyColor = "#E0E0E0"

    fun setColorListener(listener: ColorSelectedListener) {
        this.colorListener = listener
    }




    fun setSegmentStatus(isSelected: Boolean, position: Int) {
        for (i in colors.indices) {
            colors[i].isSelected = i == position
        }
        notifyDataSetChanged()
    }

    fun setSegmentColor(color: String, position: Int) {
        colors[position].color = color
        notifyDataSetChanged()
    }

    fun setColorShape(colorShape: ColorShape) {
        this.colorShape = colorShape
    }

    override fun getItemCount() = colors.size

    fun getItem(position: Int): SegmentsSelectedColor {
        return if (position < colors.size) {
            colors[position]
        } else {
            SegmentsSelectedColor("#E0E0E0", true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialColorViewHolder {
        val rootView = ColorViewBinding.inflateAdapterItemView(parent)
        return MaterialColorViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MaterialColorViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MaterialColorViewHolder(private val rootView: View) :
        RecyclerView.ViewHolder(rootView) {

        private val colorView = rootView.colorView
        private val card_bg = rootView.card_bg

        init {
            rootView.setOnClickListener {
                val index = it.tag as Int
                if (index < colors.size) {
                    val color = getItem(index)
                    colorListener?.onColorSelected(
                        Color.parseColor(color.color),
                        color.color,
                        position = adapterPosition
                    )
                }
            }
        }

        fun bind(position: Int) {
            val color = getItem(position)
            rootView.tag = position
            ColorViewBinding.setBackgroundColor(colorView, color.color)
            ColorViewBinding.setBackgroundColor(
                card_bg,
                if (color.isSelected) "#3b3b3b" else "#2c2c2c"
            )
            ColorViewBinding.setCardRadius(colorView, colorShape)
        }
    }
}

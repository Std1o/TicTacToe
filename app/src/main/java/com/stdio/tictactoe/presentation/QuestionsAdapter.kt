package com.stdio.tictactoe.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.stdio.tictactoe.R
import com.stdio.tictactoe.databinding.ItemCellBinding
import com.stdio.tictactoe.domain.Player

class RVAdapter(private val listener: (Int) -> Unit) : RecyclerView.Adapter<RVAdapter.CourseViewHolder>() {

    private var dataList: MutableList<Player> = MutableList(9) { Player.None }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    fun updatePosition(position: Int, player: Player) {
        if (position == -1) return
        dataList[position] = player
        notifyItemChanged(position)
    }

    fun reset() {
        dataList = MutableList(9) { Player.None }
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        if (dataList[position] == Player.X) {
            holder.binding.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    holder.itemView.resources,
                    R.drawable.ic_x,
                    null
                )
            )
        } else if (dataList[position] == Player.O) {
            holder.binding.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    holder.itemView.resources,
                    R.drawable.ic_zero,
                    null
                )
            )
        } else {
            holder.binding.imageView.setImageDrawable(null)
        }
        holder.itemView.setOnClickListener {
            if (dataList[position] == Player.None) {
                listener.invoke(position)
            }
        }
    }

    inner class CourseViewHolder(val binding: ItemCellBinding) :
        RecyclerView.ViewHolder(binding.root)
}
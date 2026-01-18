package com.example.burgerkotlin.ui.role.admin.main.order_management

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgerkotlin.databinding.ItemMenuBinding
import com.example.burgerkotlin.model.MenuResponse

class AdapterMenu(
    private val items: List<MenuResponse>,
    private val onClick: (MenuResponse) -> Unit
) : RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuResponse) {
            binding.tvName.text = item.name
            binding.tvDescription.text = item.description
            binding.tvPrice.text = "Rp ${item.price}"

            /*Glide.with(binding.root.context)
                .load(item.image_url)
                .into(binding.imgMenu)*/

            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

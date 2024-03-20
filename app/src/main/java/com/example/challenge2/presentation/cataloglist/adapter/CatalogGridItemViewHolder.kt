package com.example.challenge2.presentation.cataloglist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challenge2.base.ViewHolderBinder
import com.example.challenge2.base.toIndonesianFormat
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.databinding.ItemCatalogGridBinding

class CatalogGridItemViewHolder (
    private val binding: ItemCatalogGridBinding,
    private val listener: OnItemClickedListener<Catalog>
): ViewHolder(binding.root), ViewHolderBinder<Catalog> {

    override fun bind(item: Catalog) {
        item.let {
            binding.ivGridImage.setImageResource(it.image)
            binding.tvGridName.text = it.name
            binding.tvGridPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}
package com.example.challenge2.presentation.cataloglist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challenge2.base.ViewHolderBinder
import com.example.challenge2.base.toIndonesianFormat
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.databinding.ItemCatalogListBinding

class CatalogListItemViewHolder(
    private val binding: ItemCatalogListBinding,
    private val listener: OnItemClickedListener<Catalog>
): ViewHolder(binding.root), ViewHolderBinder<Catalog> {

    override fun bind(item: Catalog) {
        item.let{
            binding.ivListImage.setImageResource(it.image)
            binding.tvListName.text = it.name
            binding.tvListPrice.text = it.price.toIndonesianFormat()
            binding.tvListLocation.text= it.location
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}
package com.example.challenge2.presentation.cataloglist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.base.ViewHolderBinder
import com.example.challenge2.data.model.Category
import com.example.challenge2.databinding.ItemCategoryBinding


class CategoryItemViewHolder (
    private val binding: ItemCategoryBinding
    ): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Category>
    {

        override fun bind(item: Category) {
            item.let {
                binding.ivCategoryImage.setImageResource(it.image)
                binding.tvCategoryName.text = it.name
            }
        }
    }
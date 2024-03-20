package com.example.challenge2.presentation.cataloglist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challenge2.base.ViewHolderBinder
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.databinding.ItemCatalogGridBinding
import com.example.challenge2.databinding.ItemCatalogListBinding

class CatalogAdapter(
    private val listener: OnItemClickedListener<Catalog>,
    private val listMode: Int = MODE_GRID) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<Catalog>() {
            override fun areItemsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    fun submitData(data: List<Catalog>) {
        asyncDataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (listMode == MODE_GRID) CatalogGridItemViewHolder(
            ItemCatalogGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        ) else {
            CatalogListItemViewHolder(
                ItemCatalogListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<Catalog>).bind(asyncDataDiffer.currentList[position])
    }
}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}
package com.example.challenge2.presentation.cataloglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge2.R
import com.example.challenge2.data.datasource.CatalogDataSource
import com.example.challenge2.data.datasource.CatalogDataSourceImpl
import com.example.challenge2.data.datasource.CategoryDataSource
import com.example.challenge2.data.datasource.CategoryDataSourceImpl
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.databinding.FragmentCatalogListBinding
import com.example.challenge2.presentation.catalogdetail.DetailActivity
import com.example.challenge2.presentation.cataloglist.adapter.CatalogAdapter
import com.example.challenge2.presentation.cataloglist.adapter.CategoryAdapter
import com.example.challenge2.presentation.cataloglist.adapter.OnItemClickedListener


class CatalogListFragment : Fragment() {
    private lateinit var binding: FragmentCatalogListBinding
    private var isUsingGridMode: Boolean = true
    private var catalogAdapter: CatalogAdapter? = null
    private  var categoryAdapter: CategoryAdapter? = null
    private val dataSource : CatalogDataSource by lazy {
        CatalogDataSourceImpl()
    }
    private val categoryDataSource: CategoryDataSource by lazy {
        CategoryDataSourceImpl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            bindCatalogList(isUsingGridMode)
            bindCategory()
            setClickAction()
        }

    private fun bindCategory() {
        categoryAdapter = CategoryAdapter()
        binding.rvCategory.apply {
            adapter = this@CatalogListFragment.categoryAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        categoryAdapter?.submitDataCategory(categoryDataSource.getCategoryMembers())
    }

    private fun setClickAction() {
        binding.ivList.setOnClickListener{
            isUsingGridMode = !isUsingGridMode
            setIcon(isUsingGridMode)
            bindCatalogList(isUsingGridMode)
        }
    }

    private fun setIcon(usingGridMode: Boolean) {
        binding.ivList.setImageResource(if (usingGridMode) R.drawable.ic_list else R.drawable.ic_grid)
    }

    private fun bindCatalogList(isUsingGrid : Boolean) {
        val listMode = if (isUsingGrid) CatalogAdapter.MODE_GRID else CatalogAdapter.MODE_LIST
        catalogAdapter = CatalogAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Catalog> {
                override fun onItemClicked(item: Catalog) {
                    //navigate to detail
                    navigateToDetail(item)
                }
            })
        binding.rvCatalog.apply {
            adapter = this@CatalogListFragment.catalogAdapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        catalogAdapter?.submitData(dataSource.getCatalogMembers())
    }

    private fun navigateToDetail(item: Catalog) {
        DetailActivity.startActivity(
            requireContext(),
            item
        )
    }
}
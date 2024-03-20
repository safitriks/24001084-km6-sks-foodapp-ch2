package com.example.challenge2.data.datasource

import com.example.challenge2.R
import com.example.challenge2.data.model.Category


interface CategoryDataSource {
    fun getCategoryMembers(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategoryMembers(): List<Category> {
        return mutableListOf(
            Category(
                image = R.drawable.ic_rice,
                name = "Rice"
            ),
            Category(
                image = R.drawable.ic_noodle,
                name = "Noodle"
            ),
            Category(
                image = R.drawable.ic_snack,
                name = "Snack"
            ),
            Category(
                image = R.drawable.ic_drink,
                name = "Drink"
            ),
            Category(
                image = R.drawable.ic_dessert,
                name = "Dessert"
            )
        )
    }
}

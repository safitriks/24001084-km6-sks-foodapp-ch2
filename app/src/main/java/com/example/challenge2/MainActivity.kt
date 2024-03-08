package com.example.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge2.databinding.ActivityMainBinding
import com.example.challenge2.model.Catalog
import com.example.challenge2.model.Category

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var categoryadapter = CategoryAdapter()
    private var catalogadapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListCatalog()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.ic_rice, name = "Rice"),
            Category(image = R.drawable.ic_noodle, name = "Noodle"),
            Category(image = R.drawable.ic_snack, name = "Snack"),
            Category(image = R.drawable.ic_drink, name = "Drink"),
            Category(image = R.drawable.ic_dessert, name = "Dessert")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryadapter
        }
        categoryadapter.submitData(data)
    }

    private fun setListCatalog() {
        val data = listOf(
            Catalog(image = R.drawable.img_menu1, price = 50000.00, name = "Ayam Bakar"),
            Catalog(image = R.drawable.img_menu2, price = 40000.00, name = "Ayam Goreng"),
            Catalog(image = R.drawable.img_menu3, price = 40000.00, name = "Ayam Geprek"),
            Catalog(image = R.drawable.img_menu4, price = 5000.00, name = "Sate Usus Ayam"),
            Catalog(image = R.drawable.img_menu5, price = 35000.00, name = "Gurame Bakar"),
            Catalog(image = R.drawable.img_menu6, price = 35000.00, name = "Gurame Asam manis"),
            Catalog(image = R.drawable.img_menu7, price = 55000.00, name = "Udang Goreng"),
            Catalog(image = R.drawable.img_menu8, price = 55000.00, name = "Cumi Goreng")
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.catalogadapter
        }
        catalogadapter.submitData(data)
    }

    private fun setAction(){
        binding.layoutHeader.ivProfile.setOnClickListener{
            Toast.makeText(this@MainActivity, "Safit Profile", Toast.LENGTH_SHORT).show()
        }
    }

}
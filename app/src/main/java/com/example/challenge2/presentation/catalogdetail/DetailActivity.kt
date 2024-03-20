package com.example.challenge2.presentation.catalogdetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge2.base.fromIndonesianFormatToDouble
import com.example.challenge2.base.toIndonesianFormat
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var amount : Int = 1
    private var link : String = "maps"
    companion object {
        const val EXTRAS_ITEM = "EXTRAS_DETAIL_DATA"
        fun startActivity(context: Context, menu: Catalog){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_ITEM, menu)
            context.startActivity(intent)
        }
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClick()
        bindDetailMenu()
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setOnClick()
        updateLayout(amount)
    }

    private fun setOnClick(){
        binding.cvLess.setOnClickListener{
            decreaseAmount(amount)
            updateLayout(amount)
        }
        binding.cvMore.setOnClickListener{
            increaseAmount(amount)
            updateLayout(amount)
        }
        binding.ivArrow.setOnClickListener {
            finish()
        }
        binding.tvAddressLoc.setOnClickListener{
            clickLink()
        }

    }

    private fun clickLink() {
        val gmmIntentUri = Uri.parse(link)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        startActivity(mapIntent)
    }

    private fun increaseAmount(amount: Int) {
        val newAmount = amount + 1
        updateAmount(newAmount)
    }

    private fun updateAmount(currentAmount: Int) {
        binding.tvNumber.text = currentAmount.toString()
        amount = currentAmount
    }

    private fun updateLayout(amount: Int) {
        val priceText= binding.tvMenuPrice.text.toString()
        val price = priceText.fromIndonesianFormatToDouble()
        val totalPrice = price?.times(amount)
        val formattedTotalPrice = totalPrice.toIndonesianFormat()
        val buttonText = "Tambahkan ke Keranjang - $formattedTotalPrice"
        binding.btnAddToCart.text = buttonText
    }

    private fun decreaseAmount(amount: Int) {
        val newAmount = if(amount == 0) 0 else amount - 1
        updateAmount(newAmount)
    }

    private fun bindDetailMenu() {
        intent.extras?.getParcelable<Catalog>(EXTRAS_ITEM)?.let {
            link = it.locationUrl
            binding.ivMenuImg.setImageResource(it.image)
            binding.tvMenuName.text = it.name
            binding.tvMenuPrice.text = it.price.toIndonesianFormat()
            binding.tvMenuDetails.text = it.details
            binding.tvAddressLoc.text = it.location
        }
    }
}
package com.example.myapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityMyCartBinding

class MyCartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyCartBinding
    private var pricePerItem = 0
    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pricePerItem = intent.getIntExtra("price", 0)
        updateTotal()

        binding.btnPlus.setOnClickListener {
            quantity++
            updateTotal()
        }

        binding.btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateTotal()
            }
        }

        binding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun updateTotal() {
        val total = pricePerItem * quantity
        binding.tvQuantity.text = quantity.toString()
        binding.tvTotal.text = "$total$"
    }
}

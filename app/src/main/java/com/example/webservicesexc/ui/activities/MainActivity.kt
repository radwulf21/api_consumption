package com.example.webservicesexc.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservicesexc.R
import com.example.webservicesexc.services.repository
import com.example.webservicesexc.ui.adapters.ProdutosAdapter
import com.example.webservicesexc.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getAllProdutos()

        viewModel.listProdutos.observe(this, {

            val adapter = viewModel.listProdutos.value?.let {ProdutosAdapter(this, it)}
            val produtosLayout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rvProdutos.adapter = adapter
            rvProdutos.layoutManager = produtosLayout
            rvProdutos.setHasFixedSize(true)
        })
    }
}
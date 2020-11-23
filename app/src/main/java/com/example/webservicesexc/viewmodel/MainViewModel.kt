package com.example.webservicesexc.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservicesexc.domain.Produto
import com.example.webservicesexc.services.Repository
import com.example.webservicesexc.services.repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(repository: Repository) : ViewModel() {
    val listProdutos = MutableLiveData<ArrayList<Produto>>()

    fun getAllProdutos() {
        try {
            viewModelScope.launch {
                listProdutos.value = repository.getAllProdutos()
            }
        } catch (erro: Exception) {
            Log.e("MainViewModel", erro.toString())
        }
    }
}
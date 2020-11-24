package com.example.webservicesexc.services

import com.example.webservicesexc.domain.Produto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProdutosResult(@SerializedName("produtos") @Expose var listaProdutos: List<Produto>)
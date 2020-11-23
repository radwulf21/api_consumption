package com.example.webservicesexc.services

import com.example.webservicesexc.domain.Produto
import com.squareup.moshi.Json

class ProdutosResult(@Json(name = "produtos") val produtos: ArrayList<Produto>)
package com.example.webservicesexc.domain

data class Produto(
    val id_prod: Int,
    var nome_prod: String,
    var url: String,
    val id_emp: Int,
    var valor: Double,
    var dt_exp: String,
    var logo_emp: String,
    var vol_prod: String
)
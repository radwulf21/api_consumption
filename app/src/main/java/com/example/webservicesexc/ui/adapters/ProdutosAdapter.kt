package com.example.webservicesexc.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webservicesexc.R
import com.example.webservicesexc.domain.Produto
import com.squareup.picasso.Picasso

class ProdutosAdapter(val context: Context, val listaProdutos: List<Produto>) :
    RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {

    inner class ProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivProduto: ImageView = itemView.findViewById(R.id.ivProduto)
        var tvValor: TextView = itemView.findViewById(R.id.tvValor)
        var tvNome: TextView = itemView.findViewById(R.id.tvNome)
        var tvUnd: TextView = itemView.findViewById(R.id.tvUnd)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutosViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prod, parent, false)
        return ProdutosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        var produto = listaProdutos[position]

        Picasso.with(context).load("https://promoios.com.br/img/produtos/${produto.url}").fit().into(holder.ivProduto)
        holder.tvValor.text = produto.valor.toString()
        holder.tvNome.text = produto.nome_prod
        holder.tvUnd.text = produto.vol_prod
    }

    override fun getItemCount() = listaProdutos.size
}
package com.example.tokoonlinesederhana.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoonlinesederhana.DeskAndPay
import com.example.tokoonlinesederhana.Model.Model_1
import com.example.tokoonlinesederhana.R
import kotlinx.android.synthetic.main.item_list.view.*

class List_Adapter (mtc : Context, val DataPdk : ArrayList<Model_1>): RecyclerView.Adapter<List_Adapter.ViewHolder>(){
    val mtc = mtc
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val nama_produk = itemView.nama_prdk
        val harga_produk = itemView.harga_prdk
        val img_produk = itemView.img_list
        val button_1 = itemView.button_beli
        val context = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return DataPdk.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pesanan = DataPdk[position]
        holder.nama_produk.text = pesanan.Nama_Prdk
        holder.harga_produk.text = pesanan.Harga_hg.toString()
        holder.img_produk.setImageResource(DataPdk.get(position).Img_list)
        holder.button_1.setOnClickListener {
            val i = Intent(holder.context, DeskAndPay::class.java)
            i.putExtra("Nama_Jual", DataPdk[position].Nama_Prdk)
            i.putExtra("Harga_Jual", DataPdk[position].Harga_hg.toString())
            i.putExtra("Desk", DataPdk[position].Nama_deskripsi)
            holder.context.startActivity(i)
        }
    }
}
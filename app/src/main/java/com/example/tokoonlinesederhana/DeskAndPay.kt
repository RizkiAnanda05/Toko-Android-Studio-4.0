package com.example.tokoonlinesederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_desk_and_pay.*

class DeskAndPay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desk_and_pay)

        val i = intent
        val datareceivedname = i.getStringExtra("Nama_Jual")
        val datareceivedhg = i.getStringExtra("Harga_Jual")
        val datareceiveddesk = i.getStringExtra("Desk")
        nm_txt.text = datareceivedname
        hg_txt.text = datareceivedhg
        desk_txt.text = datareceiveddesk
    }
}
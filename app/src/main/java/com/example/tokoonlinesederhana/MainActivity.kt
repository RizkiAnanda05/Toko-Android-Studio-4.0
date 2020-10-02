 package com.example.tokoonlinesederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoonlinesederhana.Adapter.List_Adapter
import com.example.tokoonlinesederhana.Model.Model_1

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tampilan = ArrayList<Model_1>()
        tampilan.add(
            Model_1(
                "Busi",
                "Busi Khusus Untuk Motor Beat Injeksi/ Beat New",
                R.drawable.busi_image,
                17000
            )
        )
        tampilan.add(
            Model_1(
                "Oli",
                "Oli untuk segala motor gigi honda",
                R.drawable.oli_1liter_mpx,
                47000
            )
        )
        val adapter : List_Adapter
        adapter = List_Adapter(applicationContext, tampilan)
        val r = findViewById<RecyclerView>(R.id.rc)
        r.adapter = adapter

    }
}
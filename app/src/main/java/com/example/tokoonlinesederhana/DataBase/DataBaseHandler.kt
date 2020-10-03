package com.example.tokoonlinesederhana.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.widget.Toast
import com.example.tokoonlinesederhana.Model.ModelDb

class DataBaseHandler(context: Context, nama : String?, factory : SQLiteDatabase.CursorFactory?,
version : Int): SQLiteOpenHelper(context, DATABASE_NAME , factory,DATABSE_VERsION) {
    companion object{
        private val DATABASE_NAME = "Db_part.db"
        private val DATABSE_VERsION = 1
        val TABLE_NAME = "DATA_PESANAN"
        private val colid = "Id"
        private val colName = "Nama_customer"
        private val coljam = "Jam"
        private val coltgl = "Tanggal"
        private val colnamabrg = "Nama_barang"
        private val colHargabrng = "Harga_barang"
        private val colJumlahPesan = "Jumlah_pesan"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val create_db_table : String = ("CREATE TABLE $TABLE_NAME(" +
                "$colid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$coljam TEXT," +
                "$coltgl TEXT," +
                "$colName TEXT," +
                "$colnamabrg TEXT," +
                "$colJumlahPesan INTEGER," +
                "$colHargabrng INTEGER)")
        db?.execSQL(create_db_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun Simpan(mtc : Context, model : ModelDb){
        val DataV = ContentValues()
        DataV.put(coljam, model.Jam_model)
        DataV.put(coltgl, model.Tanggal_model)
        DataV.put(colName, model.str_nama)
        DataV.put(colnamabrg, model.str_namapdk)
        DataV.put(colHargabrng, model.harga_hg_mdl)
        DataV.put(colJumlahPesan, model.Jumlah_order)
        val dta = this.writableDatabase
        try {
            dta.insert(TABLE_NAME, null, DataV)
            Toast.makeText(mtc, "Pesanan Terkirim", Toast.LENGTH_SHORT).show()
        }catch (e : Exception){
            Toast.makeText(mtc, "Pesanan Gagal Dikirim", Toast.LENGTH_SHORT).show()
        }
        dta.close()
    }
}
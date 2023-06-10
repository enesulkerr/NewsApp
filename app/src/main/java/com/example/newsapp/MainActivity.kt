package com.example.newsapp

import ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.newsapp.models.Product
import com.example.newsapp.service.XmlResult

class MainActivity : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var arr : List<Product>
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arr = listOf()

        val run = Runnable {
            val result = XmlResult()
            arr = result.xmlCurrency()

            runOnUiThread {
                // Adapter'ı oluştur ve verileri geç
                adapter = ProductAdapter(this@MainActivity, arr)

                // ListView'i bul ve adapter'ı ata
                list = findViewById(R.id.newslistview)
                list.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
        Thread(run).start()










    }
}
package com.example.newsapp.service

import android.util.Log
import com.example.newsapp.models.Product
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class XmlResult {

    fun xmlCurrency(): List<Product> {
        val arr = mutableListOf<Product>()
        val url = "https://www.haberler.com/"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val elements:Elements = doc.getElementsByAttribute("data-headlinenumber")
        for (item in elements) {

            val img = item.getElementsByTag("img")

            val href = item.attr("abs:href")

            val src = img.attr("data-src")

            val title = img.attr("alt")



            if (src.isNotEmpty() and title.isNotEmpty() and href.isNotEmpty()) {

                val pro = Product(href,title,src)
                arr.add(pro)
            }


        }


        return arr
    }


}
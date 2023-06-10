package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailActivity : AppCompatActivity() {

    lateinit var  webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")

        webView = findViewById(R.id.webview)

        // JavaScript'i etkinleştir
        webView.settings.javaScriptEnabled = true

        // WebViewClient'i ayarla
        webView.webViewClient = WebViewClient()

        // Google'ı yükle
        webView.loadUrl(title!!)






    }
}
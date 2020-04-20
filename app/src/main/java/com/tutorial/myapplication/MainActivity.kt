package com.tutorial.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    var progressBar: ProgressBar? = null
    internal var url = "https://google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var wv: WebView? = null
        wv=findViewById<WebView>(R.id.webView)
        progressBar=findViewById<ProgressBar>(R.id.progressBar)
        wv.webViewClient=myWebClient()
        wv.settings.builtInZoomControls=true
        wv.settings.displayZoomControls=false
        wv.settings.javaScriptEnabled=true
        wv.loadUrl(url)


    }


    inner class myWebClient : WebViewClient(){

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
          progressBar!!.visibility = View.VISIBLE
            view?.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progressBar!!.visibility = View.GONE
        }
    }


}

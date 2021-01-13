package com.example.wordpressapi

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class PostDetailsActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
       // webView = findViewById(R.id.webview)
        textView = findViewById(R.id.htmltextviews)
        val content = intent.getStringExtra("content")
        val title = intent.getStringExtra("title")
        supportActionBar!!.title = title
        //webView.loadData(content.toString(), "text/html", "UTF-8")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
        } else {
            textView.text = HtmlCompat.fromHtml(content!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}
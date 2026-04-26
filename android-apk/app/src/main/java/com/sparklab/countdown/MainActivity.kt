package com.sparklab.countdown

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.util.TimeZone

class MainActivity : Activity() {

    private lateinit var webView: WebView
    private val logTag = "SparkCountdown"

    class AndroidTimeBridge {
        @JavascriptInterface
        fun nowMs(): Long = System.currentTimeMillis()

        @JavascriptInterface
        fun timeZoneId(): String = TimeZone.getDefault().id

        @JavascriptInterface
        fun rawOffsetMinutes(): Int = TimeZone.getDefault().rawOffset / 60000
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Keep screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        // Fullscreen
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Log.d(
            logTag,
            "launch nowMs=${System.currentTimeMillis()} tz=${TimeZone.getDefault().id} offsetMin=${TimeZone.getDefault().rawOffset / 60000}"
        )

        webView = WebView(this)
        webView.setBackgroundColor(0xFF000000.toInt())
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d(logTag, "page started: $url")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d(logTag, "page finished: $url")
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                Log.e(
                    logTag,
                    "web error url=${request?.url} code=${error?.errorCode} desc=${error?.description}"
                )
            }
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.d(
                    logTag,
                    "${consoleMessage.message()} @${consoleMessage.sourceId()}:${consoleMessage.lineNumber()}"
                )
                return super.onConsoleMessage(consoleMessage)
            }
        }
        webView.addJavascriptInterface(AndroidTimeBridge(), "AndroidTime")

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            setSupportZoom(false)
            builtInZoomControls = false
            displayZoomControls = false
            cacheMode = WebSettings.LOAD_NO_CACHE
            mediaPlaybackRequiresUserGesture = false
            allowFileAccess = true
            allowContentAccess = false
            // Allow font files in assets to be loaded from file:// page
            @Suppress("SetJavaScriptEnabled")
            allowFileAccessFromFileURLs = true
        }

        setContentView(webView)
        webView.loadUrl("file:///android_asset/S5-Residency-Countdown.html")
    }

    override fun onResume() {
        super.onResume()
        applyImmersiveFlags()
        webView.onResume()
        webView.resumeTimers()
    }

    override fun onPause() {
        webView.onPause()
        webView.pauseTimers()
        super.onPause()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyImmersiveFlags()
        }
    }

    override fun onDestroy() {
        webView.stopLoading()
        webView.loadUrl("about:blank")
        webView.removeAllViews()
        webView.destroy()
        super.onDestroy()
    }

    override fun onBackPressed() {
        // Swallow back key — countdown screen never navigates away
    }

    private fun applyImmersiveFlags() {
        webView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )
    }
}

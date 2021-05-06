package com.ck.pachinko

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {

//  広告設定
    lateinit var mAdView : AdView

//    //スプラッシュページに戻らない設定
    override fun onBackPressed() {
        moveTaskToBack (true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Test App ID
        MobileAds.initialize(this) {
            "ca-app-pub-3940256099942544~3347511713"
        }

        //  バナー広告設定
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
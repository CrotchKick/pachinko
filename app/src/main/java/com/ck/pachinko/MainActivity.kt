package com.ck.pachinko

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ck.pachinko.databinding.ActivityMainBinding
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//  広告設定
    private lateinit var mAdView : AdView

//    //スプラッシュページに戻らない設定
//    override fun onBackPressed() {
//        moveTaskToBack (true)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tag = "ListFragment"
        //アクティビティに表示されているフラグメントが既にあれば取得
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        //フラグメントがなければ作成
        //作成したフラグメント画面上に表示
        if (fragment == null) {
            fragment = ListFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content, fragment, tag)
            }.commit()
        }

        // Test App ID
        MobileAds.initialize(this) {}

        //  バナー広告設定
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // ad's lifecycle: loading, opening, closing, and so on
        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("debug","Code to be executed when an ad finishes loading.");
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.d("debug","Code to be executed when an ad request fails.");
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("debug","Code to be executed when an ad opens an overlay that.");
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d("debug","Code to be executed when the user clicks on an ad.");
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d("debug","Code to be executed when the user is about to return.");
            }
        }
    }
}
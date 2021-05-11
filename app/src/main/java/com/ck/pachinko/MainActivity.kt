package com.ck.pachinko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck.pachinko.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


//  広告設定
    lateinit var mAdView : AdView

//    //スプラッシュページに戻らない設定
    override fun onBackPressed() {
        moveTaskToBack (true)
    }

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
        MobileAds.initialize(this) {
            "ca-app-pub-3940256099942544~3347511713"
        }

        //  バナー広告設定
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
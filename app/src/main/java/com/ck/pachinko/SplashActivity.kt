package com.ck.pachinko

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*

class SplashActivity : AppCompatActivity() {
    //インターステイシャル
//    private lateinit var mInterstitialAd: InterstitialAd
    //インターステイシャル

    val handler = Handler()
    val spHandler = SplashHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_drawable)

        //  広告設定
        MobileAds.initialize(this) {
            "ca-app-pub-3940256099942544~3347511713"
        }
        //インターステイシャル
//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
//        mInterstitialAd.loadAd(AdRequest.Builder().build())
        //インターステイシャル

    }
    override fun onResume() {
        super.onResume()
        //2000ミリ秒遅れて、「spHandler」を実行させる
        handler.postDelayed(spHandler, 1000)
    }
    override fun onStop() {
        super.onStop()
        intent = null
        handler.removeCallbacks(spHandler)
    }

    //スプラッシュ画面からスタート画面に遷移するためのクラス
    inner class SplashHandler : Runnable {
        override fun run() {

/////////////初期リリースはこちらをコメント外してインターステイシャル無しでもよい
            intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            //画面遷移アクション無し
            overridePendingTransition(0, 0)
            //アクティビティを破棄する
            this@SplashActivity.finish()
/////////////初期リリースはこちらをコメント外してインターステイシャル無しでもよい

/////////////ここから下インターステイシャルが表示される。
//            mInterstitialAd.adListener = object: AdListener() {
//                override fun onAdLoaded() {
//                    // Code to be executed when an ad finishes loading.
//                    // 広告を読み込んだら広告を表示、それまではスプラッシュ画面
//                    if (mInterstitialAd.isLoaded) {
//                        mInterstitialAd.show()
//                    } else {
//                        Log.d("TAG", "The interstitial wasn't loaded yet.")
//                    }
//                }
//
//                override fun onAdFailedToLoad(errorCode: Int) {
//                    // Code to be executed when an ad request fails.
//                    // インターネットにつながらない環境で接続してきた場合は、メインアクティビティに移動
//                    intent = Intent(this@SplashActivity, MainActivity::class.java)
//                    startActivity(intent)
//                    //画面遷移アクション無し
//                    overridePendingTransition(0, 0)
//                    //アクティビティを破棄する
//                    this@SplashActivity.finish()
//                }
//
//                override fun onAdClosed() {
//                    // Code to be executed when the interstitial ad is closed.
//                    // インターステイシャル広告を削除、戻るボタン押したらメインアクティビティに移動
//                    intent = Intent(this@SplashActivity, MainActivity::class.java)
//                    startActivity(intent)
//                    //画面遷移アクション無し
//                    overridePendingTransition(0, 0)
//                    //アクティビティを破棄する
//                    this@SplashActivity.finish()
//                }
//            }
/////////////ここから上のコメントアウトを外したらインターステイシャルが表示される。
        }
    }
}
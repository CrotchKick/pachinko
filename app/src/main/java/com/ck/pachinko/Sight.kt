package com.ck.pachinko

import android.content.res.Resources
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader

//JSONデータをSightクラスオブジェクトに変換する
@Serializable
class Sight(
    val name: String,
    val bonus: String,
    val bonushigh: String,
    val reach: String,
    val performance: String,
    val expection: String,
    val benefits: String,
    val forplus: String
)

fun getSights(resources: Resources): List<Sight> {
    //assets内にあるJSONデータファイルを開いて、テキストデータを取得する処理
    val assetManager = resources.assets
    val inputStream = assetManager.open("data.json")
    //ファイル内のデータを読込、文字列として取り出す処理
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val str: String = bufferedReader.readText()
    //取得したJSONデータ形式の文字列をSightクラスオブジェクトに変換
    val obj = Json(JsonConfiguration.Stable)
        .parse(Sight.serializer().list, str)
    return obj
}
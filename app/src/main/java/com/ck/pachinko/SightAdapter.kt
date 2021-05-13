package com.ck.pachinko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SightAdapter(
    //sights受け取り設定
    private val sights: List<Sight>
) : RecyclerView.Adapter<SightAdapter.ViewHolder>() {

    //コールバック保持するための関数型
    private var listener: ((Int) -> Unit)? = null
    //メソッドでコールバックを設定
    fun setOnItemClickListener(listener: (Int) -> Unit) {
        this.listener = listener
    }

    //セルに使用するビューを保持、[card_layout.xml]のtextviewIDと紐づけ
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.Name)
        val reach: TextView = view.findViewById(R.id.Reach)
    }

    //[card_layout.xml]を対象として使用するので定義
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    //セルにデータを設定する際に呼ばれる
    //セルの数だけ呼ばれる
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = sights[position].name
        holder.reach.text = sights[position].reach

        //セルがタップされたときに実行
        holder.itemView.setOnClickListener {
            listener?.invoke(position)
        }
    }

    //Sightオブジェクトの数を返すように設定
    override fun getItemCount(): Int = sights.size



}
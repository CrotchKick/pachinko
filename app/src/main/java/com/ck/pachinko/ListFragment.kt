package com.ck.pachinko

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ck.pachinko.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //アクションバーのタイトルをアプリ名に変更
        (activity as AppCompatActivity).supportActionBar?.title = "パチンコ天井期待値"

        //RecycleView取得、縦1列レイアウトに修正
        binding.root.apply {
            layoutManager = LinearLayoutManager(context)
//            スマホが横向きになった場合にGridlayoutを利用したい場合は、以下の記載
//                when {
//                    resources.configuration.orientation
//                            == Configuration.ORIENTATION_PORTRAIT
//                    -> LinearLayoutManager(context)
//                    else
//                    -> GridLayoutManager(context, 2)
//                }


//            adapter = SightAdapter(context, getSights(resources)).apply {
            adapter = SightAdapter(getSights(resources)).apply {
                //RecyclerViewの行がタップされた時の処理を記載
                setOnItemClickListener {position: Int ->
                    fragmentManager?.let {manager: FragmentManager ->
                        val tag = "DetailFragment"
                        var fragment = manager.findFragmentByTag(tag)
                        //DetailFlagmentが存在しなければ
                        if (fragment == null) {
                            //新しくDetailFlagment作成
                            fragment = DetailFragment()
                            fragment.arguments = Bundle().apply {
                                //フラグメントの引数にタップした行版行を渡す
                                putInt(ROW_POSITION, position)
                            }
                            //
                            manager.beginTransaction().apply {
                                setCustomAnimations(
                                    android.R.anim.fade_in,
                                    android.R.anim.fade_out,
                                    android.R.anim.fade_in,
                                    android.R.anim.fade_out)
                                //DetailFragmentを表示
                                replace(R.id.content, fragment, tag)
                                addToBackStack(null)
                            }.commit()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.ck.pachinko

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ck.pachinko.databinding.FragmentDetailBinding

const val ROW_POSITION = "ROW_POSITION"

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //引数に格納されている値を[ROW_POSITION]というキーで取り出して、positionプロパティに格納
            position = it.getInt(ROW_POSITION)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //情報を配列で取得してsightsに格納
        val sights = getSights(resources)
//        アクションバーのタイトルを機種名に変更
        (activity as AppCompatActivity).supportActionBar?.title = sights[position].name

        //sight配列からposition番目のデータを取得し[fragment_detail]画面に表示
        //binding.detailName.text = sights[position].name
        binding.detailBonus.text = sights[position].bonus
        binding.detailBonushigh.text = sights[position].bonushigh
        binding.detailReach.text = sights[position].reach
        binding.detailPerformance.text = sights[position].performance
        binding.detailExpection.text = sights[position].expection
        binding.detailBenefits.text = sights[position].benefits
        binding.detailForPlus.text = sights[position].forplus
    }
}
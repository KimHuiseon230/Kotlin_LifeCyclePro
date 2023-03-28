package com.example.lifecyclepro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecyclepro.databinding.FragmentThreeBinding
import com.example.lifecyclepro.databinding.FragmentTwoBinding

class ThreeFragment : Fragment() {

    val binding: FragmentThreeBinding by lazy { FragmentThreeBinding.inflate(layoutInflater) }
    lateinit var minActivity: MainActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        minActivity = context as MainActivity // 형변환
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding.tvMessage3.text = arguments?.getString("name")

        binding.btnSend3.setOnClickListener {
            minActivity.changeFragment("FRAG1", binding.edtMessage3.text.toString())
        }
            return binding.root
    }

}
package com.example.lifecyclepro

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lifecyclepro.databinding.FragmentOneBinding
import com.example.lifecyclepro.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
    lateinit var minActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        minActivity = context as MainActivity // 형변환
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)

        binding.tvMessage2.text = arguments?.getString("name")
        binding.btnSend2.setOnClickListener {
            minActivity.changeFragment("FRAG3", binding.edtMessage2.text.toString())

            /*binding.tvMessage2.text = arguments?.getString("tvMessage2")
        binding.btnSend2.setOnClickListener {
              minActivity.sendMessage2(binding.edtMessage2.text.toString())
          }
          binding.ivPicture2.setOnClickListener {
              Toast.makeText(binding.root.context, "${binding.tvMessage2.text}", Toast.LENGTH_SHORT).show()
          }*/
        }
        return binding.root

    }
}
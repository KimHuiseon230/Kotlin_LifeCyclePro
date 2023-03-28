package com.example.lifecyclepro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lifecyclepro.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    //1.바인딩을 해서 객체를 가져오기
    lateinit var binding: FragmentOneBinding
    lateinit var minActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        minActivity = context as MainActivity // 형변환
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        binding.tvMessage1.text = this.arguments?.getString("tvMessage1")
        /*binding.tvMessage1.text = this.arguments?.getString("tvMessage1")
        binding.ivPicture1.setOnClickListener {
            Toast.makeText(binding.root.context, "${binding.tvMessage1.text}", Toast.LENGTH_SHORT)
                .show()
        }
         binding.btnSend1.setOnClickListener {
            minActivity.sendMessage(binding.edtMessage1.text.toString())
        }
        */




        binding.btnSend1.setOnClickListener {
            minActivity.changeFragment("FRAG2",binding.edtMessage1.text.toString())


        }

        return binding.root
    }
}
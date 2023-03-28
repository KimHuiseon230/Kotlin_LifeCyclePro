package com.example.lifecyclepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lifecyclepro.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var oneFragment: OneFragment
    lateinit var twoFragment: TwoFragment
    lateinit var threeFragment: ThreeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        oneFragment = OneFragment()
        twoFragment = TwoFragment()
        threeFragment = ThreeFragment()

        //1.탭 레이아웃에 탭 메뉴 추가
        val tab1: TabLayout.Tab = binding.tabLayout.newTab()
        val tab2: TabLayout.Tab = binding.tabLayout.newTab()
        val tab3: TabLayout.Tab = binding.tabLayout.newTab()

        tab1.text = "FRAG1"
        tab2.text = "FRAG2"
        tab3.text = "FRAG3"

        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addTab(tab3)

        //2. 탭 레이아웃에 이벤트 처리
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.ivCar.visibility = View.INVISIBLE

                when (tab?.text) {
                    "FRAG1" -> changeFragment("FRAG1", null)
                    "FRAG2" -> changeFragment("FRAG2", null)
                    "FRAG3" -> changeFragment("FRAG3", null)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }

    fun changeFragment(tabName: String, data: String?) {
        val bundle = Bundle()
        val transaction = supportFragmentManager.beginTransaction()

        bundle.putString("name", data)
        when (tabName) {
            "FRAG1" -> {
                val tab = binding.tabLayout.getTabAt(0)
                binding.tabLayout.selectTab(tab)
                oneFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, oneFragment)
            }
            "FRAG2" -> {
                val tab = binding.tabLayout.getTabAt(1)
                binding.tabLayout.selectTab(tab)
                twoFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, twoFragment)
            }
            "FRAG3" -> {
                val tab = binding.tabLayout.getTabAt(2)
                binding.tabLayout.selectTab(tab)
                threeFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, threeFragment)
            }
        }
        transaction.commit()
    }
}


/* binding.btnMenu1.setOnClickListener(this)
 binding.btnMenu2.setOnClickListener(this)*/

/*override fun onClick(v: View?) {
    when (v?.id) {
        R.id.btnMenu1 -> {
            binding.ivCar.visibility = View.GONE
            val bundle = Bundle()

            bundle.putString("tvMessage1", "홍길동") // 번들객체 만듦
            oneFragment.arguments = bundle
            //supportFragmentManager :액티비티에 붙여주는 역할
            val fragmentTransient = supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, oneFragment)
                .commit()//화면이 바뀜
        }
        R.id.btnMenu2 -> {
            binding.ivCar.visibility = View.GONE
            val bundle = Bundle()
            bundle.putString("tvMessage2", "저길동") // 번들객체 만듦
            twoFragment.arguments = bundle
            val fragmentTransient = supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, twoFragment)
                .commit()
        }
    }
}
*/
/*fun sendMessage(data:String){
    val bundle = Bundle()
    bundle.putString("tvMessage2", data) // 번들 객체 만듦
    twoFragment.arguments = bundle
    val fragmentTransient = supportFragmentManager.beginTransaction()
        .replace(R.id.frameLayout, twoFragment)
        .commit()
}
fun sendMessage2(data:String){
    val bundle = Bundle()
    bundle.putString("tvMessage1", data) // 번들 객체 만듦
    oneFragment.arguments = bundle
    val fragmentTransient = supportFragmentManager.beginTransaction()
        .replace(R.id.frameLayout,oneFragment)
        .commit()*/
package com.example.wurongchef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.wurongchef.Interface.mainApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val ingredientFragment = IngredientFragment()
    private var activeFragment: Fragment = homeFragment


    private fun switchFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (activeFragment == homeFragment) {
            transaction.hide(homeFragment).show(ingredientFragment)
            activeFragment = ingredientFragment
        } else {
            transaction.hide(ingredientFragment).show(homeFragment)
            activeFragment = homeFragment
        }
        transaction.commit()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //레시피 이동용 할때 보관하는듯? 이동발생하면 // 이거 쓰면 안됨, 저장되서 덮어써짐
//           if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container, HomeFragment())
//                .commit()
//            }

        val homeBtn = findViewById<ImageView>(R.id.homeBtn)
        val ingredientBtn = findViewById<ImageView>(R.id.ingredientBtn)


        // 첫 화면으로 HomeFragment를 표시
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, ingredientFragment, "ingredient").hide(ingredientFragment)
            add(R.id.fragment_container, homeFragment, "home")
        }.commit()

        // 바텀 네비게이션 아이템 선택 시 프래그먼트 변경

//        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_home -> switchFragment(homeFragment)
//                R.id.nav_ingredient -> switchFragment(ingredientFragment)
//            }
//            true
//        }

        homeBtn.setOnClickListener {
            switchFragment()
        }
        ingredientBtn.setOnClickListener {
            switchFragment()
        }
    }

    override fun onResume() {
        super.onResume()


    }




}
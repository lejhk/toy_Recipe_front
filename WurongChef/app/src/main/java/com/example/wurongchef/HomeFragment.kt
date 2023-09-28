package com.example.wurongchef

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.wurongchef.Data.Recipe
import com.example.wurongchef.Data.signUp
import com.example.wurongchef.Interface.mainApi
import com.example.wurongchef.databinding.FragmentHomeBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    val api = Retrofit.Builder() // 메인api 클래스의 api 셋팅
        .baseUrl("http://10.0.2.2:8080")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(mainApi::class.java)

    var recipes: MutableList<Recipe> = mutableListOf() //크기 조절가능한 전체 레시피 받기용 리스트임


    suspend fun getAllRecipe(){ // 이거 recipes라는 전역 리스트 업데이트하는거임, 동기로 실행 요망
        val updateRecipe :List<Recipe> = api.getRecipe()
        recipes.clear()
        recipes.addAll(updateRecipe) // 아예 전역변수 초기화하고 채워버림
    }

    fun inputRow3() {
        if (recipes.size>=1) {
            Log.d("체크","${recipes[0].dish_name}")
            binding.row3Content1Title.text = recipes[0].dish_name
            // 뭐가 문제인지 알겠다 뷰바인딩으로 연결해서 값변경에서 오류뜨네 ㅇㅇ
        }
        if (recipes.size>=2) {
            Log.d("체크","오 ㄹㅇ2")
        }
        if (recipes.size>=3) {
            Log.d("체크","오 ㄹㅇ3")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //-----------시작
        binding = FragmentHomeBinding.inflate(inflater, container, false)
       // binding.row3Content1Title.text = recipes[0].subtitle

        runBlocking {
            getAllRecipe()
            inputRow3() //이거 빼면 돌아감
        }

        val singUpTest= signUp("이준혁","이준혁","1234","1234@naver.com")
        runBlocking {
           // api.signUp(singUpTest)
            Log.d("하하","회원가입넘어감")
        }



        return binding.root
    }
}
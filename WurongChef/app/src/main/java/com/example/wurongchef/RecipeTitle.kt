package com.example.wurongchef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class RecipeTitle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_title)

       findViewById<ImageView>(R.id.recipeTitleBackBtn).setOnClickListener { // 백버튼
            // 버튼이 클릭되었을 때 수행할 동작을 여기에 작성
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
        }
    }
}

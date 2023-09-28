package com.example.wurongchef.Interface

import com.example.wurongchef.Data.Recipe
import com.example.wurongchef.Data.signUp
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface mainApi {

    @GET("/api/recipes") // 모든 레시피 받아오기
    suspend fun getRecipe(): List<Recipe>


    @POST("/api/users/signup") // 회원가입
    suspend fun signUp(@Body signUpData: signUp)

}

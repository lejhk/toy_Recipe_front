package com.example.wurongchef.Data

data class Recipe(
    val id: Int =0 ,
    val dish_name: String ="",
    val subtitle: String ="",
    val total_time: Int= 0,
    val recipe_steps: List<RecipeStep> = emptyList(),
    val recipe_ingredients: List<RecipeIngredient> = emptyList()
)

data class RecipeStep(
    val step_order: Int= 0,
    val description: String="",
    val image_path: String?=""
)

data class RecipeIngredient(
    val id: Int= 0,
    val ingredient_name: String ="",
    val icon: String? ="",
    val quantity: Int = 0,
    val recipe_ingredient_id: Int = 0
)
package dev.dschmidt.foodkmm.datasource.network.interactors.recipe_list

import dev.dschmidt.foodkmm.datasource.network.RecipeService
import dev.dschmidt.foodkmm.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
) {
    fun execute(
        page:Int,
        query: String,
    ): Flow<List<Recipe>> = flow {
        //how can we emit loading??

        //emit recipes
        try {
            val recipes = recipeService.search(
                page = page,
                query = query
            )
            emit(recipes)
        } catch (e: Exception) {
            // how can we emit errors?
        }
    }
}
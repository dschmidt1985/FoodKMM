package dev.dschmidt.foodkmm.android.presentation.recipe_list


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import dev.dschmidt.foodkmm.android.presentation.recipe_list.components.RecipeList
import dev.dschmidt.foodkmm.android.presentation.recipe_list.components.SearchAppBar
import dev.dschmidt.foodkmm.android.presentation.theme.AppTheme
import dev.dschmidt.foodkmm.presentation.recipe_list.RecipeListEvents
import dev.dschmidt.foodkmm.presentation.recipe_list.RecipeListState

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onTriggerEvent: (RecipeListEvents) -> Unit,
    onClickRecipeListItem: (Int) -> Unit,
) {
    AppTheme(displayProgressBar = state.isLoading) {
        Scaffold(
            topBar = {
                SearchAppBar(
                    query = state.query,
                    onQueryChange = {
                        onTriggerEvent(RecipeListEvents.OnUpdateQuery(it))
                    },
                    onExecuteSearch = {
                        onTriggerEvent(RecipeListEvents.NewSearch)
                    }
                )
            }
        ) {
            RecipeList(
                loading = state.isLoading,
                recipes = state.recipes,
                page = state.page,
                onTriggerNextPage = { onTriggerEvent(RecipeListEvents.NextPage) },
                onClickRecipeListItem = onClickRecipeListItem
            )

        }
    }
}
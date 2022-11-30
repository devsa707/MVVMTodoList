package com.example.tutorial.mvvmtodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tutorial.mvvmtodolist.ui.add_edit_todo.AddEditTodoScreen
import com.example.tutorial.mvvmtodolist.ui.theme.MVVMtodoListTheme
import com.example.tutorial.mvvmtodolist.ui.todo_list.TodoListScren
import com.example.tutorial.mvvmtodolist.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMtodoListTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController, startDestination = Routes.TODO_LIST
                ) {
                    composable(Routes.TODO_LIST) {
                        TodoListScren(
                            onNavigate = {
                                    navController.navigate(it.route)
                            }
                        )

                    }
                    composable(
                        route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        arguments = listOf(
                            navArgument(name = "todoId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        AddEditTodoScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}

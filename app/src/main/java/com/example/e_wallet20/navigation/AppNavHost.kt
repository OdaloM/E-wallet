package com.example.e_wallet20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_wallet20.ui.theme.screens.dashboard.DashBoard
import com.example.e_wallet20.ui.theme.screens.login.Login
import com.example.e_wallet20.ui.theme.screens.payment.PaymentScreen
import com.example.e_wallet20.ui.theme.screens.payment.Requestmoney
import com.example.e_wallet20.ui.theme.screens.payment.SendMoney
import com.example.e_wallet20.ui.theme.screens.signup.Greeting

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SIGNUP){
    NavHost(navController=navController,
        startDestination=startDestination){
        composable(ROUTE_SIGNUP) { Greeting(navController) }
        composable(ROUTE_HOME) { DashBoard(navController) }
        composable(ROUTE_PAYMENTSCREEN) { SendMoney(navController)  }
        composable(ROUTE_REQUEST_MONEY) { Requestmoney(navController)  }
        composable(ROUTE_LOGIN) { Login(navController)  }
    }
}
package com.example.e_wallet20.ui.theme.screens.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_wallet20.R
import com.example.e_wallet20.navigation.ROUTE_PAYMENTSCREEN
import com.example.e_wallet20.navigation.ROUTE_REQUEST_MONEY
import com.example.e_wallet20.ui.theme.screens.history.TransactionsHistoryScreen
import com.example.e_wallet20.ui.theme.screens.payment.PaymentScreen
import com.example.e_wallet20.ui.theme.screens.payment.RequestMoneyScreen
import com.example.e_wallet20.ui.theme.screens.settings.SettingsScreen

@Composable
fun DashBoard(navController: NavHostController) {
    Box (){
        Image(modifier = Modifier
            .fillMaxSize(),
            painter = painterResource(id = R.drawable.umbrela),
            contentDescription ="dashboard background",
            contentScale = ContentScale.FillBounds)
    }
    Column {
        Card(
            modifier = Modifier
                .width(2000.dp)
                .clickable { navController.navigate(ROUTE_PAYMENTSCREEN) },
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(2000.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.Transparent)
            ) {
                Image(
                    modifier = Modifier
                        .background(Color.Transparent)
//                .fillMaxWidth()
                        .width(2000.dp),

                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "Bank"
                )
            }

        }
//        Paymentbuttons
        Spacer(modifier = Modifier.height(90.dp))
        Row(modifier = Modifier
            .align(Alignment.End)) {
            Button(modifier = Modifier,
                onClick = {
                    navController.navigate(ROUTE_PAYMENTSCREEN)
                },
                colors = ButtonDefaults
                    .buttonColors(Color.DarkGray))
            {
                Text(text = "SEND MONEY")

            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(modifier = Modifier
                ,
                onClick = {
                    navController.navigate(ROUTE_REQUEST_MONEY)
                },
                colors = ButtonDefaults
                    .buttonColors(Color.DarkGray))
            {
                Text(text = "REQUEST MONEY")
            }
            Spacer(modifier = Modifier.width(30.dp))

        }

    }


class HomeScreen() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.settings_screen)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val textView = TextView(this@HomeScreen).apply {
                text = "Welcome to E-pay!"
                textSize = 24f
                gravity = Gravity.CENTER
            }
            addView(textView)
            val buttonRequestMoney = Button(this@HomeScreen).apply {
                text = "Request Money"
                setOnClickListener {
                    val intent = Intent(this@HomeScreen, RequestMoneyScreen::class.java)
                    startActivity(intent)
                }
            }
            addView(buttonRequestMoney)
            val buttonSendMoney = Button(this@HomeScreen).apply {
                text = "Send Money"
                setOnClickListener {
                    val intent = Intent(this@HomeScreen, PaymentScreen::class.java)
                    startActivity(intent)
                }
            }
            addView(buttonSendMoney)
            val buttonTransactionsHistory = Button(this@HomeScreen).apply {
                text = "Transactions History"
                setOnClickListener {
                    val intent = Intent(this@HomeScreen, TransactionsHistoryScreen::class.java)
                    startActivity(intent)
                }
            }
            addView(buttonTransactionsHistory)
            val buttonSettings = Button(this@HomeScreen).apply {
                text = "Settings"
                setOnClickListener {
                    val intent = Intent(this@HomeScreen, SettingsScreen::class.java)
                    startActivity(intent)
                }
            }
            addView(buttonSettings)
        }
        setContentView(layout)
    }
}
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Dashboardpreview(){
    DashBoard(rememberNavController())

}

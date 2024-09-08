package com.example.e_wallet20.ui.theme.screens.payment

import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_wallet20.R
import com.example.e_wallet20.data.ClientViewModel
import com.example.e_wallet20.navigation.ROUTE_HOME


@Composable
fun Requestmoney (navController: NavHostController){
    var name by remember {
        mutableStateOf(String())
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { string: Uri? ->
        string?.let { name = it.toString() }
    }
    Box (modifier =Modifier
        .fillMaxSize()){
        Image(modifier = Modifier
            .fillMaxSize(),
            painter = painterResource(id = R.drawable.signup),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds)
    }





    var amount by remember {
    mutableStateOf(value = "")
     }
        Scaffold (
         bottomBar = {
            BottomAppBar (
               actions = {
                IconButton(onClick = { /*TODO*/ }) {
                       Icon(Icons.Filled.Home,
                        contentDescription ="Home Icon" )
                         }
                         IconButton(onClick = { /*TODO*/ }) {
                           Icon(Icons.Filled.Settings,
                             contentDescription = "Settings Icon")
                             }
                              IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Email,
                                        contentDescription = "Email Icon")
                                }
                            },
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = { /*TODO*/ },
                                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {
                                    Icon(Icons.Filled.AccountCircle,
                                        contentDescription ="Profile Icon" )
                                }
                            }
                        )




                    }
                ){innerPadding ->
                    Column (
                        modifier = Modifier
                            .padding(innerPadding)
                            .verticalScroll(rememberScrollState())
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Text(text = "REQUEST MONEY",
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                )
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "GO BACK")
                            }
                            val context = LocalContext.current
                            Button(onClick = {
                                val clientRepository = ClientViewModel(navController, context)

                                if (name.trim() != null) {
                                    clientRepository.saveClient(
                                        name =String(),
//                                        name = String.toString(),
                                        amount = amount

                                    )
                                    navController.navigate(ROUTE_HOME) // Navigate only after saving
                                } else {
                                    Toast.makeText(context, "Please write a name", Toast.LENGTH_SHORT).show()
                                }
//                                navController.navigate(ROUTE_HOME) // Navigate only after saving
                            }) {
                                Text(text = "NEXT")
                            }

                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
//
                        }
                        OutlinedTextField(
                            modifier = Modifier
                                .wrapContentWidth()
                                .align(Alignment.CenterHorizontally),
                            label = { Text(text = "Enter Recipient's name")},
                            placeholder = { Text(text = "Please enter their name ")},
                            value = name,
                            onValueChange = {
                                    newName -> name = newName
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            modifier = Modifier
                                .wrapContentWidth()
                                .align(Alignment.CenterHorizontally),
                            label = { Text(text = "Enter Amount")},
                            placeholder = { Text(text = "Please Enter Amount")},
                            value = amount,
                            onValueChange = {
                                    newAmount -> amount = newAmount
                            })
                        Spacer(modifier = Modifier.height(10.dp))

                        Spacer(modifier = Modifier.height(10.dp))

                        Spacer(modifier = Modifier.height(10.dp))


                    }
                }


            }






class RequestMoneyScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val textView = TextView(this@RequestMoneyScreen).apply {
                text = "Request Money"
                textSize = 24f
                gravity = Gravity.CENTER
            }
            addView(textView)
            val editTextAmount = EditText(this@RequestMoneyScreen).apply {
                hint = "Enter amount"
                inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
            }
            addView(editTextAmount)
            val editTextNote = EditText(this@RequestMoneyScreen).apply {
                hint = "Enter note (optional)"
                inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
            }
            addView(editTextNote)
            val buttonRequest = Button(this@RequestMoneyScreen).apply {
                text = "Request"
                setOnClickListener {
                    // Handle request money logic here
                    Toast.makeText(this@RequestMoneyScreen, "Money requested!", Toast.LENGTH_SHORT).show()
                }
            }
            addView(buttonRequest)
        }
        setContentView(layout)
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Requestpreview(){
    Requestmoney(rememberNavController())

}
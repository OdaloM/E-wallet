package com.example.e_wallet20.data



//import com.example.e_wallet20.navigation.ROUTE_LOGIN
//import com.example.e_wallet20.navigation.ROUTE_VIEW_CLIENT
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.navigation.NavController
import com.example.e_wallet20.model.Client
import com.example.e_wallet20.navigation.ROUTE_SIGNUP
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class ClientViewModel(var navController: NavController,
                      var context: Context) {
    var authRepository: AuthViewModel

    init {
        authRepository=AuthViewModel(navController,context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_SIGNUP)
        }
    }

    fun saveClient(
        name: String, amount: String,
        ){
        var id = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("Passport/$id")

        storageReference.putFile(Uri.EMPTY).addOnCompleteListener{
            if (it.isSuccessful){
                storageReference.downloadUrl.addOnSuccessListener{
                    var houseData = Client(name,amount,id)
                    var dbRef = FirebaseDatabase.getInstance().getReference().child("Client/$id")
                    dbRef.setValue(houseData)
                    Toast.makeText(context,"Payment Successful",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }
    }


}
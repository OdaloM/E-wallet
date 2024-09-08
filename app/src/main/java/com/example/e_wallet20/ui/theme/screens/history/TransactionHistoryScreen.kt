package com.example.e_wallet20.ui.theme.screens.history

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TransactionsHistoryScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val textView = TextView(this@TransactionsHistoryScreen).apply {
                text = "Transactions History"
                textSize = 24f
                gravity = Gravity.CENTER
            }
            addView(textView)
            val listView = ListView(this@TransactionsHistoryScreen).apply {
                // Populate list view with transaction history data
            }
            addView(listView)
        }
        setContentView(layout)
    }
}
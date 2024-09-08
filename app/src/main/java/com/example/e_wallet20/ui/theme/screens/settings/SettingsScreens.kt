package com.example.e_wallet20.ui.theme.screens.settings

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val textView = TextView(this@SettingsScreen).apply {
                text = "Settings"
                textSize = 24f
                gravity = Gravity.CENTER
            }
            addView(textView)
            val switchNotification = Switch(this@SettingsScreen).apply {
                text = "Enable notifications"
            }
            addView(switchNotification)
            val buttonLogout = Button(this@SettingsScreen).apply {
                text = "Logout"}}}}
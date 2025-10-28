package com.example.finai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.finai.event.AndroidCompact28
import com.example.finai.forum.AndroidCompact32
import com.example.finai.forum.AndroidCompact34
import com.example.finai.profile.AndroidCompact43 // <-- Import composable Anda
import com.example.finai.profile.AndroidCompact44
import com.example.finai.profile.AndroidCompact48
import com.example.finai.ui.theme.FINAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Memungkinkan aplikasi mengisi seluruh layar
        setContent {
            FINAITheme {
                // Memanggil composable AndroidCompact5 Anda sebagai layar utama
                AndroidCompact48(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
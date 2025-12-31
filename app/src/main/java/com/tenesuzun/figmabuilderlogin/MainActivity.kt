package com.tenesuzun.figmabuilderlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder.SignUpScreen
import com.tenesuzun.figmabuilderlogin.ui.theme.FigmaBuilderLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FigmaBuilderLoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SignUpScreen(
                        onBackClick = { /* Handle back navigation */ },
                        onRegisterClick = { /* Handle registration */ },
                        onLoginClick = { /* Handle login navigation */ }
                    )
                }
            }
        }
    }
}

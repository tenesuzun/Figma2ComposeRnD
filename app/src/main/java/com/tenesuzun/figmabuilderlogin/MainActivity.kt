package com.tenesuzun.figmabuilderlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.tenesuzun.figmabuilderlogin.figma2html.LoginScreen
import com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder.SignUpScreen
import com.tenesuzun.figmabuilderlogin.ui.theme.FigmaBuilderLoginTheme
import com.tenesuzun.figmabuilderlogin.liveScore.LiveScoreScreen
import com.tenesuzun.figmabuilderlogin.liveScore.LiveScoreScreenWithViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FigmaBuilderLoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // SignUpScreen composable commented out as requested
                    /*
                    SignUpScreen(
                        onBackClick = { /* Handle back navigation */ },
                        onRegisterClick = { /* Handle registration */ },
                        onLoginClick = { /* Handle login navigation */ }
                    )
                    */

                    // LiveScore screen from Figma design
                    // Use LiveScoreScreenWithViewModel() for production with state management
                    // Use LiveScoreScreen() for simple version without ViewModel
//                    LiveScoreScreenWithViewModel()
//                    LiveScoreScreen()

                    // Figma2Html - HtmlToCompose by Gemini
                    LoginScreen()
                }
            }
        }
    }
}

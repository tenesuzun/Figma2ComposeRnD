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
                    // builder.io
                    SignUpScreen(
                        onBackClick = { /* Handle back navigation */ },
                        onRegisterClick = { /* Handle registration */ },
                        onLoginClick = { /* Handle login navigation */ }
                    )

                    /***
                     * Figma To Compose Github proje fazla error ve eksikler var kod run edilebilir değil
                     * projeyi kendi pc'ne clone ediyorsun
                     * sonra onu terminalden run ediyorsun localhost görevi görüyor
                     * run olduktan sonra figma da plugini aktif ediyorsun ve belli elementleri seçiyorsun
                     * plugin ekranında local host bağlantısını test ediyorsun bağlantı başarılıysa seçtiğin element için kod üretmesini başlatıyorsun
                     * biraz beklemeden sonra ürettiği composable methodları kopyalanabilir şekilde basıyor ancak importların hepsi eksik
                     * hep constraintlayout kullanarak ilerliyor onların da constrainti figma da yoksa methodların hepsinin içleri boş geliyor
                     * method isimleri ve yazım kuralları pek iyi değil
                     * hem studio hem figma taraflı ekstra uğraşmak gerekiyor
                     */


                }
            }
        }
    }
}

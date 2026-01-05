package com.tenesuzun.figmabuilderlogin.figma2html

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// HTML'deki renklere göre tanımlamalar
val PrimaryBlue = Color(0xFF4D81E7) // rgba(77, 129, 231, 1)
val DarkText = Color(0xFF111827)    // rgba(17, 24, 39, 1)
val GrayText = Color(0xFF6C7278)    // rgba(108, 114, 120, 1)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("Loisbecket@gmail.com") }
    var password by remember { mutableStateOf("*******") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        // Başlık (HTML'deki .f2h-text-1.h1)
        Text(
            text = "Login",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText,
            letterSpacing = (-1).sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Alt Bilgi (HTML'deki .f2h-text-2)
        Text(
            text = "Enter your email and password to log in",
            fontSize = 14.sp,
            color = GrayText,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Email Alanı
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Şifre Alanı
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        // Hatırla Beni ve Şifremi Unuttum Satırı
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                Text(
                    text = "Remember me",
                    fontSize = 12.sp,
                    color = GrayText
                )
            }

            TextButton(onClick = { /* Şifremi unuttum */ }) {
                Text(
                    text = "Forgot Password ?",
                    fontSize = 12.sp,
                    color = PrimaryBlue,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Log In Butonu (HTML'deki .f2h-text-7)
        Button(
            onClick = { /* Giriş işlemi */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Log In", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Ayırıcı Metin
        Text(
            text = "Or login with",
            fontSize = 12.sp,
            color = GrayText
        )

        // Sosyal Giriş Butonları (Görsel temsil amaçlı alan)
        // Tasarımda "Or login with" altında ikonlar olduğunu varsayıyorum
        Spacer(modifier = Modifier.height(40.dp))

        // Kayıt Ol Alanı (HTML'deki .f2h-text-9 ve 10)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don’t have an account? ",
                fontSize = 14.sp,
                color = GrayText
            )
            TextButton(onClick = { /* Kayıt ol */ }) {
                Text(
                    text = "Sign Up",
                    fontSize = 14.sp,
                    color = PrimaryBlue,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
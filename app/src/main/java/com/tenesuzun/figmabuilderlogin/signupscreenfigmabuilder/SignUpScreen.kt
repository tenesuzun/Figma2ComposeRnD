package com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(
    onBackClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    var firstName by remember { mutableStateOf("Lois") }
    var lastName by remember { mutableStateOf("Becket") }
    var email by remember { mutableStateOf("Loisbecket@gmail.com") }
    var birthDate by remember { mutableStateOf("18/03/2024") }
    var phoneNumber by remember { mutableStateOf("(454) 726-0592") }
    var password by remember { mutableStateOf("*******") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background gradient circles
        Box(
            modifier = Modifier
                .size(582.dp)
                .offset(x = (-229).dp, y = (-163).dp)
                .background(
                    color = SignUpColors.BackgroundGradient1.copy(alpha = 0.8f),
                    shape = CircleShape
                )
                .blur(184.dp)
        )
        
        Box(
            modifier = Modifier
                .size(934.dp)
                .offset(x = 27.dp, y = 419.dp)
                .background(
                    color = SignUpColors.BackgroundGradient2.copy(alpha = 0.8f),
                    shape = CircleShape
                )
                .blur(295.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            // Status bar spacer (44dp height)
            Spacer(modifier = Modifier.height(44.dp))

            // Back button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 32.dp, bottom = 25.dp)
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = SignUpColors.Secondary500
                    )
                }
            }

            // Main content card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                // White blur effect
                Box(
                    modifier = Modifier
                        .size(320.5.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = 169.5.dp, y = (-170.5).dp)
                        .background(Color.White, CircleShape)
                        .blur(65.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            SignUpColors.CardBackground,
                            RoundedCornerShape(12.dp)
                        )
                        .border(1.dp, Color.White, RoundedCornerShape(12.dp))
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    // Header
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Sign Up",
                            color = SignUpColors.Headline,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 41.6.sp,
                            letterSpacing = (-0.64).sp
                        )
                        
                        Text(
                            text = "Create an account to continue!",
                            color = SignUpColors.Grey,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 16.8.sp,
                            letterSpacing = (-0.12).sp
                        )
                    }

                    // Input fields
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        CustomInputField(
                            value = firstName,
                            onValueChange = { firstName = it },
                            placeholder = "First Name"
                        )

                        CustomInputField(
                            value = lastName,
                            onValueChange = { lastName = it },
                            placeholder = "Last Name"
                        )

                        CustomInputField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = "Email"
                        )

                        CustomInputField(
                            value = birthDate,
                            onValueChange = { birthDate = it },
                            placeholder = "Birth of date",
                            trailingIcon = { CalendarIcon() }
                        )

                        PhoneInputField(
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            countryCode = "🇬🇧",
                            onCountryClick = { /* Handle country selection */ }
                        )

                        CustomInputField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = "Set Password",
                            visualTransformation = if (passwordVisible) 
                                VisualTransformation.None 
                            else 
                                PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(
                                    onClick = { passwordVisible = !passwordVisible },
                                    modifier = Modifier.size(16.dp)
                                ) {
                                    Icon(
                                        imageVector = if (passwordVisible)
                                            androidx.compose.material.icons.Icons.Default.Check
                                        else
                                            androidx.compose.material.icons.Icons.Default.Close,
                                        contentDescription = "Toggle password visibility",
                                        tint = SignUpColors.IconColor,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        )
                    }

                    // Register button
                    PrimaryButton(
                        text = "Register",
                        onClick = onRegisterClick
                    )

                    // Login link
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Already have an account?",
                            color = SignUpColors.Grey,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 16.8.sp,
                            letterSpacing = (-0.12).sp
                        )
                        
                        Spacer(modifier = Modifier.width(6.dp))
                        
                        Text(
                            text = "Login",
                            color = SignUpColors.Information500,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 16.8.sp,
                            letterSpacing = (-0.12).sp,
                            modifier = Modifier.clickable(onClick = onLoginClick)
                        )
                    }
                }
            }

            // Home indicator
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp)
                    .padding(horizontal = 113.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(148.dp)
                        .height(5.dp)
                        .background(SignUpColors.Headline, RoundedCornerShape(2.5.dp))
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}

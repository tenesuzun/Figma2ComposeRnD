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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Enhanced Sign Up Screen with ViewModel integration
 * 
 * This is an example showing how to integrate the Sign Up UI with a ViewModel
 * for production use. It includes:
 * - Form validation
 * - Loading states
 * - Error handling
 * - Success states
 * 
 * To use this screen instead of the basic one, replace SignUpScreen
 * with SignUpScreenWithViewModel in MainActivity.
 */
@Composable
fun SignUpScreenWithViewModel(
    viewModel: SignUpViewModel = viewModel(),
    onBackClick: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    // Handle registration success
    LaunchedEffect(uiState.registrationSuccess) {
        if (uiState.registrationSuccess) {
            onRegisterSuccess()
        }
    }

    // Show error message if any
    uiState.errorMessage?.let { error ->
        AlertDialog(
            onDismissRequest = { viewModel.clearError() },
            title = { Text("Error") },
            text = { Text(error) },
            confirmButton = {
                TextButton(onClick = { viewModel.clearError() }) {
                    Text("OK")
                }
            }
        )
    }

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
            // Status bar spacer
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
                            value = uiState.firstName,
                            onValueChange = viewModel::onFirstNameChange,
                            placeholder = "First Name"
                        )
                        uiState.firstNameError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        CustomInputField(
                            value = uiState.lastName,
                            onValueChange = viewModel::onLastNameChange,
                            placeholder = "Last Name"
                        )
                        uiState.lastNameError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        CustomInputField(
                            value = uiState.email,
                            onValueChange = viewModel::onEmailChange,
                            placeholder = "Email"
                        )
                        uiState.emailError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        CustomInputField(
                            value = uiState.birthDate,
                            onValueChange = viewModel::onBirthDateChange,
                            placeholder = "Birth of date",
                            trailingIcon = { CalendarIcon() }
                        )
                        uiState.birthDateError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        PhoneInputField(
                            value = uiState.phoneNumber,
                            onValueChange = viewModel::onPhoneNumberChange,
                            countryCode = "🇬🇧",
                            onCountryClick = { /* Handle country selection */ }
                        )
                        uiState.phoneNumberError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }

                        CustomInputField(
                            value = uiState.password,
                            onValueChange = viewModel::onPasswordChange,
                            placeholder = "Set Password",
                            visualTransformation = if (uiState.isPasswordVisible) 
                                VisualTransformation.None 
                            else 
                                PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(
                                    onClick = viewModel::togglePasswordVisibility,
                                    modifier = Modifier.size(16.dp)
                                ) {
                                    Icon(
                                        imageVector = if (uiState.isPasswordVisible)
                                            Icons.Default.Check
                                        else
                                            Icons.Default.Close,
                                        contentDescription = "Toggle password visibility",
                                        tint = SignUpColors.IconColor,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        )
                        uiState.passwordError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }
                    }

                    // Register button
                    Box {
                        PrimaryButton(
                            text = if (uiState.isLoading) "Registering..." else "Register",
                            onClick = viewModel::onRegisterClick
                        )
                        
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }

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
fun SignUpScreenWithViewModelPreview() {
    SignUpScreenWithViewModel()
}

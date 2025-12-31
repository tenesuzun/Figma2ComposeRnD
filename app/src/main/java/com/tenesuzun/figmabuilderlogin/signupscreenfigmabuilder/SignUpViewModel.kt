package com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for Sign Up Screen
 * 
 * This is an example implementation showing how to manage state and business logic
 * for the Sign Up screen using MVVM architecture.
 * 
 * Usage in SignUpScreen:
 * ```
 * val viewModel: SignUpViewModel = viewModel()
 * val uiState by viewModel.uiState.collectAsState()
 * ```
 */
class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun onFirstNameChange(value: String) {
        _uiState.value = _uiState.value.copy(
            firstName = value,
            firstNameError = null
        )
    }

    fun onLastNameChange(value: String) {
        _uiState.value = _uiState.value.copy(
            lastName = value,
            lastNameError = null
        )
    }

    fun onEmailChange(value: String) {
        _uiState.value = _uiState.value.copy(
            email = value,
            emailError = null
        )
    }

    fun onBirthDateChange(value: String) {
        _uiState.value = _uiState.value.copy(
            birthDate = value,
            birthDateError = null
        )
    }

    fun onPhoneNumberChange(value: String) {
        _uiState.value = _uiState.value.copy(
            phoneNumber = value,
            phoneNumberError = null
        )
    }

    fun onPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(
            password = value,
            passwordError = null
        )
    }

    fun togglePasswordVisibility() {
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }

    fun onRegisterClick() {
        if (validateForm()) {
            registerUser()
        }
    }

    private fun validateForm(): Boolean {
        val state = _uiState.value
        var isValid = true

        // Validate first name
        if (state.firstName.isBlank()) {
            _uiState.value = _uiState.value.copy(firstNameError = "First name is required")
            isValid = false
        }

        // Validate last name
        if (state.lastName.isBlank()) {
            _uiState.value = _uiState.value.copy(lastNameError = "Last name is required")
            isValid = false
        }

        // Validate email
        if (state.email.isBlank()) {
            _uiState.value = _uiState.value.copy(emailError = "Email is required")
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            _uiState.value = _uiState.value.copy(emailError = "Invalid email format")
            isValid = false
        }

        // Validate birth date
        if (state.birthDate.isBlank()) {
            _uiState.value = _uiState.value.copy(birthDateError = "Birth date is required")
            isValid = false
        }

        // Validate phone number
        if (state.phoneNumber.isBlank()) {
            _uiState.value = _uiState.value.copy(phoneNumberError = "Phone number is required")
            isValid = false
        }

        // Validate password
        if (state.password.isBlank()) {
            _uiState.value = _uiState.value.copy(passwordError = "Password is required")
            isValid = false
        } else if (state.password.length < 8) {
            _uiState.value = _uiState.value.copy(passwordError = "Password must be at least 8 characters")
            isValid = false
        }

        return isValid
    }

    private fun registerUser() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            try {
                // TODO: Call your API here
                // Example:
                // val result = authRepository.register(
                //     firstName = _uiState.value.firstName,
                //     lastName = _uiState.value.lastName,
                //     email = _uiState.value.email,
                //     birthDate = _uiState.value.birthDate,
                //     phoneNumber = _uiState.value.phoneNumber,
                //     password = _uiState.value.password
                // )
                
                // Simulate network delay
                kotlinx.coroutines.delay(2000)
                
                // On success
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    registrationSuccess = true
                )
                
            } catch (e: Exception) {
                // On error
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Registration failed"
                )
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

/**
 * UI State for Sign Up Screen
 */
data class SignUpUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val birthDate: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val birthDateError: String? = null,
    val phoneNumberError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val registrationSuccess: Boolean = false
)

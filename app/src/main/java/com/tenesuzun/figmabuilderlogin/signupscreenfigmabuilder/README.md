# Sign Up Screen - Figma Builder

This folder contains the Sign Up screen implementation based on the Figma design.

## Structure

### Files:
1. **SignUpColors.kt** - Contains all color definitions used in the Sign Up screen
   - Primary colors (Headline, Grey, Stroke, etc.)
   - Gradient colors for background and buttons
   - Input field colors
   - Matches the exact colors from the Figma design

2. **SignUpComponents.kt** - Reusable UI components
   - `CustomInputField` - Standard text input field with optional icons
   - `PhoneInputField` - Specialized phone number input with country selector
   - `PrimaryButton` - Blue gradient button matching the design
   - Various icon components (Calendar, Eye, Back Arrow)

3. **SignUpScreen.kt** - Main screen composable
   - Complete Sign Up screen layout
   - Background gradients (peach and purple blurred circles)
   - White frosted glass card effect
   - All input fields with proper styling
   - Register button and login link

## Features:
- ✅ Exact color matching from Figma design
- ✅ Blurred background gradients
- ✅ Frosted glass card effect
- ✅ Custom input fields with icons
- ✅ Phone number input with country selector
- ✅ Password field with visibility toggle
- ✅ Date picker field with calendar icon
- ✅ Primary button with gradient
- ✅ Status bar and home indicator
- ✅ Fully responsive layout

## Usage:
The Sign Up screen is integrated into MainActivity. To use it in other parts of your app:

```kotlin
import com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder.SignUpScreen

SignUpScreen(
    onBackClick = { /* Handle back navigation */ },
    onRegisterClick = { /* Handle registration */ },
    onLoginClick = { /* Navigate to login screen */ }
)
```

## Design Specifications:
- **Screen Width**: 375dp
- **Screen Height**: 812dp (iPhone dimensions)
- **Border Radius**: 12dp (card), 10dp (inputs and button)
- **Typography**: Inter font family (default Android sans-serif as fallback)
- **Spacing**: 24dp padding, 6dp gap between inputs

## Color Palette:
- Headline: #111827
- Grey: #6C7278
- Stroke: #EDF1F3
- Information Blue: #4D81E7
- Background Gradients: #EBC894 (peach), #B49EF4 (purple)

## State Management:
The screen uses `remember` and `mutableStateOf` for local state:
- First name
- Last name
- Email
- Birth date
- Phone number
- Password
- Password visibility toggle

## Future Enhancements:
- Add form validation
- Integrate with backend API
- Add date picker dialog
- Add country code selector dialog
- Add loading states
- Add error handling

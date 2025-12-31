package com.tenesuzun.figmabuilderlogin.signupscreenfigmabuilder

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(10.dp),
                spotColor = Color(0x3DE4E5E7)
            )
            .background(SignUpColors.InputBackground, RoundedCornerShape(10.dp))
            .border(1.dp, SignUpColors.InputBorder, RoundedCornerShape(10.dp))
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(12.dp))
                }
                
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    textStyle = TextStyle(
                        color = SignUpColors.InputText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (-0.14).sp
                    ),
                    visualTransformation = visualTransformation,
                    modifier = Modifier.fillMaxWidth(),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    color = SignUpColors.InputText,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = (-0.14).sp
                                )
                            )
                        }
                        innerTextField()
                    }
                )
            }
            
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}

@Composable
fun PhoneInputField(
    value: String,
    onValueChange: (String) -> Unit,
    countryCode: String,
    onCountryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(10.dp),
                spotColor = Color(0x3DE4E5E7)
            )
            .background(SignUpColors.InputBackground, RoundedCornerShape(10.dp))
            .border(1.dp, SignUpColors.InputBorder, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Country selector
            Box(
                modifier = Modifier
                    .width(62.dp)
                    .fillMaxHeight()
                    .background(SignUpColors.InputBackground, RoundedCornerShape(10.dp))
                    .border(1.dp, SignUpColors.InputBorder, RoundedCornerShape(10.dp))
                    .clickable(onClick = onCountryClick)
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🇬🇧",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "▼",
                        fontSize = 8.sp,
                        color = SignUpColors.Grey
                    )
                }
            }
            
            // Phone number input
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(
                    color = SignUpColors.InputText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-0.14).sp
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp)
            )
        }
    }
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            SignUpColors.ButtonGradientStart,
                            SignUpColors.ButtonGradientEnd
                        )
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = Color(0x7A253EA7)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = (-0.14).sp
            )
        }
    }
}

@Composable
fun CalendarIcon() {
    Icon(
        imageVector = androidx.compose.material.icons.Icons.Default.DateRange,
        contentDescription = "Calendar",
        tint = SignUpColors.IconColor,
        modifier = Modifier.size(16.dp)
    )
}

@Composable
fun EyeOffIcon(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(16.dp)
    ) {
        Icon(
            imageVector = androidx.compose.material.icons.Icons.Default.Close,
            contentDescription = "Toggle password visibility",
            tint = SignUpColors.IconColor,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun BackArrowIcon(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(24.dp)
    ) {
        Icon(
            imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = SignUpColors.Secondary500,
            modifier = Modifier.size(24.dp)
        )
    }
}

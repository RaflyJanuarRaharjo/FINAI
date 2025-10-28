package com.example.finai.ui.auth.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.finai.R
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.filled.CheckBox
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finai.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var termsAccepted by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp, y = 193.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 724.dp)
                .clip(shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                .background(color = Color.White)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 230.dp)
                .padding(horizontal = 32.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = "Get Started",
                color = Color(0xff3250a1),
                textAlign = TextAlign.Center,
                lineHeight = 0.69.em,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            )

            SimpleTextField(
                value = name,
                onValueChange = { name = it },
                label = "Name"
            )

            Spacer(modifier = Modifier.height(16.dp))

            SimpleTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordField(
                value = password,
                onValueChange = { password = it },
                isVisible = passwordVisible,
                onVisibilityChange = { passwordVisible = !passwordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TermsRow(
                isChecked = termsAccepted,
                onCheckedChange = { termsAccepted = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                        if (termsAccepted) {
                            navController.navigate(Routes.SIGN_IN)
                        } else {
                            Toast.makeText(context, "Harap setujui Syarat & Ketentuan", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff3759b3)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 47.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(13.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vec206),
                    contentDescription = "Vector 206",
                    modifier = Modifier
                        .requiredWidth(width = 114.dp)
                        .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
                )
                Text(
                    text = "Sign Up With",
                    color = Color.Black.copy(alpha = 0.5f),
                    lineHeight = 0.8.em,
                    style = TextStyle(fontSize = 15.sp)
                )
                Image(
                    painter = painterResource(id = R.drawable.vec207),
                    contentDescription = "Vector 207",
                    modifier = Modifier
                        .requiredWidth(width = 114.dp)
                        .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButtonFacebook(onClick = {
                    Toast.makeText(context, "Login dengan Facebook", Toast.LENGTH_SHORT).show()
                })
                SocialButtonGoogle(onClick = {
                    Toast.makeText(context, "Login dengan Google", Toast.LENGTH_SHORT).show()
                })
                SocialButtonTwitter(onClick = {
                    Toast.makeText(context, "Login dengan Twitter", Toast.LENGTH_SHORT).show()
                })
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account ?",
                    color = Color.Black.copy(alpha = 0.5f),
                    lineHeight = 1.em,
                    style = TextStyle(fontSize = 12.sp)
                )
                Text(
                    text = "Sign In",
                    color = Color(0xff3759b3),
                    lineHeight = 1.em,
                    style = TextStyle(fontSize = 12.sp),
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.SIGN_IN)
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = Color.Black.copy(alpha = 0.5f),
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xff3759b3),
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    isVisible: Boolean,
    onVisibilityChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = "Password",
                color = Color.Black.copy(alpha = 0.5f),
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
            )
        },
        singleLine = true,
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val description = if (isVisible) "Hide password" else "Show password"
            IconButton(onClick = onVisibilityChange) {
                if (isVisible) {
                    Icon(painter = painterResource(id = R.drawable.close_eye), contentDescription = description,
                        modifier = Modifier.requiredSize(size = 24.dp))
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.iconeye),
                        contentDescription = description,
                        tint = Color(0xff192851),
                        modifier = Modifier.requiredSize(size = 24.dp)
                    )
                }
            }
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xff3759b3),
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun TermsRow(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!isChecked) }
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Filled.CheckBox,
                contentDescription = "Checkbox Terms Checked",
                tint = Color(0xff1877f2),
                modifier = Modifier.requiredSize(size = 20.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.checkblank),
                contentDescription = "Checkbox Terms Unchecked",
                tint = Color(0xff192851),
                modifier = Modifier.requiredSize(size = 20.dp)
            )
        }

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append("Dengan Bergabung ke FinAi, saya setuju dengan ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff1877f2),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Syarat & Ketentuan")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append(" serta ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff1877f2),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Kebijakan Privasi")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 10.sp)) {
                    append(" yang ada.")
                }
            },
            modifier = Modifier.weight(1f),
            // --- TAMBAHKAN BARIS INI ---
            lineHeight = 12.sp
            // ---------------------------
        )
    }
}

@Composable
fun SocialButtonFacebook(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.requiredSize(size = 75.dp)) {
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "logos:facebook",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun SocialButtonGoogle(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.requiredSize(size = 75.dp)) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "devicon:google",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun SocialButtonTwitter(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.requiredSize(size = 75.dp)) {
        Image(
            painter = painterResource(id = R.drawable.twitter),
            contentDescription = "prime:twitter",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(widthDp = 412, heightDp = 917, showBackground = true)
@Composable
private fun AndroidCompact2Preview() {
    SignUpScreen(navController = rememberNavController())
}
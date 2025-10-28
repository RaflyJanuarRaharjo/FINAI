package com.example.finai.ui.auth.signin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finai.R
import com.example.finai.Routes
import android.widget.Toast


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 28.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "Welcome back",
                    color = Color(0xff3250a1),
                    textAlign = TextAlign.Center,
                    lineHeight = 0.69.em,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(top = 40.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var passwordVisible by remember { mutableStateOf(false) }

                    // Form Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xff3759b3),
                            unfocusedBorderColor = Color.Black.copy(alpha = 0.49f),
                            focusedLabelColor = Color(0xff3759b3),
                            unfocusedLabelColor = Color.Black.copy(alpha = 0.5f)
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        singleLine = true
                    )

                    // Form Password
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xff3759b3),
                            unfocusedBorderColor = Color.Black.copy(alpha = 0.49f),
                            focusedLabelColor = Color(0xff3759b3),
                            unfocusedLabelColor = Color.Black.copy(alpha = 0.5f)
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val imageRes = if (passwordVisible) {
                                R.drawable.close_eye
                            } else {
                                R.drawable.iconeye
                            }
                            val description = if (passwordVisible) "Hide password" else "Show password"
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = description,
                                    modifier = Modifier.requiredSize(24.dp)
                                )
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Forget Password ?",
                    color = Color(0xff3759b3),
                    lineHeight = 1.em,
                    style = TextStyle(fontSize = 12.sp),
                    modifier = Modifier
                        .align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /*TODO: Logika Sign In*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(55.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3759B3)
                    )
                ) {
                    Text(
                        text = "Sign In",
                        color = Color.White,
                        lineHeight = 0.6.em,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(13.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vec206),
                        contentDescription = "Vector 206",
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
                    )
                    Text(
                        text = "Sign In With",
                        color = Color.Black.copy(alpha = 0.5f),
                        lineHeight = 0.8.em,
                        style = TextStyle(
                            fontSize = 15.sp
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vec207),
                        contentDescription = "Vector 207",
                        modifier = Modifier
                            .weight(1f)
                            .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.5f)))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterHorizontally),
                    modifier = Modifier.fillMaxWidth()
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

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Text(
                        text = "Dont have an account ?",
                        color = Color.Black.copy(alpha = 0.5f),
                        lineHeight = 1.em,
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        text = "Sign Up",
                        color = Color(0xff3759b3),
                        lineHeight = 1.em,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.SIGN_UP)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
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

@Preview(widthDp = 412, heightDp = 917, showBackground = true) // <--- PERUBAIKAN: Tambahkan showBackground
@Composable
private fun AndroidCompact3Preview() {
    SignInScreen(navController = rememberNavController(), modifier = Modifier)
}
package com.example.loginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.ui.theme.LoginUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }

    @Composable
    fun LoginScreen() {
        var email by remember {
            mutableStateOf("");
        }
        var isPasswordVissible by remember {
            mutableStateOf(false);
        }
        var password by remember {
            mutableStateOf("");
        }
        val isFormValid by derivedStateOf {
            email.isNotEmpty() && password.length>7
        }
        Scaffold(backgroundColor = MaterialTheme.colors.primary) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                )
                Card(
                    Modifier
                        .padding(8.dp),
                    shape = RoundedCornerShape(topStart = 100.dp, topEnd = 20.dp, bottomStart =20.dp, bottomEnd =20.dp)
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "LogIn Your Account !!",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(40.dp))
                           OutlinedTextField(
                               modifier = Modifier.fillMaxWidth(),
                               value = email,
                               singleLine = true,
                               onValueChange ={email=it},
                               label = { Text(text = "UserName")},
                               trailingIcon = {
                                   IconButton(onClick = {email=""}) {
                                       Icon(imageVector = Icons.Filled.Clear, contentDescription ="" )
                                   }
                               },
                               leadingIcon = {
                                   Icon(painter = painterResource(id = R.drawable.email), contentDescription ="email" )
                               }
                           )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = password,
                                singleLine = true,
                                onValueChange ={password=it},
                                label = { Text(text = "Password")},
                                trailingIcon = {
                                    IconButton(onClick = {isPasswordVissible=!isPasswordVissible}) {
                                        Icon(
                                            imageVector = if (isPasswordVissible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                            contentDescription =""
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(painter = painterResource(id = R.drawable.password), contentDescription ="email" )
                                },
                                visualTransformation =if (isPasswordVissible) VisualTransformation.None else  PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                shape = RoundedCornerShape(16.dp),
                                enabled = isFormValid
                            ) {
                                Text(text = "LogIn",modifier = Modifier.padding(8.dp))
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "SignUp")
                                }
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Forgot Password", color =Color.Gray)
                                }
                            }

                        }

                    }

                }
            }
        }
    }
}
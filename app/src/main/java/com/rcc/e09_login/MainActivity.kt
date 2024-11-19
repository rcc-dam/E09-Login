package com.rcc.e09_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rcc.e09_login.navigation.Navigation
import com.rcc.e09_login.ui.theme.E09LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            E09LoginTheme() {
                // A surface container using the 'background' color from the theme
                // OJO !!!! HABILITAR INTERNET EN EL MANIFEST !!!!!!!!!!!!!!!

                Surface(
                    modifier = Modifier.fillMaxSize().padding(top = 46.dp),
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview() {
    E09LoginTheme() {
        MyScaffold()
    }
}


/* LOGIN POR MI */
@Composable
fun MyScaffold() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        color = Color.Black
    ) {
        Login(Modifier)
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Coloca la imagen en lugar del texto
        Image(
            painter = painterResource(id = R.drawable.crunchyroll_logo),
            contentDescription = "Logo de Crunchyroll",
            modifier = Modifier.width(300.dp).height(80.dp),
            contentScale = ContentScale.Crop // Recorta y centra la imagen
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Iniciar sesión",
            color = Color.Gray,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedLabelColor = Color(0xFFFF6600),
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.2f))
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedLabelColor = Color(0xFFFF6600),
                unfocusedLabelColor = Color.Gray
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.2f))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Acción de inicio de sesión */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6600), // Fondo naranja
                contentColor = Color.White         // Texto blanco
            )
        ) {
            Text("LOG IN")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "By logging in you're agreeing to our Terms & Privacy Policy and are at least 16 years old.",
            color = Color.Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Restore iTunes Purchases",
            color = Color(0xFFFF6600),
            fontSize = 14.sp,
            modifier = Modifier.clickable { /* Acción de restauración */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Forgot Password?",
                color = Color(0xFFFF6600),
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* Acción de recuperación de contraseña */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "|",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Create Account",
                color = Color(0xFFFF6600),
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* Acción de creación de cuenta */ }
            )
        }
    }
}
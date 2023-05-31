package com.example.pitjarustest.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pitjarustest.R
import com.example.pitjarustest.Routes
import com.example.pitjarustest.core.designsystem.MyIcons
import com.example.pitjarustest.ui.theme.PitjarusTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxHeight(1f)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.wave_top),
            contentDescription = ""
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }
            var checked by remember {
                mutableStateOf(false)
            }
            val mContext = LocalContext.current

            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp, 40.dp, 0.dp),
                label = { Text(text = "Username") },
                value = username.value,
                onValueChange = { username.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = MyIcons.AccountCircle,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
            )

            Spacer(modifier = Modifier.height(20.dp))

            var showPassword by remember { mutableStateOf(false) }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp, 40.dp, 0.dp),
                label = { Text(text = "Password") },
                value = password.value,
                onValueChange = { password.value = it },
                visualTransformation = if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                leadingIcon = {
                    Icon(
                        imageVector = MyIcons.Lock,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                MyIcons.Visibility,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    } else {
                        IconButton(onClick = { showPassword = true }) {
                            Icon(
                                MyIcons.VisibilityOff,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        text = "Keep Username",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = MyIcons.Download,
                        contentDescription = "drawable icons",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    ClickableText(
                        text = AnnotatedString("Check Update"),
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.primary,
                        ),
                        onClick = {
                            Toast.makeText(mContext, "Halo", Toast.LENGTH_SHORT).show()
                        })
                }
            }

            Spacer(modifier = Modifier.height(64.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { navController.navigate(Routes.Home.route) },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                ) {
                    Text(text = ("Login").uppercase())
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "App Ver 1.0.0-20013FEA6BCC820C",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Gray
                )
            )
        }

        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.wave_bottom),
            contentDescription = ""
        )
    }
}

@Preview("Preview Login Page", showBackground = true)
@Composable
fun PreviewLoginPage() {
    PitjarusTestTheme {
        LoginPage(rememberNavController())
    }
}
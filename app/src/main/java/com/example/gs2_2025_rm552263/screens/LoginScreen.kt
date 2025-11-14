import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    val usuario = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF2C4EC7))
            .padding(32.dp)
    ) {
        Text(
            text = "LOGIN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Usuário:",
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
            OutlinedTextField(
                value = usuario.value,
                onValueChange = { usuario.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Insira seu usuário.")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Senha:",
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
            OutlinedTextField(
                value = senha.value,
                onValueChange = { senha.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Insira sua senha."
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                        KeyboardType.Text
                )
            )
        }
        Button(
            onClick = {
                if (usuario.value == "admin" && senha.value == "123456") {
                    navController.navigate("menu")
                } else {
                    navController.navigate("login")
                }
            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Entrar",
                fontSize = 20.sp,
                color = Color.Blue
            )
        }
    }
}
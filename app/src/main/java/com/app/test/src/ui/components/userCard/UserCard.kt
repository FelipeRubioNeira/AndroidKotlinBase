package com.app.test.src.ui.components.userCard


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.test.src.data.model.User
import com.app.test.src.ui.components.label.Label
import com.app.test.src.ui.theme.colors.ColorsApp



@Preview(showBackground = true)
@Composable
fun UserCard(
    user: User = User(1, "Usuario", "email@gmail.com", 1995),
    onClick: () -> Unit = {}
) {

    val padding = 8.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = ColorsApp.Black, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {

        HeaderCard(value = user.name, modifier = Modifier.padding(padding))

        BodyCard(
            email = user.email,
            birthday = user.birthday.toString(),
            modifier = Modifier.padding(padding)
        )


    }

}

@Composable
fun HeaderCard(
    modifier: Modifier = Modifier,
    value: String = "Usuario default",
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ColorsApp.Primary,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
            .then(modifier),

        ) {
        Label(value = "Nombre Usuario:", fontWeight = FontWeight.Black)
        Spacer(modifier = Modifier.width(8.dp))
        Label(value = value, fontWeight = FontWeight.Black)
    }


}

@Composable
fun BodyCard(
    modifier: Modifier = Modifier, email: String, birthday: String
) {

    Column(modifier = modifier) {
        Label(value = email)

        Spacer(modifier = Modifier.height(4.dp))

        Label(value = birthday)
    }

}
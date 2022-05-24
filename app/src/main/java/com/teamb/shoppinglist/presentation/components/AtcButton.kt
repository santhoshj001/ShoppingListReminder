package com.teamb.shoppinglist.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamb.shoppinglist.R


@Composable
fun ATCButton() {
    Row(
        Modifier
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primary,

                )
            .padding(1.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var quantity by remember {
            mutableStateOf<Int>(0)
        }


        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = {
            quantity--
            if (quantity < 0)
                quantity = 0
        }) {
            Icon(
                painterResource(id = R.drawable.ic_remove),
                "",
                tint = MaterialTheme.colorScheme.primary
            )
        }


        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = quantity.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(8.dp))


        IconButton(onClick = {
            quantity++
        }) {
            Icon(
                Icons.Outlined.Add,
                contentDescription = "add ",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
@Preview
fun previewATC() {
    ATCButton()
}
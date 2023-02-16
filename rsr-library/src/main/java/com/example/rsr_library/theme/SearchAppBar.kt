package com.example.rsr_sdk.ui.theme

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.example.rsr_sdk.R

@Composable
fun SearchAppBar(modifier: Modifier = Modifier, value: String,
                 onValueChange: (String) -> Unit,
                 onCancel: () -> Unit,
                 onSearch: () -> Unit,
                 onSelect: () -> Unit,
                 placeholderText: String? = null) {
    Column(modifier = modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)) {
        SearchTextField(value = value, onValueChange = onValueChange, onCancel = onCancel, onSearch = onSearch,
                onSelect = onSelect, placeholderText = placeholderText)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SearchTextField(
        modifier: Modifier = Modifier,
        value: String,
        onValueChange: (String) -> Unit,
        onSearch: () -> Unit,
        onCancel: () -> Unit,
        onSelect: () -> Unit,
        placeholderText: String? = null
) {

    val colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            leadingIconColor = MaterialTheme.colors.onSurface,
            trailingIconColor = MaterialTheme.colors.onSurface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
    )

    TextField(
            modifier = modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        if (it.isFocused) {
                            onSelect()
                        }
                    }
                    .onKeyEvent {
                        if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                            onSearch()
                            true
                        } else false
                    },
            value = value,
            onValueChange = {
                onValueChange(it.replace("\n", ""))
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = placeholderText?.let {
                {
                    Text(text = it)
                }
            },
            trailingIcon = if (value.isNotBlank()) {
                {
                    Icon(
                            painter = painterResource(id = R.drawable.ic_clear),
                            contentDescription = "test",
                            modifier = Modifier.clickable { onCancel() }
                    )
                }
            } else null,
            leadingIcon = {
                Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "test",
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() }),
            singleLine = true,
            colors = colors
    )
}
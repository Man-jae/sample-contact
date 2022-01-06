package com.bemily.samplecontact.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemily.samplecontact.R
import com.bemily.samplecontact.data.model.Contact
import com.bemily.samplecontact.ui.component.SurfaceTopAppBar
import com.bemily.samplecontact.ui.theme.SampleContactTheme

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()
    val contactList: List<Contact> = Contact.getMockContactList()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            SurfaceTopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = lazyListState
        ) {
            items(contactList) { item ->
                ContactItem(
                    name = item.name,
                    phoneNumber = item.phoneNumber
                )
            }
        }
    }
}

@Composable
fun ContactItem(
    name: String = "",
    phoneNumber: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = phoneNumber,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSurface.copy(alpha = .5f)
        )
    }
}

@Preview("light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ContactAppPreview() {
    SampleContactTheme {
        ContactScreen()
    }
}
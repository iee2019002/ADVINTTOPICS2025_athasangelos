package com.anemoessa.advinttopics2025_athasangelos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anemoessa.advinttopics2025_athasangelos.CalculatorUI
import com.anemoessa.advinttopics2025_athasangelos.ui.theme.ADVINTTOPICS2025_athasangelosTheme

@Preview(showBackground = true)//PREVIEW
@Composable
fun DraftPreview() {
    ADVINTTOPICS2025_athasangelosTheme(darkTheme = true) {
        CalculatorUI()
    }
}


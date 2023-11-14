package com.maggiver.elements

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maggiver.elements.ui.login.coursera.LoginCoursera
import com.maggiver.elements.ui.login.coursera.NavigationCoursera
import com.maggiver.elements.ui.theme.ElementsTheme

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElementsTheme {

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    NavigationCoursera()

                    Column(
                        modifier = Modifier
                    ) {

                        /*LoginCoursera()*/


                        /*InputsDefault()
                        InputsCustom()
                        InputsCustomOneline()*/
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ElementsTheme {

    }
}
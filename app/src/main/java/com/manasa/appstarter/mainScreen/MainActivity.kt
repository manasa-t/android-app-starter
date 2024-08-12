package com.manasa.appstarter.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.manasa.appstarter.ui.theme.AppStarterTheme
import com.manasa.core.entities.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppStarterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenContent(modifier = Modifier.fillMaxSize(),viewModel = mainViewModel)
                   // Greeting()
                }
            }
        }
    }
}

@Composable
fun ScreenContent(modifier: Modifier,viewModel: MainViewModel){
    val screenState = viewModel.featureState.collectAsStateWithLifecycle()
    when(screenState.value.status){
          State.STATUS.LOADING-> Loading()
          State.STATUS.CONTENT -> Content(modifier,name = screenState.value.data?.param1, message = screenState.value.data?.param2)
          State.STATUS.ERROR -> Error()

    }
}

@Composable
fun Greeting() {
    Text(text = "Hello Welcome!")
}

@Composable
fun Content(modifier: Modifier,name: String? = "", message: String? = ""){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Text(text = "Hello $name!\nWelcome to $message", textAlign = TextAlign.Center,
           fontSize = TextUnit(20f, TextUnitType.Sp) )
    }

}

@Composable
fun Error(){
    Text(text = "Error!!")
}

@Composable
fun Loading(){
    Text(text = "Loading...")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppStarterTheme {
        Greeting()
    }
}
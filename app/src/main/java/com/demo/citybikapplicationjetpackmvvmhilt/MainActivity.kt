package com.demo.citybikapplicationjetpackmvvmhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.citybikapplicationjetpackmvvmhilt.model.CityBikeList
import com.demo.citybikapplicationjetpackmvvmhilt.ui.theme.CitybikApplicationJetPackMVVMHiltTheme
import com.demo.citybikapplicationjetpackmvvmhilt.viewmodel.CityBikeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val cityBikeViewModel:CityBikeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CitybikApplicationJetPackMVVMHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetCityBikeData(cityBikeViewModel = cityBikeViewModel)
                }
            }
        }
    }
}

@Composable
fun GetCityBikeData(cityBikeViewModel: CityBikeViewModel) {
    cityBikeViewModel.getCityBikeDataFromVM()
    val cityBike by cityBikeViewModel.cityBike.observeAsState(emptyList())
    val error by cityBikeViewModel.cityBikeError.observeAsState()

    LazyColumn{
        items(cityBike){bike->
            SetListData(cityBike = bike)
        }
    }

}

@Composable
fun SetListData(cityBike: CityBikeList){
    Card(modifier = Modifier
        .wrapContentSize()
        .padding(10.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = cityBike.id,
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = cityBike.name,
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CitybikApplicationJetPackMVVMHiltTheme {
        //Greeting("Android")

    }
}
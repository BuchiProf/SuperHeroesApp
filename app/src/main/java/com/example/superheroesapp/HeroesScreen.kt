package com.example.superheroesapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

@Composable
fun HeroesApp(){
    Scaffold(
        topBar = { HeroesTopBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes){
                HeroCard(
                    hero = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero,
             modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)

        ){
            Column(modifier=Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(modifier= Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
                ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
            }


        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge)
        },
        modifier = modifier
    )
}


@Preview
@Composable
fun HeroPreview() {

    SuperHeroesAppTheme {
        HeroesApp()
    //HeroCard(hero = hero)
    }
}

package com.richmondprojects.foodui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richmondprojects.foodui.ui.theme.FOODUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FOODUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FinalView()
                }
            }
        }
    }
}

@Composable
fun TopPart() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffeceef0)), Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Menu, contentDescription = "Menu Icon",
            Modifier
                .background(
                    Color.White
                )
                .clip(CircleShape)
                .size(40.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Location", style = MaterialTheme.typography.subtitle1)
            Row {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Red,
                )
                Text(text = "Accra")
            }

        }
        Icon(
            imageVector = Icons.Default.Notifications, contentDescription = "Notification Icon",
            Modifier
                .background(
                    Color.White
                )
                .clip(CircleShape)
                .size(40.dp)
        )

    }
}

@Composable
fun CardPart() {
    Card(modifier = Modifier.size(width = 310.dp, height = 150.dp), RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier.padding(10.dp), Arrangement.SpaceBetween) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(text = "Get Special Discounts")
                Text(text = "up to 85%", style = MaterialTheme.typography.h5)
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.Black)) {
                    Text(text = "Claim voucher", color = MaterialTheme.colors.surface)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.food_tip_im),
                contentDescription = "Food Image", Modifier.size(width = 100.dp, height = 200.dp)
            )
        }
    }
}

@Composable
fun SearchPart() {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Black
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(text = "search your food", color = Color.Black)
        },
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clip(RectangleShape), shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun PopularFood(
    @DrawableRes drawable: Int,
    @StringRes text1: Int
) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .size(width = 150.dp, height = 200.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f), Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon",
                    tint = Color.Yellow
                )
                Text(text = "4.3", fontWeight = FontWeight.Black)
            }
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "Food Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Text(text = stringResource(id = text1), fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.fillMaxWidth(0.7f), Arrangement.SpaceBetween) {
                /*TODO Implement Prices for each card*/
                Text(
                    text = "$50",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "shopping cart",
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularFoodColumn() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
    ) {
        items(FoodList) { item ->
            PopularFood(drawable = item.drawable, text1 = item.text1)
        }
    }
}

@Composable
fun BottomNavigation() {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home Icon",
                tint = Color.Black
            )
        })
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Setting Icon",
                tint = Color.Black
            )
        })
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Fav Icon",
                tint = Color.Black
            )
        })
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Icon",
                tint = Color.Black
            )
        })
    }
}

private val FoodList = listOf(
    R.drawable.sandwish to R.string.sandwich,
    R.drawable.burger to R.string.burgers,
    R.drawable.pack to R.string.pack,
    R.drawable.pasta to R.string.pasta,
    R.drawable.tequila to R.string.tequila,
    R.drawable.wine to R.string.wine,
    R.drawable.salad to R.string.salad,
    R.drawable.pop to R.string.popcorn
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text1: Int
)

@Preview
@Composable
fun TopPartPreview() {
    FOODUITheme {
        TopPart()
    }
}

@Preview
@Composable
fun CardPreview() {
    FOODUITheme {
        CardPart()
    }
}

@Preview
@Composable
fun SearchPartPreview() {
    FOODUITheme {
        SearchPart()
    }
}

@Preview
@Composable
fun PopularFoodPreview() {
    FOODUITheme {
        PopularFood(
            drawable = R.drawable.salad,
            text1 = R.string.salad,
        )
    }
}

@Preview
@Composable
fun PopularFoodColumnPreview() {
    FOODUITheme {
        PopularFoodColumn()
    }
}

@Preview
@Composable
fun NavigationPreview() {
    FOODUITheme {
        BottomNavigation()
    }
}

@Composable
fun App() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffeceef0))
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(modifier = Modifier, elevation = 5.dp) {
            TopPart()
        }
        Spacer(modifier = Modifier.padding(10.dp))
        CardPart()
        Spacer(modifier = Modifier.padding(10.dp))
        SearchPart()
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text(text = "Popular Food", style = MaterialTheme.typography.h5)
            Text(text = "view all", style = MaterialTheme.typography.subtitle1)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        PopularFoodColumn()
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FOODUITheme {
        App()
    }
}

@Preview
@Composable
fun FinalView() {
    FOODUITheme {
        Scaffold(bottomBar = { BottomNavigation() }) {
            App()
        }
    }
}
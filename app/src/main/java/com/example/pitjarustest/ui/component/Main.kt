package com.example.pitjarustest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pitjarustest.R
import com.example.pitjarustest.model.ItemMenu
import com.example.pitjarustest.model.ItemStat
import com.example.pitjarustest.model.itemMenus
import com.example.pitjarustest.model.itemStats
import com.example.pitjarustest.ui.theme.PitjarusTestTheme

@Composable
fun StatItem(
    itemStat: ItemStat,
    onStatClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable(onClick = { onStatClick(itemStat.id) }),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(itemStat.background, shape = RoundedCornerShape(20.dp))
                    .clip(shape = RoundedCornerShape(20.dp))
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = itemStat.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(modifier = Modifier.width(width = 6.dp))
            Text(
                text = itemStat.value.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(
            text = itemStat.name,
            fontSize = 14.sp
        )
    }
}

@Composable
fun UserImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    JetsnackSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.placeholder),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MenuItem(
    itemMenu: ItemMenu,
    onStatClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable(onClick = { onStatClick(itemMenu.id) })
        .width(width = 84.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .background(itemMenu.background, shape = RoundedCornerShape(20.dp))
                .clip(shape = RoundedCornerShape(20.dp))
                .padding(8.dp)
        ) {
            Image(
                painterResource(id = itemMenu.icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = itemMenu.name,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("default", showBackground = true)
@Composable
private fun StatItemPreview() {
    PitjarusTestTheme {
        StatItem(
            itemStat = itemStats[0],
            onStatClick = {},
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview("default", showBackground = true)
@Composable
private fun MenuItemPreview() {
    PitjarusTestTheme {
        MenuItem(
            itemMenu = itemMenus[3],
            onStatClick = {},
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview("default")
@Composable
private fun UserImagePreview() {
    PitjarusTestTheme {
        UserImage(
            imageUrl = "https://source.unsplash.com/c_GmwfHBDzk",
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
    }
}

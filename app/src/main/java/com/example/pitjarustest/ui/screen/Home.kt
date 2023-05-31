package com.example.pitjarustest.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pitjarustest.R
import com.example.pitjarustest.core.designsystem.MyIcons
import com.example.pitjarustest.model.ItemMenu
import com.example.pitjarustest.model.ItemStat
import com.example.pitjarustest.model.PitjarusRepo
import com.example.pitjarustest.model.User
import com.example.pitjarustest.model.users
import com.example.pitjarustest.ui.component.JetsnackSurface
import com.example.pitjarustest.ui.component.MenuItem
import com.example.pitjarustest.ui.component.MyCard
import com.example.pitjarustest.ui.component.MyDivider
import com.example.pitjarustest.ui.component.StatItem
import com.example.pitjarustest.ui.component.UserImage
import com.example.pitjarustest.ui.theme.PitjarusTestTheme
import com.example.pitjarustest.utils.MyUtils
import kotlin.math.max
import kotlin.math.min

private val BottomBarHeight = 56.dp
private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun Home(navController: NavHostController) {
    fun upPress() {
        navController.navigateUp()
    }

    val snack = remember { users[1] }
    val stats = remember { PitjarusRepo.getStats() }
    val menus = remember { PitjarusRepo.getMenus() }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(stats, menus, scroll, navController)
        Title(snack) { scroll.value }
        Image(snack.imageUrl) { scroll.value }
        Up()
        Refresh(modifier = Modifier.align(Alignment.TopEnd), onRefreshClick = { upPress() })
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(PitjarusTestTheme.colors.tornado1))
            .paint(painterResource(id = R.drawable.blue), contentScale = ContentScale.FillWidth)
    )
}

@Composable
private fun Up() {
    Text("Main Menu", modifier = Modifier.padding(18.dp), fontSize = 18.sp,
        color = Color.White)
}

@Composable
private fun Refresh(onRefreshClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = { onRefreshClick() },
        modifier = modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
    ) {
        Icon(
            imageVector = MyIcons.AutoRenew,
            tint = PitjarusTestTheme.colors.iconInteractive,
            contentDescription = stringResource(R.string.label_back)
        )
    }
}

@Composable
private fun Body(
    stats: List<ItemStat>,
    menus: List<ItemMenu>,
    scroll: ScrollState,
    navController: NavHostController = rememberNavController()
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            JetsnackSurface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp))

                    MyCard {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Kunjungan pada Bulan ${MyUtils.getDate("MMMM y")}",
                            fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(
                                        rememberScrollState()
                                    ),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                stats.forEach { stat ->
                                    key(stat.id) {
                                        StatItem(itemStat = stat, onStatClick = {}, modifier = Modifier.padding(18.dp, 12.dp))
                                    }
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    Column(modifier = Modifier.padding(4.dp)) {
                        Text(text = "Menu",
                            fontSize = 18.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp), color = Color(0xFFFF9106))
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.height(250.dp)
                        ) {
                            items(items = menus) { item ->
                                MenuItem(itemMenu = item, onStatClick = {
                                    when(it) {
                                        5L -> navController.navigateUp()
                                    }
                                })
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding()
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Title(user: User, scrollProvider: () -> Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
            .background(color = PitjarusTestTheme.colors.uiBackground)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = user.name,
            style = MaterialTheme.typography.h4,
            color = PitjarusTestTheme.colors.textSecondary,
            modifier = HzPadding
        )
        Text(
            text = "Role: ${user.role}",
            style = MaterialTheme.typography.subtitle2,
            fontSize = 20.sp,
            color = PitjarusTestTheme.colors.textHelp,
            modifier = HzPadding
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "NIK: ${user.nik}",
            style = MaterialTheme.typography.h6,
            color = PitjarusTestTheme.colors.textPrimary,
            modifier = HzPadding
        )

        Spacer(Modifier.height(8.dp))
        MyDivider()
    }
}

@Composable
private fun Image(
    imageUrl: String,
    scrollProvider: () -> Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }

    CollapsingImageLayout(
        collapseFractionProvider = collapseFractionProvider,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        UserImage(
            imageUrl = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFractionProvider: () -> Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val collapseFraction = collapseFractionProvider()

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.placeRelative(imageX, imageY)
        }
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun HomePreview() {
    PitjarusTestTheme {
        Home(navController = rememberNavController())
    }
}

package de.eller.kilian.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import de.eller.kilian.LocalDarkModeScope
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * used to display multiple bullets in either elevated or outlined card
 */
data class BulletCardData(
    val title: StringResource,
    val icon: ImageVector,
    val iconDarkMode: ImageVector = icon,
    val bullets: ImmutableList<StringResource>
)


@Composable
fun BulletElevatedCard(
    bulletCardData: BulletCardData,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(modifier) {
        BulledCardContent(bulletCardData)
    }
}

@Composable
fun BulletOutlinedCard(
    bulletCardData: BulletCardData,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(modifier) {
        BulledCardContent(bulletCardData)
    }
}

@Composable
private fun BulledCardContent(
    bulletCardData: BulletCardData
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(28.dp),
                imageVector = when (LocalDarkModeScope.current) {
                    true -> bulletCardData.iconDarkMode
                    false -> bulletCardData.icon
                },
                contentDescription = null,
            )

            Text(
                text = stringResource(bulletCardData.title),
                style = MaterialTheme.typography.titleMedium,
            )
        }

        bulletCardData.bullets.forEach { bullet ->
            Text("• " + stringResource(bullet),)
        }
    }
}
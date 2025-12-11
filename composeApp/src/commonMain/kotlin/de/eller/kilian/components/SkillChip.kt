package de.eller.kilian.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.eller.kilian.Skill
import org.jetbrains.compose.resources.stringResource

/**
 * displays skill in chip format that is not clickable
 *
 * @param skill data to display
 * @param skillChipWeight weight to display chip in different sizes
 */
@Composable
fun SkillChip(
    skill: Skill,
    skillChipWeight: SkillChipWeight,
) {
    InformationChip(
        modifier = Modifier.heightIn(min = skillChipWeight.height),
        leadingIcon = {
            Image(
                modifier = Modifier
                    .padding(vertical = skillChipWeight.verticalPadding)
                    .size(skillChipWeight.height - skillChipWeight.verticalPadding)
                    .aspectRatio(1f),
                imageVector = skill.icon,
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        },
        label = {
            Box(
                modifier = Modifier
                    .padding(vertical = skillChipWeight.verticalPadding)
                    .heightIn(min = skillChipWeight.height - skillChipWeight.verticalPadding),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(skill.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = skillChipWeight.textStyle(),
                )
            }
        },
    )
}

enum class SkillChipWeight(
    internal val height: Dp,
    internal val verticalPadding: Dp,
) {
    Small(
        height = 28.dp,
        verticalPadding = 8.dp,
    ),
    Large(
        height = 42.dp,
        verticalPadding = 12.dp,
    );
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun SkillChipWeight.textStyle(): TextStyle = when (this) {
    SkillChipWeight.Small -> MaterialTheme.typography.labelSmall
    SkillChipWeight.Large -> MaterialTheme.typography.bodyLarge
}
package de.eller.kilian.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.eller.kilian.TimeRange
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.month_april
import de.eller.kilian.resources.month_august
import de.eller.kilian.resources.month_december
import de.eller.kilian.resources.month_february
import de.eller.kilian.resources.month_january
import de.eller.kilian.resources.month_july
import de.eller.kilian.resources.month_june
import de.eller.kilian.resources.month_march
import de.eller.kilian.resources.month_may
import de.eller.kilian.resources.month_november
import de.eller.kilian.resources.month_october
import de.eller.kilian.resources.month_september
import de.eller.kilian.resources.time_range
import de.eller.kilian.resources.time_range_duration
import de.eller.kilian.resources.time_range_present
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

/**
 * displays time range and calculates duration
 *
 * @param timeRange data to display
 * @param modifier The modifier to be applied to the FlowRow
 */
@OptIn(ExperimentalTime::class)
@Composable
fun TimeRangeText(
    timeRange: TimeRange,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {

        Text(
            text =
                if (timeRange.endTime != null) {
                    stringResource(
                        Res.string.time_range,
                        timeRange.startTime.toMonthYearText(),
                        timeRange.endTime.toMonthYearText(),
                    )
                } else {
                    stringResource(
                        Res.string.time_range_present,
                        timeRange.startTime.toMonthYearText(),
                    )
                },
        )
        if (timeRange.showDuration) {
            val diff = (timeRange.endTime ?: Clock.System.now().toLocalDateTime(
                TimeZone.currentSystemDefault()
            ).date).minus(timeRange.startTime)
            val months = diff.months + if (diff.days >= 30) 1 else 0

            Text(
                modifier = modifier,
                text = stringResource(
                    Res.string.time_range_duration,
                    diff.years, months,
                ),
            )
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
private fun LocalDate.toMonthYearText(): String {
    val monthNames = MonthNames(
        stringResource(Res.string.month_january).ifEmpty { "month_january" },
        stringResource(Res.string.month_february).ifEmpty { "month_february" },
        stringResource(Res.string.month_march).ifEmpty { "month_march" },
        stringResource(Res.string.month_april).ifEmpty { "month_april" },
        stringResource(Res.string.month_may).ifEmpty { "month_may" },
        stringResource(Res.string.month_june).ifEmpty { "month_june" },
        stringResource(Res.string.month_july).ifEmpty { "month_july" },
        stringResource(Res.string.month_august).ifEmpty { "month_august" },
        stringResource(Res.string.month_september).ifEmpty { "month_september" },
        stringResource(Res.string.month_october).ifEmpty { "month_october" },
        stringResource(Res.string.month_november).ifEmpty { "month_november" },
        stringResource(Res.string.month_december).ifEmpty { "month_december" },
    )
    val dateFormat = LocalDate.Format {
        monthName(monthNames)
        char(' ')
        year()
    }
    return dateFormat.format(this)
}
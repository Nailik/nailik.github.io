@file:OptIn(ExperimentalUuidApi::class)

package de.eller.kilian

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material.icons.filled.ViewTimeline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.SpaceDashboard
import androidx.compose.material.icons.outlined.ViewTimeline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import de.eller.kilian.Skill.Android
import de.eller.kilian.Skill.ApolloGraphql
import de.eller.kilian.Skill.Apple
import de.eller.kilian.Skill.Bluetooth
import de.eller.kilian.Skill.ComposeMultiplatform
import de.eller.kilian.Skill.Firebase
import de.eller.kilian.Skill.Flutter
import de.eller.kilian.Skill.Gitlab
import de.eller.kilian.Skill.GooglePlayStore
import de.eller.kilian.Skill.HomeAssistant
import de.eller.kilian.Skill.JetpackCompose
import de.eller.kilian.Skill.Jira
import de.eller.kilian.Skill.Koin
import de.eller.kilian.Skill.Kotlin
import de.eller.kilian.Skill.KotlinMultiplatform
import de.eller.kilian.Skill.Ktor
import de.eller.kilian.Skill.Processing
import de.eller.kilian.Skill.Python
import de.eller.kilian.Skill.Sqlite
import de.eller.kilian.Skill.Xamarin
import de.eller.kilian.WorkProjects.FLEODRIVER
import de.eller.kilian.WorkProjects.HABBL
import de.eller.kilian.WorkProjects.HEY_OBI
import de.eller.kilian.components.BulletCardData
import de.eller.kilian.flags.FlagDE
import de.eller.kilian.flags.FlagEN
import de.eller.kilian.flags.Flags
import de.eller.kilian.logos.LogoAndroid
import de.eller.kilian.logos.LogoApolloGraphql
import de.eller.kilian.logos.LogoApple
import de.eller.kilian.logos.LogoBluetooth
import de.eller.kilian.logos.LogoComposeMultiplatform
import de.eller.kilian.logos.LogoEikona
import de.eller.kilian.logos.LogoEikonaDarkMode
import de.eller.kilian.logos.LogoFirebase
import de.eller.kilian.logos.LogoFleetBoard
import de.eller.kilian.logos.LogoFlutter
import de.eller.kilian.logos.LogoGitHub
import de.eller.kilian.logos.LogoGitLab
import de.eller.kilian.logos.LogoGooglePlayStore
import de.eller.kilian.logos.LogoHomeAssistant
import de.eller.kilian.logos.LogoHsFulda
import de.eller.kilian.logos.LogoJetpackCompose
import de.eller.kilian.logos.LogoJira
import de.eller.kilian.logos.LogoKMP
import de.eller.kilian.logos.LogoKoin
import de.eller.kilian.logos.LogoKotlin
import de.eller.kilian.logos.LogoKtor
import de.eller.kilian.logos.LogoLinkedIn
import de.eller.kilian.logos.LogoObi
import de.eller.kilian.logos.LogoProcessing
import de.eller.kilian.logos.LogoPython
import de.eller.kilian.logos.LogoSQLite
import de.eller.kilian.logos.LogoStackOverflow
import de.eller.kilian.logos.LogoUniWue
import de.eller.kilian.logos.LogoXamarin
import de.eller.kilian.logos.LogoXing
import de.eller.kilian.logos.Logos
import de.eller.kilian.navigation.AboutEntry
import de.eller.kilian.navigation.HomeEntry
import de.eller.kilian.navigation.NavItem
import de.eller.kilian.navigation.ProjectsEntry
import de.eller.kilian.navigation.TimelineEntry
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.education_fulda_degree
import de.eller.kilian.resources.education_fulda_description
import de.eller.kilian.resources.education_fulda_field
import de.eller.kilian.resources.education_fulda_university
import de.eller.kilian.resources.education_wue_field
import de.eller.kilian.resources.education_wue_university
import de.eller.kilian.resources.employer_eikona_company
import de.eller.kilian.resources.employer_eikona_job_description
import de.eller.kilian.resources.employer_eikona_job_title
import de.eller.kilian.resources.employer_eikona_location
import de.eller.kilian.resources.employer_fleetboard_company
import de.eller.kilian.resources.employer_fleetboard_job_description
import de.eller.kilian.resources.employer_fleetboard_job_title
import de.eller.kilian.resources.employer_fleetboard_location
import de.eller.kilian.resources.employer_obi_company
import de.eller.kilian.resources.employer_obi_job_description
import de.eller.kilian.resources.employer_obi_job_title
import de.eller.kilian.resources.employer_obi_location
import de.eller.kilian.resources.language_picker_english
import de.eller.kilian.resources.language_picker_german
import de.eller.kilian.resources.nav_item_title_about
import de.eller.kilian.resources.nav_item_title_home
import de.eller.kilian.resources.nav_item_title_projects
import de.eller.kilian.resources.nav_item_title_timeline
import de.eller.kilian.resources.project_battleship_description
import de.eller.kilian.resources.project_battleship_title
import de.eller.kilian.resources.project_bialetti_bullet_card_0_item_0
import de.eller.kilian.resources.project_bialetti_bullet_card_0_item_1
import de.eller.kilian.resources.project_bialetti_bullet_card_0_item_2
import de.eller.kilian.resources.project_bialetti_bullet_card_0_item_3
import de.eller.kilian.resources.project_bialetti_bullet_card_0_title
import de.eller.kilian.resources.project_bialetti_bullet_card_key_features_item_0
import de.eller.kilian.resources.project_bialetti_bullet_card_key_features_item_1
import de.eller.kilian.resources.project_bialetti_bullet_card_key_features_item_2
import de.eller.kilian.resources.project_bialetti_bullet_card_key_features_item_3
import de.eller.kilian.resources.project_bialetti_bullet_card_key_features_title
import de.eller.kilian.resources.project_bialetti_description
import de.eller.kilian.resources.project_bialetti_title
import de.eller.kilian.resources.project_bitwarden_description
import de.eller.kilian.resources.project_bitwarden_title
import de.eller.kilian.resources.project_diyscale_bullet_card_0_item_0
import de.eller.kilian.resources.project_diyscale_bullet_card_0_item_1
import de.eller.kilian.resources.project_diyscale_bullet_card_0_item_2
import de.eller.kilian.resources.project_diyscale_bullet_card_0_item_3
import de.eller.kilian.resources.project_diyscale_bullet_card_0_title
import de.eller.kilian.resources.project_diyscale_bullet_card_1_item_0
import de.eller.kilian.resources.project_diyscale_bullet_card_1_item_1
import de.eller.kilian.resources.project_diyscale_bullet_card_1_item_2
import de.eller.kilian.resources.project_diyscale_bullet_card_1_item_3
import de.eller.kilian.resources.project_diyscale_bullet_card_1_title
import de.eller.kilian.resources.project_diyscale_bullet_card_2_item_0
import de.eller.kilian.resources.project_diyscale_bullet_card_2_item_1
import de.eller.kilian.resources.project_diyscale_bullet_card_2_item_2
import de.eller.kilian.resources.project_diyscale_bullet_card_2_item_3
import de.eller.kilian.resources.project_diyscale_bullet_card_2_title
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_item_0
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_item_1
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_item_2
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_item_3
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_item_4
import de.eller.kilian.resources.project_diyscale_bullet_card_key_features_title
import de.eller.kilian.resources.project_diyscale_description
import de.eller.kilian.resources.project_diyscale_description_long
import de.eller.kilian.resources.project_diyscale_img_0
import de.eller.kilian.resources.project_diyscale_img_1
import de.eller.kilian.resources.project_diyscale_img_2
import de.eller.kilian.resources.project_diyscale_img_3
import de.eller.kilian.resources.project_diyscale_img_4
import de.eller.kilian.resources.project_diyscale_title
import de.eller.kilian.resources.project_rhasspy_description
import de.eller.kilian.resources.project_rhasspy_title
import de.eller.kilian.resources.project_vmm_description
import de.eller.kilian.resources.project_vmm_title
import de.eller.kilian.resources.skill_android
import de.eller.kilian.resources.skill_apollo_graphql
import de.eller.kilian.resources.skill_apple
import de.eller.kilian.resources.skill_bluetooth
import de.eller.kilian.resources.skill_compose_multiplatform
import de.eller.kilian.resources.skill_firebase
import de.eller.kilian.resources.skill_flutter
import de.eller.kilian.resources.skill_github
import de.eller.kilian.resources.skill_gitlab
import de.eller.kilian.resources.skill_google_play_store
import de.eller.kilian.resources.skill_home_assistant
import de.eller.kilian.resources.skill_jetpack_compose
import de.eller.kilian.resources.skill_jira
import de.eller.kilian.resources.skill_koin
import de.eller.kilian.resources.skill_kotlin
import de.eller.kilian.resources.skill_kotlin_multiplatform
import de.eller.kilian.resources.skill_ktor
import de.eller.kilian.resources.skill_processing
import de.eller.kilian.resources.skill_python
import de.eller.kilian.resources.skill_sqlite
import de.eller.kilian.resources.skill_xamarin
import de.eller.kilian.resources.social_github
import de.eller.kilian.resources.social_linkedin
import de.eller.kilian.resources.social_mail
import de.eller.kilian.resources.social_stackoverflow
import de.eller.kilian.resources.social_xing
import de.eller.kilian.resources.thumbnail_project_battleship
import de.eller.kilian.resources.thumbnail_project_bialetti
import de.eller.kilian.resources.thumbnail_project_bitwarden
import de.eller.kilian.resources.thumbnail_project_diyscale
import de.eller.kilian.resources.thumbnail_project_rhasspy
import de.eller.kilian.resources.thumbnail_project_vmm
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_0_item_0
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_0_item_1
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_0_item_2
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_0_item_3
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_0_title
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_1_item_0
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_1_item_1
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_1_item_2
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_1_item_3
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_1_title
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_impact_item_0
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_impact_item_1
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_impact_item_2
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_impact_item_3
import de.eller.kilian.resources.work_project_fleodriver_bullet_card_impact_title
import de.eller.kilian.resources.work_project_fleodriver_introduction
import de.eller.kilian.resources.work_project_habbl_0
import de.eller.kilian.resources.work_project_habbl_1
import de.eller.kilian.resources.work_project_habbl_2
import de.eller.kilian.resources.work_project_habbl_3
import de.eller.kilian.resources.work_project_habbl_4
import de.eller.kilian.resources.work_project_habbl_bullet_card_0_item_0
import de.eller.kilian.resources.work_project_habbl_bullet_card_0_item_1
import de.eller.kilian.resources.work_project_habbl_bullet_card_0_item_2
import de.eller.kilian.resources.work_project_habbl_bullet_card_0_title
import de.eller.kilian.resources.work_project_habbl_bullet_card_1_item_0
import de.eller.kilian.resources.work_project_habbl_bullet_card_1_item_1
import de.eller.kilian.resources.work_project_habbl_bullet_card_1_item_2
import de.eller.kilian.resources.work_project_habbl_bullet_card_1_title
import de.eller.kilian.resources.work_project_habbl_bullet_card_2_item_0
import de.eller.kilian.resources.work_project_habbl_bullet_card_2_item_1
import de.eller.kilian.resources.work_project_habbl_bullet_card_2_item_2
import de.eller.kilian.resources.work_project_habbl_bullet_card_2_title
import de.eller.kilian.resources.work_project_habbl_bullet_card_3_item_0
import de.eller.kilian.resources.work_project_habbl_bullet_card_3_item_1
import de.eller.kilian.resources.work_project_habbl_bullet_card_3_item_2
import de.eller.kilian.resources.work_project_habbl_bullet_card_3_title
import de.eller.kilian.resources.work_project_habbl_bullet_card_impact_item_0
import de.eller.kilian.resources.work_project_habbl_bullet_card_impact_item_1
import de.eller.kilian.resources.work_project_habbl_bullet_card_impact_item_2
import de.eller.kilian.resources.work_project_habbl_bullet_card_impact_title
import de.eller.kilian.resources.work_project_habbl_introduction
import de.eller.kilian.resources.work_project_hey_obi_0
import de.eller.kilian.resources.work_project_hey_obi_1
import de.eller.kilian.resources.work_project_hey_obi_2
import de.eller.kilian.resources.work_project_hey_obi_3
import de.eller.kilian.resources.work_project_hey_obi_4
import de.eller.kilian.resources.work_project_hey_obi_5
import de.eller.kilian.resources.work_project_hey_obi_6
import de.eller.kilian.resources.work_project_hey_obi_7
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_0_item_0
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_0_item_1
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_0_item_2
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_0_item_3
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_0_title
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_1_item_0
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_1_item_1
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_1_item_2
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_1_item_3
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_1_title
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_2_item_0
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_2_item_1
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_2_item_2
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_2_item_3
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_2_title
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_3_item_0
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_3_item_1
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_3_item_2
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_3_item_3
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_3_title
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_item_0
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_item_1
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_item_2
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_item_3
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_item_4
import de.eller.kilian.resources.work_project_hey_obi_bullet_card_impact_title
import de.eller.kilian.resources.work_project_hey_obi_introduction
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import kotlin.uuid.ExperimentalUuidApi

/**
 * Items in navigation rail or bottom navigation bar
 */
enum class NavItems(
    val title: StringResource,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val destination: NavItem,
) {

    Home(
        title = Res.string.nav_item_title_home,
        icon = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home,
        destination = HomeEntry,
    ),

    Projects(
        title = Res.string.nav_item_title_projects,
        icon = Icons.Outlined.SpaceDashboard,
        iconSelected = Icons.Filled.SpaceDashboard,
        destination = ProjectsEntry,
    ),

    Timeline(
        title = Res.string.nav_item_title_timeline,
        icon = Icons.Outlined.ViewTimeline,
        iconSelected = Icons.Filled.ViewTimeline,
        destination = TimelineEntry,
    ),
    About(
        title = Res.string.nav_item_title_about,
        icon = Icons.Outlined.Info,
        iconSelected = Icons.Filled.Info,
        destination = AboutEntry,
    );
}

/**
 * Anything displayed on home screen
 */
data object Home {
    val cvUri: String = "https://raw.githubusercontent.com/Nailik/nailik.github.io/refs/heads/main/docs/composeResources/de.eller.kilian.resources/files/CV_Kilian_Eller.pdf"
}

/**
 * Socials displayed as actions in top app bar
 */
enum class Social(
    val uri: String,
    val title: StringResource,
    val icon: ImageVector,
    val hasColor: Boolean = true,
) {
    LinkedIn(
        uri = "https://www.linkedin.com/in/kilian-eller/",
        title = Res.string.social_linkedin,
        icon = Logos.LogoLinkedIn,
    ),
    Xing(
        uri = "https://www.xing.com/profile/Kilian_Eller",
        title = Res.string.social_xing,
        icon = Logos.LogoXing,
    ),
    Github(
        uri = "https://github.com/Nailik",
        title = Res.string.social_github,
        icon = Logos.LogoGitHub,
    ),
    StackOverflow(
        uri = "https://stackoverflow.com/users/2456270/kilian-eller",
        title = Res.string.social_stackoverflow,
        icon = Logos.LogoStackOverflow,
    ),
    Mail(
        uri = "mailto:mail@kilianeller.de",
        title = Res.string.social_mail,
        icon = Icons.Filled.Mail,
        hasColor = false,
    );
}

/**
 * Languages displayed as actions in top app bar
 */
enum class Languages(
    val title: StringResource,
    val icon: ImageVector,
    val locale: String,
) {
    GERMAN(
        title = Res.string.language_picker_german,
        icon = Flags.FlagDE,
        locale = "de-DE",
    ),
    ENGLISH(
        title = Res.string.language_picker_english,
        icon = Flags.FlagEN,
        locale = "en-GB",
    );
}

/**
 * employers with information
 *
 * @property key used for identification in browser url history
 */
enum class Employer(
    val key: String,
    val company: StringResource,
    val jobTitle: StringResource,
    val jobDescription: StringResource,
    val location: StringResource,
    val iconLightMode: ImageVector,
    val iconDarkMode: ImageVector = iconLightMode,
    val timeRange: TimeRange,
    val projects: ImmutableList<WorkProjects>,
) {
    OBI(
        key = "OBI",
        company = Res.string.employer_obi_company,
        jobTitle = Res.string.employer_obi_job_title,
        jobDescription = Res.string.employer_obi_job_description,
        location = Res.string.employer_obi_location,
        timeRange = TimeRange(
            showDuration = true,
            startTime = LocalDate(2022, 11, 1),
            endTime = null,
        ),
        iconLightMode = Logos.LogoObi,
        projects = persistentListOf(HEY_OBI),
    ),

    FLEETBOARD(
        key = "Fleetboard",
        company = Res.string.employer_fleetboard_company,
        jobTitle = Res.string.employer_fleetboard_job_title,
        jobDescription = Res.string.employer_fleetboard_job_description,
        location = Res.string.employer_fleetboard_location,
        timeRange = TimeRange(
            showDuration = true,
            startTime = LocalDate(2019, 3, 1),
            endTime = LocalDate(2022, 10, 31),
        ),
        projects = persistentListOf(FLEODRIVER, HABBL),
        iconLightMode = Logos.LogoFleetBoard,
    ),

    Eikona(
        key = "Eikona",
        company = Res.string.employer_eikona_company,
        jobTitle = Res.string.employer_eikona_job_title,
        jobDescription = Res.string.employer_eikona_job_description,
        location = Res.string.employer_eikona_location,
        timeRange = TimeRange(
            showDuration = true,
            startTime = LocalDate(2017, 5, 1),
            endTime = LocalDate(2019, 3, 31),
        ),
        iconLightMode = Logos.LogoEikona,
        iconDarkMode = Logos.LogoEikonaDarkMode,
        projects = persistentListOf(HABBL),
    );

    val skills: ImmutableList<Skill> = projects.flatMap { it.skills }.distinct().toImmutableList()

    val icon: ImageVector @Composable get() = if (LocalDarkModeScope.current) iconDarkMode else iconLightMode
}

/**
 * Projects at different companies
 *
 * Not directly coupled to company due to project acquisition
 */
@Serializable
enum class WorkProjects(
    val skills: ImmutableList<Skill>,
    val images: ImmutableList<DrawableResource>,
    val introduction: StringResource,
    val playStoreUrl: String?,
    val bulletCardData: ImmutableList<BulletCardData>,
    val impact: BulletCardData,
) {
    HEY_OBI(
        skills = persistentListOf(
            Android,
            KotlinMultiplatform,
            ComposeMultiplatform,
            Koin,
            Ktor,
            Sqlite,
            Gitlab,
            Jira,
            Firebase,
            Apple
        ),
        images = persistentListOf(
            Res.drawable.work_project_hey_obi_0,
            Res.drawable.work_project_hey_obi_1,
            Res.drawable.work_project_hey_obi_2,
            Res.drawable.work_project_hey_obi_3,
            Res.drawable.work_project_hey_obi_4,
            Res.drawable.work_project_hey_obi_5,
            Res.drawable.work_project_hey_obi_6,
            Res.drawable.work_project_hey_obi_7,
        ),
        introduction = Res.string.work_project_hey_obi_introduction,
        bulletCardData = persistentListOf(
            BulletCardData(
                title = Res.string.work_project_hey_obi_bullet_card_0_title,
                icon = Logos.LogoComposeMultiplatform,
                bullets = persistentListOf(
                    Res.string.work_project_hey_obi_bullet_card_0_item_0,
                    Res.string.work_project_hey_obi_bullet_card_0_item_1,
                    Res.string.work_project_hey_obi_bullet_card_0_item_2,
                    Res.string.work_project_hey_obi_bullet_card_0_item_3
                )
            ), BulletCardData(
                title = Res.string.work_project_hey_obi_bullet_card_1_title,
                icon = Logos.LogoGitLab,
                bullets = persistentListOf(
                    Res.string.work_project_hey_obi_bullet_card_1_item_0,
                    Res.string.work_project_hey_obi_bullet_card_1_item_1,
                    Res.string.work_project_hey_obi_bullet_card_1_item_2,
                    Res.string.work_project_hey_obi_bullet_card_1_item_3
                )
            ), BulletCardData(
                title = Res.string.work_project_hey_obi_bullet_card_2_title,
                icon = Logos.LogoFirebase,
                bullets = persistentListOf(
                    Res.string.work_project_hey_obi_bullet_card_2_item_0,
                    Res.string.work_project_hey_obi_bullet_card_2_item_1,
                    Res.string.work_project_hey_obi_bullet_card_2_item_2,
                    Res.string.work_project_hey_obi_bullet_card_2_item_3
                )
            ), BulletCardData(
                title = Res.string.work_project_hey_obi_bullet_card_3_title,
                icon = Logos.LogoAndroid,
                bullets = persistentListOf(
                    Res.string.work_project_hey_obi_bullet_card_3_item_0,
                    Res.string.work_project_hey_obi_bullet_card_3_item_1,
                    Res.string.work_project_hey_obi_bullet_card_3_item_2,
                    Res.string.work_project_hey_obi_bullet_card_3_item_3
                )
            )
        ),

        impact = BulletCardData(
            title = Res.string.work_project_hey_obi_bullet_card_impact_title,
            icon = Logos.LogoObi,
            bullets = persistentListOf(
                Res.string.work_project_hey_obi_bullet_card_impact_item_0,
                Res.string.work_project_hey_obi_bullet_card_impact_item_1,
                Res.string.work_project_hey_obi_bullet_card_impact_item_2,
                Res.string.work_project_hey_obi_bullet_card_impact_item_3,
                Res.string.work_project_hey_obi_bullet_card_impact_item_4,
            )
        ),

        playStoreUrl = "https://play.google.com/store/apps/details?id=de.obi.app"
    ),
    FLEODRIVER(
        skills = persistentListOf(
            Android,
            KotlinMultiplatform,
            JetpackCompose,
            Sqlite,
            ApolloGraphql,
            Jira,
            GooglePlayStore,
            Gitlab,
            Flutter,
            Xamarin,
            Apple,
        ),
        playStoreUrl = null,
        images = persistentListOf(),
        introduction = Res.string.work_project_fleodriver_introduction,
        bulletCardData = persistentListOf(
            BulletCardData(
                title = Res.string.work_project_fleodriver_bullet_card_0_title,
                icon = Logos.LogoKMP,
                bullets = persistentListOf(
                    Res.string.work_project_fleodriver_bullet_card_0_item_0,
                    Res.string.work_project_fleodriver_bullet_card_0_item_1,
                    Res.string.work_project_fleodriver_bullet_card_0_item_2,
                    Res.string.work_project_fleodriver_bullet_card_0_item_3
                )
            ), BulletCardData(
                title = Res.string.work_project_fleodriver_bullet_card_1_title,
                icon = Logos.LogoSQLite,
                bullets = persistentListOf(
                    Res.string.work_project_fleodriver_bullet_card_1_item_0,
                    Res.string.work_project_fleodriver_bullet_card_1_item_1,
                    Res.string.work_project_fleodriver_bullet_card_1_item_2,
                    Res.string.work_project_fleodriver_bullet_card_1_item_3
                )
            )
        ),

        impact = BulletCardData(
            title = Res.string.work_project_fleodriver_bullet_card_impact_title,
            icon = Logos.LogoFleetBoard,
            bullets = persistentListOf(
                Res.string.work_project_fleodriver_bullet_card_impact_item_0,
                Res.string.work_project_fleodriver_bullet_card_impact_item_1,
                Res.string.work_project_fleodriver_bullet_card_impact_item_2,
                Res.string.work_project_fleodriver_bullet_card_impact_item_3,
            )
        )
    ),
    HABBL(
        skills = persistentListOf(Android, Kotlin, Jira, Gitlab, GooglePlayStore, Xamarin),
        images = persistentListOf(
            Res.drawable.work_project_habbl_0,
            Res.drawable.work_project_habbl_1,
            Res.drawable.work_project_habbl_2,
            Res.drawable.work_project_habbl_3,
            Res.drawable.work_project_habbl_4,
        ),
        introduction = Res.string.work_project_habbl_introduction,
        bulletCardData = persistentListOf(
            BulletCardData(
                title = Res.string.work_project_habbl_bullet_card_0_title,
                icon = Logos.LogoKotlin,
                bullets = persistentListOf(
                    Res.string.work_project_habbl_bullet_card_0_item_0,
                    Res.string.work_project_habbl_bullet_card_0_item_1,
                    Res.string.work_project_habbl_bullet_card_0_item_2
                )
            ), BulletCardData(
                title = Res.string.work_project_habbl_bullet_card_1_title,
                icon = Logos.LogoAndroid,
                bullets = persistentListOf(
                    Res.string.work_project_habbl_bullet_card_1_item_0,
                    Res.string.work_project_habbl_bullet_card_1_item_1,
                    Res.string.work_project_habbl_bullet_card_1_item_2
                )
            ), BulletCardData(
                title = Res.string.work_project_habbl_bullet_card_2_title,
                icon = Logos.LogoXamarin,
                bullets = persistentListOf(
                    Res.string.work_project_habbl_bullet_card_2_item_0,
                    Res.string.work_project_habbl_bullet_card_2_item_1,
                    Res.string.work_project_habbl_bullet_card_2_item_2
                )
            ), BulletCardData(
                title = Res.string.work_project_habbl_bullet_card_3_title,
                icon = Logos.LogoJira,
                bullets = persistentListOf(
                    Res.string.work_project_habbl_bullet_card_3_item_0,
                    Res.string.work_project_habbl_bullet_card_3_item_1,
                    Res.string.work_project_habbl_bullet_card_3_item_2
                )
            )
        ),

        impact = BulletCardData(
            title = Res.string.work_project_habbl_bullet_card_impact_title,
            icon = Logos.LogoEikona,
            iconDarkMode = Logos.LogoEikonaDarkMode,
            bullets = persistentListOf(
                Res.string.work_project_habbl_bullet_card_impact_item_0,
                Res.string.work_project_habbl_bullet_card_impact_item_1,
                Res.string.work_project_habbl_bullet_card_impact_item_2,
            )
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=com.habbl"
    )
}

/**
 * education information
 *
 * @property key used for identification in browser url history
 */
enum class Education(
    val key: String,
    val university: StringResource,
    val field: StringResource,
    val degree: StringResource?,
    val description: StringResource?,
    val timeRange: TimeRange,
    val icon: ImageVector,
    val skills: ImmutableList<Skill>?,
) {
    FULDA(
        key = "FhFulda",
        university = Res.string.education_fulda_university,
        field = Res.string.education_fulda_field,
        degree = Res.string.education_fulda_degree,
        description = Res.string.education_fulda_description,
        timeRange = TimeRange(
            showDuration = false,
            startTime = LocalDate(2018, 10, 1),
            endTime = LocalDate(2022, 9, 30),
        ),
        skills = persistentListOf(Kotlin, Android),
        icon = Logos.LogoHsFulda,
    ),

    WUE(
        key = "UniWuerzburg",
        university = Res.string.education_wue_university,
        field = Res.string.education_wue_field,
        degree = null,
        description = null,
        timeRange = TimeRange(
            showDuration = false,
            startTime = LocalDate(2016, 10, 1),
            endTime = LocalDate(2018, 10, 31),
        ),
        skills = null,
        icon = Logos.LogoUniWue,
    )
}

/**
 * private open source projects information
 *
 * @property key used for identification in browser url history
 */
@Serializable
@OptIn(ExperimentalUuidApi::class)
enum class Project(
    val key: String,
    val title: StringResource,
    val image: DrawableResource,
    val description: StringResource,
    val skills: ImmutableList<Skill>,
    val isContribution: Boolean,
    val thumbnails: ImmutableList<DrawableResource>,
    val introduction: StringResource,
    val url: String,
    val bulletCardData: ImmutableList<BulletCardData>,
    val outcome: BulletCardData?,
    val skipDetail: Boolean,
) {
    @SerialName("Bitwarden")
    BITWARDEN(
        key = "Bitwarden",
        title = Res.string.project_bitwarden_title,
        image = Res.drawable.thumbnail_project_bitwarden,
        description = Res.string.project_bitwarden_description,
        skills = persistentListOf(Android, Kotlin),
        isContribution = true,
        introduction = Res.string.project_bitwarden_description,
        url = "https://github.com/bitwarden/android",
        thumbnails = persistentListOf(),
        bulletCardData = persistentListOf(),
        outcome = null,
        skipDetail = true,
    ),

    @SerialName("Rhasspy")
    RHASSPY(
        key = "Rhasspy",
        title = Res.string.project_rhasspy_title,
        image = Res.drawable.thumbnail_project_rhasspy,
        description = Res.string.project_rhasspy_description,
        skills = persistentListOf(
            Android,
            KotlinMultiplatform,
            ComposeMultiplatform,
            Ktor,
            GooglePlayStore,
            Apple
        ),
        isContribution = false,
        introduction = Res.string.project_rhasspy_description,
        url = "https://github.com/Nailik/rhasspy_mobile",
        thumbnails = persistentListOf(),
        bulletCardData = persistentListOf(),
        outcome = null,
        skipDetail = true,
    ),

    @SerialName("VogelsMotionMount")
    VMM(
        key = "VogelsMotionMount",
        title = Res.string.project_vmm_title,
        image = Res.drawable.thumbnail_project_vmm,
        description = Res.string.project_vmm_description,
        skills = persistentListOf(Python, HomeAssistant, Bluetooth),
        isContribution = false,
        introduction = Res.string.project_vmm_description,
        url = "https://github.com/Nailik/vogels_motion_mount_ble",
        thumbnails = persistentListOf(),
        bulletCardData = persistentListOf(),
        outcome = null,
        skipDetail = true,
    ),

    @SerialName("Battleship")
    BATTLESHIP(
        key = "Battleship",
        title = Res.string.project_battleship_title,
        image = Res.drawable.thumbnail_project_battleship,
        description = Res.string.project_battleship_description,
        skills = persistentListOf(KotlinMultiplatform, Ktor, Processing),
        isContribution = false,
        introduction = Res.string.project_battleship_description,
        url = "https://github.com/Nailik/battleship",
        thumbnails = persistentListOf(),
        bulletCardData = persistentListOf(),
        outcome = null,
        skipDetail = true,
    ),

    @SerialName("Diyscale")
    DIYSCALE(
        key = "Diyscale",
        title = Res.string.project_diyscale_title,
        image = Res.drawable.thumbnail_project_diyscale,
        description = Res.string.project_diyscale_description,
        skills = persistentListOf(Bluetooth),
        isContribution = false,
        introduction = Res.string.project_diyscale_description_long,
        url = "https://github.com/Nailik/DIY-Scale",
        outcome = BulletCardData(
            title = Res.string.project_diyscale_bullet_card_key_features_title,
            icon = Icons.Default.QuestionMark,
            bullets = persistentListOf(
                Res.string.project_diyscale_bullet_card_key_features_item_0,
                Res.string.project_diyscale_bullet_card_key_features_item_1,
                Res.string.project_diyscale_bullet_card_key_features_item_2,
                Res.string.project_diyscale_bullet_card_key_features_item_3,
                Res.string.project_diyscale_bullet_card_key_features_item_4,
            ),
        ),
        bulletCardData = persistentListOf(
            BulletCardData(
                title = Res.string.project_diyscale_bullet_card_0_title,
                icon = Icons.Default.QuestionMark,
                bullets = persistentListOf(
                    Res.string.project_diyscale_bullet_card_0_item_0,
                    Res.string.project_diyscale_bullet_card_0_item_1,
                    Res.string.project_diyscale_bullet_card_0_item_2,
                    Res.string.project_diyscale_bullet_card_0_item_3,
                )
            ),
            BulletCardData(
                title = Res.string.project_diyscale_bullet_card_1_title,
                icon = Icons.Default.QuestionMark,
                bullets = persistentListOf(
                    Res.string.project_diyscale_bullet_card_1_item_0,
                    Res.string.project_diyscale_bullet_card_1_item_1,
                    Res.string.project_diyscale_bullet_card_1_item_2,
                    Res.string.project_diyscale_bullet_card_1_item_3,
                )
            ),
            BulletCardData(
                title = Res.string.project_diyscale_bullet_card_2_title,
                icon = Icons.Default.QuestionMark,
                bullets = persistentListOf(
                    Res.string.project_diyscale_bullet_card_2_item_0,
                    Res.string.project_diyscale_bullet_card_2_item_1,
                    Res.string.project_diyscale_bullet_card_2_item_2,
                    Res.string.project_diyscale_bullet_card_2_item_3,
                )
            ),
        ),
        thumbnails = persistentListOf(
            Res.drawable.thumbnail_project_diyscale,
            Res.drawable.project_diyscale_img_0,
            Res.drawable.project_diyscale_img_1,
            Res.drawable.project_diyscale_img_2,
            Res.drawable.project_diyscale_img_3,
            Res.drawable.project_diyscale_img_4,
        ),
        skipDetail = true,
    ),

    @SerialName("Bialetti")
    BIALETTI(
        key = "Bialetti",
        title = Res.string.project_bialetti_title,
        image = Res.drawable.thumbnail_project_bialetti,
        description = Res.string.project_bialetti_description,
        skills = persistentListOf(Bluetooth),
        isContribution = false,
        introduction = Res.string.project_bialetti_description,
        url = "https://github.com/Nailik/bialetti_eletrikka",
        outcome = BulletCardData(
            title = Res.string.project_bialetti_bullet_card_key_features_title,
            icon = Icons.Default.QuestionMark,
            bullets = persistentListOf(
                Res.string.project_bialetti_bullet_card_key_features_item_0,
                Res.string.project_bialetti_bullet_card_key_features_item_1,
                Res.string.project_bialetti_bullet_card_key_features_item_2,
                Res.string.project_bialetti_bullet_card_key_features_item_3,
            )
        ),
        bulletCardData = persistentListOf(
            BulletCardData(
                title = Res.string.project_bialetti_bullet_card_0_title,
                icon = Icons.Default.QuestionMark,
                bullets = persistentListOf(
                    Res.string.project_bialetti_bullet_card_0_item_0,
                    Res.string.project_bialetti_bullet_card_0_item_1,
                    Res.string.project_bialetti_bullet_card_0_item_2,
                    Res.string.project_bialetti_bullet_card_0_item_3,
                ),
            ),
        ),
        thumbnails = persistentListOf(),
        skipDetail = true,
    ),
}

/**
 * Skills to be showcased and referenced by projects
 */
enum class Skill(
    val title: StringResource,
    val icon: ImageVector,
) {
    Android(
        title = Res.string.skill_android,
        icon = Logos.LogoAndroid,
    ),
    Kotlin(
        title = Res.string.skill_kotlin,
        icon = Logos.LogoKotlin,
    ),
    KotlinMultiplatform(
        title = Res.string.skill_kotlin_multiplatform,
        icon = Logos.LogoKMP,
    ),
    JetpackCompose(
        title = Res.string.skill_jetpack_compose,
        icon = Logos.LogoJetpackCompose,
    ),
    ComposeMultiplatform(
        title = Res.string.skill_compose_multiplatform,
        icon = Logos.LogoComposeMultiplatform,
    ),
    Koin(
        title = Res.string.skill_koin,
        icon = Logos.LogoKoin,
    ),
    Ktor(
        title = Res.string.skill_ktor,
        icon = Logos.LogoKtor,
    ),
    Sqlite(
        title = Res.string.skill_sqlite,
        icon = Logos.LogoSQLite,
    ),
    ApolloGraphql(
        title = Res.string.skill_apollo_graphql,
        icon = Logos.LogoApolloGraphql,
    ),
    Firebase(
        title = Res.string.skill_firebase,
        icon = Logos.LogoFirebase,
    ),
    GooglePlayStore(
        title = Res.string.skill_google_play_store,
        icon = Logos.LogoGooglePlayStore,
    ),
    Jira(
        title = Res.string.skill_jira,
        icon = Logos.LogoJira,
    ),
    Gitlab(
        title = Res.string.skill_gitlab,
        icon = Logos.LogoGitLab,
    ),
    Github(
        title = Res.string.skill_github,
        icon = Logos.LogoGitHub,
    ),
    Apple(
        title = Res.string.skill_apple,
        icon = Logos.LogoApple,
    ),
    Bluetooth(
        title = Res.string.skill_bluetooth,
        icon = Logos.LogoBluetooth,
    ),
    Flutter(
        title = Res.string.skill_flutter,
        icon = Logos.LogoFlutter,
    ),
    Xamarin(
        title = Res.string.skill_xamarin,
        icon = Logos.LogoXamarin,
    ),
    HomeAssistant(
        title = Res.string.skill_home_assistant,
        icon = Logos.LogoHomeAssistant,
    ),
    Python(
        title = Res.string.skill_python,
        icon = Logos.LogoPython,
    ),
    Processing(
        title = Res.string.skill_processing,
        icon = Logos.LogoProcessing,
    );
}

/**
 * used for time range reference for employer and education history
 */
@Stable
data class TimeRange(
    val showDuration: Boolean,
    val startTime: LocalDate,
    val endTime: LocalDate?,
)

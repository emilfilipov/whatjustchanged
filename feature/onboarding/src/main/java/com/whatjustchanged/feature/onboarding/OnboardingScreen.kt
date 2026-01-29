package com.whatjustchanged.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.whatjustchanged.core.ui.AppColors
import com.whatjustchanged.core.ui.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    val scope = rememberCoroutineScope()

    // Dummy state for interactions
    var selectedInterests by remember { mutableStateOf(setOf<String>()) }
    var selectedWatches by remember { mutableStateOf(setOf<String>()) }
    var appleToggle by remember { mutableStateOf(false) }
    var majorUpdatesToggle by remember { mutableStateOf(false) }
    var gainToggle by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.BackgroundPrimary)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> WelcomeStep(
                    onContinue = {
                        scope.launch { pagerState.animateScrollToPage(1) }
                    }
                )
                1 -> InterestsStep(
                    selectedInterests = selectedInterests,
                    onInterestToggle = { interest ->
                        selectedInterests = if (selectedInterests.contains(interest)) {
                            selectedInterests - interest
                        } else {
                            selectedInterests + interest
                        }
                    },
                    onContinue = {
                        scope.launch { pagerState.animateScrollToPage(2) }
                    }
                )
                2 -> WatchlistStep(
                    selectedWatches = selectedWatches,
                    onWatchToggle = { watch ->
                        selectedWatches = if (selectedWatches.contains(watch)) {
                            selectedWatches - watch
                        } else {
                            selectedWatches + watch
                        }
                    },
                    onContinue = {
                        scope.launch { pagerState.animateScrollToPage(3) }
                    }
                )
                3 -> AlertPreferencesStep(
                    appleToggle = appleToggle,
                    majorUpdatesToggle = majorUpdatesToggle,
                    gainToggle = gainToggle,
                    onAppleToggle = { appleToggle = it },
                    onMajorUpdatesToggle = { majorUpdatesToggle = it },
                    onGainToggle = { gainToggle = it },
                    onContinue = {
                        scope.launch { pagerState.animateScrollToPage(4) }
                    }
                )
                4 -> FirstAlertStep(
                    onExplore = onGetStartedClick
                )
            }
        }
    }
}

@Composable
fun WelcomeStep(onContinue: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Markd Logo",
                modifier = Modifier.height(32.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "When the official sites change, you'll know.",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "We monitor regulatory filings, policy changes, and terms of service.",
                style = MaterialTheme.typography.bodyLarge,
                color = AppColors.TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "No noise. No spam.",
                style = MaterialTheme.typography.bodyLarge,
                color = AppColors.TextSecondary
            )
        }

        Column {
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.AccentPrimary,
                    contentColor = AppColors.ButtonTextPrimary
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Get started",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Already a trusted user.",
                style = MaterialTheme.typography.labelSmall,
                color = AppColors.TextHelper,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun InterestsStep(
    selectedInterests: Set<String>,
    onInterestToggle: (String) -> Unit,
    onContinue: () -> Unit
) {
    val interests = listOf(
        InterestItem("Following a company or Big Tech", Icons.Default.Star),
        InterestItem("Tracking sector trends", Icons.Default.KeyboardArrowUp),
        InterestItem("Keeping up with economic policy", Icons.Default.Search),
        InterestItem("Monitoring regulations and policies", Icons.Default.Info)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "What matters to you?",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            interests.forEach { interest ->
                InterestCard(
                    title = interest.title,
                    icon = interest.icon,
                    isSelected = selectedInterests.contains(interest.title),
                    onClick = { onInterestToggle(interest.title) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Let's ensure we only alert you about things in your lane.",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
        }

        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.AccentPrimary,
                contentColor = AppColors.ButtonTextPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Continue",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun WatchlistStep(
    selectedWatches: Set<String>,
    onWatchToggle: (String) -> Unit,
    onContinue: () -> Unit
) {
    val popularWatches = listOf("Apple", "Meta", "Google", "Tesla")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Add what you want to watch.",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Start with some popular watches:",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            popularWatches.forEach { watch ->
                WatchItem(
                    name = watch,
                    isSelected = selectedWatches.contains(watch),
                    onToggle = { onWatchToggle(watch) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Delivery: Email (Supports Push)",
                style = MaterialTheme.typography.labelMedium,
                color = AppColors.TextHelper
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Add push notifications for immediate alerts.",
                style = MaterialTheme.typography.labelSmall,
                color = AppColors.TextHelper
            )
        }

        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.AccentPrimary,
                contentColor = AppColors.ButtonTextPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Continue",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun AlertPreferencesStep(
    appleToggle: Boolean,
    majorUpdatesToggle: Boolean,
    gainToggle: Boolean,
    onAppleToggle: (Boolean) -> Unit,
    onMajorUpdatesToggle: (Boolean) -> Unit,
    onGainToggle: (Boolean) -> Unit,
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Set your alert preferences.",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            PreferenceToggle(
                title = "Apple",
                subtitle = "You'll be notified when:",
                isChecked = appleToggle,
                onCheckedChange = onAppleToggle
            )

            Spacer(modifier = Modifier.height(16.dp))

            PreferenceToggle(
                title = "Major updates are filed",
                subtitle = null,
                isChecked = majorUpdatesToggle,
                onCheckedChange = onMajorUpdatesToggle
            )

            Spacer(modifier = Modifier.height(16.dp))

            PreferenceToggle(
                title = "Gain mode",
                subtitle = null,
                isChecked = gainToggle,
                onCheckedChange = onGainToggle
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "All other alerts will be sent by default.",
                style = MaterialTheme.typography.labelSmall,
                color = AppColors.TextHelper
            )
        }

        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.AccentPrimary,
                contentColor = AppColors.ButtonTextPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Continue",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun FirstAlertStep(onExplore: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Nice. We just sent your first alert.",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            AlertPreviewCard()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Even when they don't send alerts, you can see already.",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Go to my updates.",
                style = MaterialTheme.typography.labelMedium,
                color = AppColors.AccentPrimary,
                modifier = Modifier.clickable { /* Navigate to updates */ }
            )
        }

        Button(
            onClick = onExplore,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.AccentPrimary,
                contentColor = AppColors.ButtonTextPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Explore this change",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun InterestCard(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected) AppColors.WarmHighlightBackground
                else AppColors.CardBackground
            )
            .border(
                width = 1.dp,
                color = if (isSelected) AppColors.AccentPrimary else AppColors.Divider,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AppColors.TextSecondary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = AppColors.TextPrimary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun WatchItem(
    name: String,
    isSelected: Boolean,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            color = AppColors.TextPrimary
        )
        Switch(
            checked = isSelected,
            onCheckedChange = { onToggle() },
            colors = SwitchDefaults.colors(
                checkedThumbColor = AppColors.ButtonTextPrimary,
                checkedTrackColor = AppColors.AccentPrimary,
                uncheckedThumbColor = AppColors.TextHelper,
                uncheckedTrackColor = AppColors.Divider
            )
        )
    }
}

@Composable
fun PreferenceToggle(
    title: String,
    subtitle: String?,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextPrimary
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = AppColors.TextSecondary
                )
            }
        }
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = AppColors.ButtonTextPrimary,
                checkedTrackColor = AppColors.AccentPrimary,
                uncheckedThumbColor = AppColors.TextHelper,
                uncheckedTrackColor = AppColors.Divider
            )
        )
    }
}

@Composable
fun AlertPreviewCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.CardBackground)
            .padding(20.dp)
    ) {
        Text(
            text = "Apple filed an annual disclosure regarding last year's report.",
            style = MaterialTheme.typography.bodyLarge,
            color = AppColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "This is a required filing.",
            style = MaterialTheme.typography.labelMedium,
            color = AppColors.TextSecondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "View original filing.",
            style = MaterialTheme.typography.labelMedium,
            color = AppColors.AccentPrimary,
            modifier = Modifier.clickable { /* Open link */ }
        )
    }
}

data class InterestItem(val title: String, val icon: ImageVector)

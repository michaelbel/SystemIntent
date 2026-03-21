@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.systemnav

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.michaelbel.systemintent.R

@Composable
fun MainActivityContent() {
    val context = LocalContext.current
    val packageManager = context.packageManager
    val packageName = context.packageName
    val packageUri = Uri.parse("package:$packageName")

    val panelInternetIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
    val panelWifiIntent = Intent(Settings.Panel.ACTION_WIFI)
    val panelVolumeIntent = Intent(Settings.Panel.ACTION_VOLUME)
    val panelNfcIntent = Intent(Settings.Panel.ACTION_NFC)

    val appDetailsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
    val appLocaleIntent = Intent(Settings.ACTION_APP_LOCALE_SETTINGS, packageUri)
    val appOpenByDefaultIntent = Intent(Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS, packageUri)
    val appNotificationIntent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
        .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    val appNotificationBubbleIntent = Intent(Settings.ACTION_APP_NOTIFICATION_BUBBLE_SETTINGS)
        .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    val appNotificationPromotionIntent = Intent(Settings.ACTION_APP_NOTIFICATION_PROMOTION_SETTINGS)
        .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    val appUsageIntent = Intent(Settings.ACTION_APP_USAGE_SETTINGS)
        .putExtra(Intent.EXTRA_PACKAGE_NAME, packageName)
    val appFullScreenIntentIntent = Intent(Settings.ACTION_MANAGE_APP_USE_FULL_SCREEN_INTENT, packageUri)

    val allAppsNotificationIntent = Intent(Settings.ACTION_ALL_APPS_NOTIFICATION_SETTINGS)
    val notificationListenerIntent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
    val notificationPolicyIntent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
    val usageAccessIntent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)

    val batterySaverIntent = Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS)
    val ignoreBatteryOptimizationIntent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
    val requestIgnoreBatteryOptimizationIntent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, packageUri)
    val backgroundDataRestrictionsIntent = Intent(Settings.ACTION_IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS, packageUri)
    val exactAlarmIntent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM, packageUri)
    val overlayIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, packageUri)
    val writeSettingsIntent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, packageUri)
    val unknownSourcesIntent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageUri)

    val wirelessIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
    val wifiIntent = Intent(Settings.ACTION_WIFI_SETTINGS)
    val bluetoothIntent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
    val nfcIntent = Intent(Settings.ACTION_NFC_SETTINGS)
    val nfcPaymentIntent = Intent(Settings.ACTION_NFC_PAYMENT_SETTINGS)
    val airplaneModeIntent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
    val vpnIntent = Intent(Settings.ACTION_VPN_SETTINGS)
    val satelliteIntent = Intent(Settings.ACTION_SATELLITE_SETTING)
    val castIntent = Intent(Settings.ACTION_CAST_SETTINGS)

    val settingsIntent = Intent(Settings.ACTION_SETTINGS)
    val applicationSettingsIntent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
    val manageApplicationsIntent = Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS)
    val manageAllApplicationsIntent = Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS)
    val manageDefaultAppsIntent = Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS)
    val developmentIntent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
    val securityIntent = Intent(Settings.ACTION_SECURITY_SETTINGS)
    val privacyIntent = Intent(Settings.ACTION_PRIVACY_SETTINGS)
    val accessibilityIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    val locationIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
    val displayIntent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
    val soundIntent = Intent(Settings.ACTION_SOUND_SETTINGS)
    val storageIntent = Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS)
    val dataUsageIntent = Intent(Settings.ACTION_DATA_USAGE_SETTINGS)
    val deviceInfoIntent = Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
    val webViewIntent = Intent(Settings.ACTION_WEBVIEW_SETTINGS)
    val homeIntent = Intent(Settings.ACTION_HOME_SETTINGS)
    val inputMethodIntent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name)
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Text(
                    text = "Панели",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = panelInternetIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(panelInternetIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Интернет"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = panelWifiIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(panelWifiIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Wi-Fi"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = satelliteIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(satelliteIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Спутниковая связь"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = panelVolumeIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(panelVolumeIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Громкость"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = panelNfcIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(panelNfcIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "NFC"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
            item {
                Text(
                    text = "Текущее приложение",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = appDetailsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appDetailsIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Информация о приложении"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appLocaleIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appLocaleIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Локаль приложения"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appOpenByDefaultIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appOpenByDefaultIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Открывать по умолчанию"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appNotificationIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appNotificationIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Уведомления приложения"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appNotificationBubbleIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appNotificationBubbleIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Bubble-уведомления"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appNotificationPromotionIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appNotificationPromotionIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Продвигаемые уведомления"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = appUsageIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appUsageIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Использование приложения"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = appFullScreenIntentIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(appFullScreenIntentIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Полноэкранные уведомления"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
            item {
                Text(
                    text = "Уведомления и доступ",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = allAppsNotificationIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(allAppsNotificationIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Все уведомления"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = notificationListenerIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(notificationListenerIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Доступ к уведомлениям"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = notificationPolicyIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(notificationPolicyIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Не беспокоить: доступ"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = usageAccessIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(usageAccessIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Доступ к статистике использования"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
            item {
                Text(
                    text = "Батарея и спецдоступ",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = batterySaverIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(batterySaverIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Энергосбережение"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = ignoreBatteryOptimizationIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(ignoreBatteryOptimizationIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Игнорирование оптимизации батареи"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = requestIgnoreBatteryOptimizationIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(requestIgnoreBatteryOptimizationIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Запросить отключение оптимизации"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = backgroundDataRestrictionsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(backgroundDataRestrictionsIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Фоновые данные приложения"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = exactAlarmIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(exactAlarmIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Точные будильники"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = overlayIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(overlayIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Поверх других окон"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = writeSettingsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(writeSettingsIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Изменение системных настроек"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = unknownSourcesIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(unknownSourcesIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Установка из неизвестных источников"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
            item {
                Text(
                    text = "Подключения",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = wirelessIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(wirelessIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Беспроводные сети"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = wifiIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(wifiIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Wi-Fi"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = bluetoothIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(bluetoothIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Bluetooth"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = nfcIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(nfcIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "NFC"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = nfcPaymentIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(nfcPaymentIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "NFC-оплата"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = airplaneModeIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(airplaneModeIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Режим полета"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = vpnIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(vpnIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "VPN"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = castIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(castIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Cast"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
            item {
                Text(
                    text = "Система",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 4.dp, bottomEnd = 4.dp))
                        .clickable(enabled = settingsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(settingsIntent)
                        },
                    headlineContent = {
                        Text(
                            text = "Основные настройки"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = applicationSettingsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(applicationSettingsIntent)
                        },
                    headlineContent = {
                        Text(text = "Настройки приложений")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = manageApplicationsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(manageApplicationsIntent)
                        },
                    headlineContent = {
                        Text(text = "Управление приложениями")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = manageAllApplicationsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(manageAllApplicationsIntent)
                        },
                    headlineContent = {
                        Text(text = "Все приложения")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = manageDefaultAppsIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(manageDefaultAppsIntent)
                        },
                    headlineContent = {
                        Text(text = "Приложения по умолчанию")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = developmentIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(developmentIntent)
                        },
                    headlineContent = {
                        Text(text = "Для разработчиков")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = securityIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(securityIntent)
                        },
                    headlineContent = {
                        Text(text = "Безопасность")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = privacyIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(privacyIntent)
                        },
                    headlineContent = {
                        Text(text = "Конфиденциальность")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = accessibilityIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(accessibilityIntent)
                        },
                    headlineContent = {
                        Text(text = "Спецвозможности")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = locationIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(locationIntent)
                        },
                    headlineContent = {
                        Text(text = "Геолокация")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = displayIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(displayIntent)
                        },
                    headlineContent = {
                        Text(text = "Экран")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = soundIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(soundIntent)
                        },
                    headlineContent = {
                        Text(text = "Звук")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = storageIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(storageIntent)
                        },
                    headlineContent = {
                        Text(text = "Хранилище")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = dataUsageIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(dataUsageIntent)
                        },
                    headlineContent = {
                        Text(text = "Использование данных")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = deviceInfoIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(deviceInfoIntent)
                        },
                    headlineContent = {
                        Text(text = "Об устройстве")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = webViewIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(webViewIntent)
                        },
                    headlineContent = {
                        Text(text = "WebView")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .clickable(enabled = homeIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(homeIntent)
                        },
                    headlineContent = {
                        Text(text = "Главный экран")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                        .clickable(enabled = inputMethodIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(inputMethodIntent)
                        },
                    headlineContent = {
                        Text(text = "Клавиатура и ввод")
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                )
            }
        }
    }
}

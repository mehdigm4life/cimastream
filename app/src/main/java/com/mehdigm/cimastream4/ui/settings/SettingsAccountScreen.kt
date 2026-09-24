package com.mehdigm.cimastream4.ui.settings

import android.content.Context
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.FragmentActivity
import com.mehdigm.cimastream4.CommonActivity.activity
import com.mehdigm.cimastream4.CommonActivity.onDialogDismissedEvent
import com.mehdigm.cimastream4.R
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.aniListApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.animeSkipApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.kitsuApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.malApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.openSubtitlesApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.simklApi
import com.mehdigm.cimastream4.syncproviders.AccountManager.Companion.subDlApi
import com.mehdigm.cimastream4.syncproviders.PlainAuthRepo
import com.mehdigm.cimastream4.syncproviders.SubtitleRepo
import com.mehdigm.cimastream4.syncproviders.SyncRepo
import com.mehdigm.cimastream4.ui.settings.SettingsAccount.Companion.addAccount
import com.mehdigm.cimastream4.ui.settings.SettingsAccount.Companion.showLoginInfo
import com.mehdigm.cimastream4.utils.AppContextUtils.html
import com.mehdigm.cimastream4.utils.BackupUtils
import com.mehdigm.cimastream4.utils.BiometricAuthenticator
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.authCallback
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.biometricPrompt
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.deviceHasPasswordPinLock
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.isAuthEnabled
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.promptInfo
import com.mehdigm.cimastream4.utils.BiometricAuthenticator.startBiometricAuthentication
import com.mehdigm.cimastream4.utils.SingleSelectionHelper.showBottomDialogText
import com.mehdigm.cimastream4.AppSettings
import com.mehdigm.cimastream4.compose.PHONE
import com.mehdigm.cimastream4.compose.isLayout
import com.mehdigm.cimastream4.rememberAppSettings
import com.mihon.presentation.settings.Preference
import com.mihon.presentation.settings.SearchableSettings
import kotlinx.collections.immutable.persistentListOf

object SettingsAccountScreen : SearchableSettings, BiometricAuthenticator.BiometricCallback {
    val syncApis = persistentListOf(
        SyncRepo(malApi),
        SyncRepo(kitsuApi),
        SyncRepo(aniListApi),
        SyncRepo(simklApi),
        SubtitleRepo(openSubtitlesApi),
        SubtitleRepo(subDlApi),
        PlainAuthRepo(animeSkipApi),
    )
    private fun updateAuthPreference(context: Context, enabled: Boolean) {
        val settings = AppSettings(context)
        settings.security.biometrics.set(enabled)
    }

    override fun onAuthenticationError() {
        val context = activity ?: return
        updateAuthPreference(context, !isAuthEnabled(context))
    }

    override fun onAuthenticationSuccess() {
        val context = activity ?: return

        if (isAuthEnabled(context)) {
            updateAuthPreference(context, true)
            BackupUtils.backup(context)
            context.showBottomDialogText(
                context.getString(R.string.biometric_setting),
                context.getString(R.string.biometric_warning).html()
            ) { onDialogDismissedEvent }
        } else {
            updateAuthPreference(context, false)
        }
    }

    @Composable
    override fun getTitleRes(): String = stringResource(R.string.category_account)

    @Composable
    override fun getPreferences(): List<Preference> {
        val settings = rememberAppSettings()
        val activity = LocalActivity.current
        val context = LocalContext.current
        val hasSecurity = remember(context) {
            try {
                deviceHasPasswordPinLock(context)
            } catch (_ : Throwable) {
                // e.g preview
                false
            }
        }

        return persistentListOf(
            Preference.PreferenceGroup(
                title = stringResource(R.string.pref_category_accounts),
                preferenceItems = syncApis.map { api ->
                    Preference.PreferenceItem.TextPreference(
                        title = api.name,
                        icon = api.icon?.let { painterResource(it) },
                        onClick = {
                            val activity = activity ?: return@TextPreference
                            val info = api.authUser()
                            val index =
                                api.accounts.indexOfFirst { account -> account.user.id == info?.id }
                            if (api.accounts.isNotEmpty()) {
                                showLoginInfo(activity, api, info, index)
                            } else {
                                addAccount(activity, api)
                            }
                        })
                } + Preference.PreferenceItem.SwitchPreference(
                    preference = settings.security.skipAccountSelection,
                    title = stringResource(R.string.skip_startup_account_select_pref),
                    icon = painterResource(R.drawable.ic_outline_account_circle_24)
                ),
            ), Preference.PreferenceGroup(
                enabled = hasSecurity && isLayout(PHONE),
                title = stringResource(R.string.pref_category_security),
                preferenceItems = persistentListOf(
                    Preference.PreferenceItem.SwitchPreference(
                        preference = settings.security.biometrics,
                        title = stringResource(R.string.biometric_setting),
                        subtitle = stringResource(R.string.biometric_setting_summary),
                        icon = painterResource(R.drawable.ic_fingerprint),
                        onValueChanged = { _ ->
                            val activity =
                                activity as? FragmentActivity ?: return@SwitchPreference false

                            if (deviceHasPasswordPinLock(activity)) {
                                startBiometricAuthentication(
                                    activity, R.string.biometric_authentication_title, false
                                )
                                promptInfo?.let {
                                    authCallback = this
                                    biometricPrompt?.authenticate(it)
                                }
                            }

                            return@SwitchPreference true
                        })
                )
            )
        )
    }
}
package ru.bimbom.stackcheckapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.rustore.sdk.pushclient.RuStorePushClient

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RuStorePushClient.init(
            this,
            "asdasdasdasdasdasdasd",
        )
    }
}
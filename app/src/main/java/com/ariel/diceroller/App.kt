package com.ariel.diceroller

import android.app.Application
import com.yandex.mobile.ads.common.MobileAds

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Configure the user privacy data policy before init sdk
        MobileAds.initialize(this) {
            // now you can use ads
        }
    }
}
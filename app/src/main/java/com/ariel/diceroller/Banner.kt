package com.ariel.diceroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
//import com.google.android.gms.ads.AdSize
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
//import com.yandex.mobile.ads.AdSize


@Composable
fun Banner(id:Int) {
    AndroidView(factory = {context ->
        BannerAdView(context).apply{
            setAdUnitId(context.getString(id))
            setAdSize(BannerAdSize.stickySize(context,320))
            val adRequest = AdRequest.Builder().build()
            loadAd(adRequest)
        }
    })
}
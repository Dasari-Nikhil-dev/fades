package com.example.fades.ui.theme

import android.app.Application
import android.os.Build
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder

class FadesApp : Application(), SingletonImageLoader.Factory {
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context)
            .components {
                add(GifDecoder.Factory()) // For Coil 3
                // add(coil.decode.GifDecoder.Factory()) // For Coil 2
                // Potentially add ImageDecoderDecoder for API 28+ if not already handled by default
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                    add(AnimatedImageDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            // Add other global configurations here if needed
            // .okHttpClient { ... }
            // .memoryCache { ... }
            // .diskCache { ... }
            .build()
    }
}
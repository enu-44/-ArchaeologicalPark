package com.hannerenuardevelopers.usuario.archaeologicalpark.lib.di

import android.app.Activity
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import org.greenrobot.eventbus.Subscribe;

@Module
class LibsModule(activity: Activity) {

    var activity: Activity
    init {
        this.activity = activity
    }

    @Provides
    @Singleton
    fun provideEventBus(): EventBus {
        return GreenRobotEventBus()
    }

    @Provides
    @Singleton
    fun provideImageLoader(activity: Activity?): ImageLoader {
        val imageLoader = GlideImageLoader()
        if (activity != null) {
            imageLoader.setLoaderContext(activity)
        }
        return imageLoader
    }

    @Provides
    @Singleton
    fun provideActivity(): Activity {
        return this.activity
    }
}
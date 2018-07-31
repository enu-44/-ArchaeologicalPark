package com.hannerenuardevelopers.usuario.archaeologicalpark.lib


import android.app.Activity
import android.util.Log
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import java.util.*


 class GlideImageLoader:ImageLoader {
    private var glideRequestManager: RequestManager? = null
     var onFinishedImageLoadingListener: RequestListener<*, *>? = null

     fun setLoaderContext(activity: Activity) {
        this.glideRequestManager = Glide.with(activity)
    }

    override fun load(imageView: ImageView, URL: String) {
        if (onFinishedImageLoadingListener != null) {
            glideRequestManager!!
                    .load(URL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .listener(onFinishedImageLoadingListener as RequestListener<in String, GlideDrawable>?)
                    .into(imageView)
        } else {
            glideRequestManager!!
                    .load(URL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imageView)
        }
    }

}
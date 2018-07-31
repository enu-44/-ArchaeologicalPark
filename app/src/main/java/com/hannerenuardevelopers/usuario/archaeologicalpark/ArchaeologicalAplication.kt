package com.hannerenuardevelopers.usuario.archaeologicalpark

import android.app.Application
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.IMainViewActivity
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.MainActivity
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.OnItemClickListener
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di.DaggerUsuarioMainComponent
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di.UsuarioMainComponent
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di.UsuarioMainModule
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.di.LibsModule

class ArchaeologicalAplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //initDB()
        //initFacebook()
    }

    override fun onTerminate() {
        super.onTerminate()
        //DBTearDown()
    }

    fun getUsuarioListComponent(activity: MainActivity, view: IMainViewActivity.MainView,onItemClickListener: OnItemClickListener): UsuarioMainComponent {
        return DaggerUsuarioMainComponent
                .builder()
                .libsModule(LibsModule(activity))
                .usuarioMainModule(UsuarioMainModule(view,onItemClickListener))
                .build()
    }
}
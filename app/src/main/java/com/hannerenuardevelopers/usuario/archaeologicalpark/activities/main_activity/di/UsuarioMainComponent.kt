package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di

import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.IMainViewActivity
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.UsuarioAdapter
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.di.LibsModule
import dagger.Component
import javax.inject.Singleton



@Singleton
@Component(modules = arrayOf(UsuarioMainModule::class, LibsModule::class))
interface UsuarioMainComponent {
    //void inject(RecipeMainActivity activity);
    //val imageLoader: ImageLoader
    fun getPresenter(): IMainViewActivity.Presenter
    fun getAdapter(): UsuarioAdapter
}

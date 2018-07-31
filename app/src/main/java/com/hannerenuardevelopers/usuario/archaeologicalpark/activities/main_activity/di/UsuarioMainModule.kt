package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di

import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.IMainViewActivity
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.MainInteractor
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.MainPresenter
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.MainRepository
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.OnItemClickListener
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.UsuarioAdapter
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.EventBus
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.ImageLoader
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario
import dagger.Module
import dagger.Provides
import java.util.ArrayList
import javax.inject.Singleton


@Module
class UsuarioMainModule(view:IMainViewActivity.MainView,onItemClickListener: OnItemClickListener) {

    var view: IMainViewActivity.MainView
     var onItemClickListener: OnItemClickListener
    init {
        this.view = view
        this.onItemClickListener=onItemClickListener
    }


    @Provides
    @Singleton
    fun provideUsuarioMainViews(): IMainViewActivity.MainView {
        return this.view
    }

    @Provides
    @Singleton
    fun provideUsuarioMainPresenter(eventBus: EventBus, view: IMainViewActivity.MainView, interactor: IMainViewActivity.Interactor): IMainViewActivity.Presenter {
        return MainPresenter(eventBus, view, interactor)
    }

    @Provides
    @Singleton
    fun provideUsuarioInteractor(repository: IMainViewActivity.Repository):IMainViewActivity.Interactor {
        return  MainInteractor(repository)
    }


    @Provides
    @Singleton
    fun provideUsuarioListRepository(eventBus: EventBus): IMainViewActivity.Repository {
        return MainRepository(eventBus)
    }

    @Provides
    @Singleton
    internal fun provideOnItemClickListener(): OnItemClickListener {
        return this.onItemClickListener
    }

    @Provides
    @Singleton
    fun provideRecipesAdapter(recipes: List<Usuario>,imageLoader: ImageLoader,  onItemClickListener: OnItemClickListener): UsuarioAdapter {
        return UsuarioAdapter(recipes, onItemClickListener,imageLoader)
    }


    /*@Provides
    @Singleton
    internal fun provideRecipesAdapter(recipes: List<Recipe>, imageLoader: ImageLoader, onItemClickListener: OnItemClickListener): RecipesAdapter {
        return RecipesAdapter(recipes, imageLoader, onItemClickListener)
    }

    @Provides
    @Singleton
    internal fun provideOnItemClickListener(): OnItemClickListener {
        return this.onItemClickListener
    }*/

    @Provides
    @Singleton
    fun provideRecipesList(): List<Usuario> {
        return ArrayList<Usuario>()
    }


}

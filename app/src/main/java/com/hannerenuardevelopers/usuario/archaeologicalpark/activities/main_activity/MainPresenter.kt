package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity

import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.events.UsuarioEvents
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.EventBus
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario
import org.greenrobot.eventbus.Subscribe

class MainPresenter (eventBus:EventBus,view:IMainViewActivity.MainView,interactor:IMainViewActivity.Interactor):IMainViewActivity.Presenter {

    var mainView:IMainViewActivity.MainView?
    var eventBus: EventBus
    var interactor:IMainViewActivity.Interactor

    init {
        this.mainView=view
        this.eventBus=eventBus
        this.interactor=interactor
    }

    override fun onCreate() {
        eventBus.register(this)
    }

    override fun onDestroy() {
        eventBus.unregister(this)
        mainView = null
    }

    @Subscribe
    override fun onEventMainThread(event: UsuarioEvents) {
        when (event?.eventType) {

            UsuarioEvents.ERROR_EVENT -> {

            }

            UsuarioEvents.READ_EVENT -> {
                val list = event.mutableList as List<Usuario>
                mainView?.setUsuarios(list)
            }
        }
    }

    override fun getListUsers() {
        interactor.execute()
    }
}
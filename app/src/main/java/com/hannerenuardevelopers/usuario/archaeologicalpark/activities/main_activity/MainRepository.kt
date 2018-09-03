package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity


import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.events.UsuarioEvents
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.EventBus
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario
import com.hannerenuardevelopers.usuario.archaeologicalpark.resources.Listas


class MainRepository (eventBus: EventBus):IMainViewActivity.Repository {

    var eventBuss: EventBus
    init {
        this.eventBuss=eventBus
    }

    override fun getListUsers() {
        val usuarios=Listas.listUsuarios()
        postEventListUsers(UsuarioEvents.READ_EVENT,usuarios)
    }


    //Events
    private fun postEventListUsers(type: Int, usuarios: List<Usuario>?) {
        val usuariosListMitable = usuarios as MutableList<Any>
        postEvent(type, usuariosListMitable,null,null)

    }

    //Main Post Event
    private fun postEvent(type: Int, listModel1: MutableList<Any>?, model: Object?, errorMessage: String?) {
        val event = UsuarioEvents(type, listModel1, model, errorMessage)
        //event.eventType = type
        eventBuss?.post(event)
    }
    //endregion
}
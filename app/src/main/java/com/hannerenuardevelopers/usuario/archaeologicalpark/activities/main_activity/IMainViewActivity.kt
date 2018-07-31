package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity

import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.events.UsuarioEvents
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario

interface IMainViewActivity {

    interface MainView  {
        fun setUsuarios(data:List<Usuario>);
    }

    interface Presenter{
        fun onCreate()
        fun onDestroy()
        fun onEventMainThread(event: UsuarioEvents)
        fun getListUsers()
    }

    interface Interactor{
         fun execute()
    }

    interface Repository{
        fun getListUsers()
    }
}
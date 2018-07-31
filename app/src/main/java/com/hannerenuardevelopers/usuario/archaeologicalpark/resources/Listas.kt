package com.hannerenuardevelopers.usuario.archaeologicalpark.resources

import com.hannerenuardevelopers.usuario.archaeologicalpark.R
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario

class Listas {
    companion object {
        fun listUsuarios(): ArrayList<Usuario> {
            val listUsuarios = ArrayList<Usuario>()
            //lista_menu_comprador.add(ItemLista("Asistencia Técnica", Imagen = R.drawable.ic_asistencia_tecnica_color_500, Identificador = "asistencia_tecnica"))
            listUsuarios.add(Usuario(Id = 0,Nombre = "Enuar",Apellido = "Muñoz", Imagen = "http://www.etudiant-voyageur.fr/wp-content/uploads/2016/03/22160_20081105134923_halong_moi_.jpg"))
            listUsuarios.add(Usuario(Id = 0,Nombre = "Jose",Apellido = "Ortega",Imagen ="https://i.ytimg.com/vi/hW9PUzl7j9w/maxresdefault.jpg"))
            listUsuarios.add(Usuario(Id = 0,Nombre = "Alberto",Apellido = "Imbachi",Imagen = "https://img-aws.ehowcdn.com/877x500p/photos.demandstudios.com/getty/article/170/99/89676488.jpg"))
            return listUsuarios
        }
    }
}
package com.hannerenuardevelopers.usuario.archaeologicalpark.models

data class Usuario(var Id:Int= 0,var Nombre:String? = null,var Apellido:String?=null, var Imagen: String) {

    override fun toString(): String {
        return String.format("%s %s", Nombre,Apellido)
    }
}
package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.events



data class UsuarioEvents(var eventType: Int,
                         var mutableList: MutableList<Any>? = null,
                         var objectMutable: Object? = null,
                         var mensajeError: String?
) {
    companion object {
        val SAVE_EVENT: Int = 1
        val READ_EVENT: Int = 2
        val ERROR_EVENT: Int = 3

        // fun <T> listen(eventType:Class<T>): Observable<T> = publisher.ofType(eventType)
    }
}
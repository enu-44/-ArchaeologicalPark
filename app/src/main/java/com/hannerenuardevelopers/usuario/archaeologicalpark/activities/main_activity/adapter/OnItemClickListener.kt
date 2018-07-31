package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter

import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario

interface OnItemClickListener {
     fun onItemClick(usuario: Usuario)
     fun onDeleteClick(usuario: Usuario)
}
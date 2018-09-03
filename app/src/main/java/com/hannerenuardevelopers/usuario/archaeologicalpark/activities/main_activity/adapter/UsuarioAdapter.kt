package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.hannerenuardevelopers.usuario.archaeologicalpark.R
import com.hannerenuardevelopers.usuario.archaeologicalpark.lib.ImageLoader
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario


class UsuarioAdapter(var lista: List<Usuario>, var onItemClickListener:OnItemClickListener, var imageLoader:ImageLoader ) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Llama al método del holder para cargar los items
        holder.bindItems(lista[position], position,onItemClickListener,imageLoader)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_list_user, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setItems(newItems: List<Usuario>) {
        //lista.addAll(newItems)
        lista=newItems
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(data: Usuario, pos: Int, listener:OnItemClickListener,imageLoader:ImageLoader) = with(itemView) {

            val txt_title: TextView = itemView.findViewById(R.id.txtTitle)
            val txt_descripcion: TextView = itemView.findViewById(R.id.txtDescription)
            val icon: ImageView = itemView.findViewById(R.id.contentIcon)
            val btnDelete: ImageButton = itemView.findViewById(R.id.btnAction3)


            imageLoader.load(icon,data.Imagen)
            //icon.setImageResource(R.drawable.ic_account_box)
            txt_title.text = data.Nombre
            txt_descripcion.setText(data.Apellido)
            btnDelete.setColorFilter(getContext().getResources().getColor(R.color.colorAccent))

            itemView.setOnClickListener(View.OnClickListener { listener.onItemClick(data) })
            btnDelete.setOnClickListener(View.OnClickListener { listener.onDeleteClick(data) })

        }
    }
}


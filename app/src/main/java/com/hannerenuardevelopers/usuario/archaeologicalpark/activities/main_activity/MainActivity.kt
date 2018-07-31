package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.hannerenuardevelopers.usuario.archaeologicalpark.ArchaeologicalAplication
import com.hannerenuardevelopers.usuario.archaeologicalpark.R
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.add_user.AddUserActivity
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.OnItemClickListener
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.adapter.UsuarioAdapter
import com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity.di.UsuarioMainComponent
import com.hannerenuardevelopers.usuario.archaeologicalpark.models.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),IMainViewActivity.MainView, View.OnClickListener, OnItemClickListener {



    @Inject
     lateinit var presenter: IMainViewActivity.Presenter
     @Inject
     lateinit var component: UsuarioMainComponent
     @Inject
    lateinit var adapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupInjection()
        setupRecyclerView()
        presenter.onCreate()
        presenter.getListUsers()

        btnIr.setOnClickListener(this)
    }

    private fun setupRecyclerView() {
        //recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnIr->{
                val i = Intent(this, AddUserActivity::class.java)
                startActivity(i)
            }

        }
    }

    private fun setupInjection() {
        val app = application as ArchaeologicalAplication
        component = app.getUsuarioListComponent(this, this,this)
        //app.getRecipeListComponent(this, this, this).inject(this);
        presenter = getPresenterActivity()
        adapter = getAdapterr()
    }


    fun  getAdapterr():UsuarioAdapter {
        return component.getAdapter();
    }

    fun getPresenterActivity(): IMainViewActivity.Presenter {
        return component.getPresenter()
    }

    override fun setUsuarios(data: List<Usuario>) {

         adapter.setItems(data)
    }

    override fun onItemClick(usuario: Usuario) {
        Toast.makeText(this, "Edit: ${usuario.Nombre}",Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(usuario: Usuario) {
        Toast.makeText(this, "Eliminar: ${usuario.Nombre}",Toast.LENGTH_SHORT).show()
    }
}

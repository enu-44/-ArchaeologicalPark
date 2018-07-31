package com.hannerenuardevelopers.usuario.archaeologicalpark.activities.main_activity

class MainInteractor (repositoryInject:IMainViewActivity.Repository ):IMainViewActivity.Interactor {

    var  repository:IMainViewActivity.Repository;
    init {
        repository=repositoryInject
    }
    override fun execute() {
        repository.getListUsers()
    }
}
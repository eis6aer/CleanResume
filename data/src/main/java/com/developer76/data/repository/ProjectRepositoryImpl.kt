package com.developer76.data.repository

import com.developer76.domain.model.Project
import com.developer76.domain.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor() : ProjectsRepository {
    override fun saveProjects(projects: List<Project>): Completable {
        return Completable.fromAction {  }
    }

    override fun getProjects(): Single<List<Project>> {
        return Single.just(listOf())
    }
}
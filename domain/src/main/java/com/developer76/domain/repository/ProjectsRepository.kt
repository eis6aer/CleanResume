package com.developer76.domain.repository

import com.developer76.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Single

interface ProjectsRepository {
    fun getProjects(): Single<List<Project>>
    fun saveProjects(projects: List<Project>): Completable
}
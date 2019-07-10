package com.developer76.data.service

import com.developer76.data.model.ResumeRemote
import io.reactivex.Single
import retrofit2.http.GET

interface GistService {
    @GET("a8f8018049992f7570318b5e2a5d325a/raw/5ff231ca04f8699bea3e60c4ef66a304eda6ceef/resume.json")
    fun getResume(): Single<ResumeRemote>

    @GET
    fun getProjects()

    @GET
    fun getContacts()
}
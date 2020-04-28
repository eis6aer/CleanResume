package com.developer76.cleanresume.di

import com.developer76.cleanresume.mvp.main.MainContract
import com.developer76.cleanresume.mvp.main.MainModel
import com.developer76.cleanresume.mvp.main.MainPresenter
import com.developer76.cleanresume.mvp.main.MainView
import com.developer76.cleanresume.mvp.resume.ResumeContract
import com.developer76.cleanresume.mvp.resume.ResumeModel
import com.developer76.cleanresume.mvp.resume.ResumePresenter
import com.developer76.cleanresume.mvp.resume.ResumeView
import com.developer76.data.di.RepositoryModule
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class ResumeModule {

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideResumeModel(resumeModel: ResumeModel): ResumeContract.Model

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideResumeView(resumeView: ResumeView): ResumeContract.View

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideResumePresenter(resumePresenter: ResumePresenter): ResumeContract.Presenter

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideMainModel(mainModel: MainModel): MainContract.Model

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideMainView(mainView: MainView): MainContract.View

    @Binds
    // @Reusable add if SubComponent is removed
    abstract fun provideMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}
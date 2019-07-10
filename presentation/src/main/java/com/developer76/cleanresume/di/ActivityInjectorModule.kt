package com.developer76.cleanresume.di

import com.developer76.cleanresume.MainActivity
import com.developer76.cleanresume.home.ContactFragment
import com.developer76.cleanresume.home.ProjectsFragment
import com.developer76.cleanresume.home.ResumeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ResumeModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ResumeModule::class])
    abstract fun projectsFragment(): ProjectsFragment

    @ContributesAndroidInjector(modules = [ResumeModule::class])
    abstract fun contactFragment(): ContactFragment

    @ContributesAndroidInjector(modules = [ResumeModule::class])
    abstract fun resumeFragment(): ResumeFragment
}
package com.developer76.cleanresume.mvp

import com.developer76.cleanresume.mvp.resume.ResumeModel
import com.developer76.domain.model.Resume
import com.developer76.domain.usecase.ResumeUseCase
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins



class ResumeModelTest {

    @Mock
    lateinit var resumeUseCase: ResumeUseCase
    lateinit var resumeModel: ResumeModel

    var resume = Resume("Javier", "Torres", "Android Developer")

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumeModel = ResumeModel(resumeUseCase)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `when getResume is called resumeUseCase must be called`() {
        whenever(resumeUseCase.getResume()).thenReturn(Single.just(resume))

        resumeUseCase.getResume()
            .test()
            .assertValue {
                it.name == resume.name
            }
            .dispose()
    }
}